package br.edu.unibratec.androidorm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    public static final int REQUEST_CADASTRO_UPDATE = 0;
    private static final int REQUEST_CADASTRO_INSERT = 1;

    ListView listView;
    List<Pessoa> lstPessoa;
    PessoaAdapter adapterPessoa;
    PessoaDAO pessoaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initDatabase();

        pessoaDAO = new PessoaDAO();
        listView = (ListView) findViewById(R.id.listPessoas);
        lstPessoa = (ArrayList<Pessoa>) pessoaDAO.listaTodasPessoas();
        adapterPessoa = new PessoaAdapter(this, lstPessoa);
        listView.setAdapter(adapterPessoa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(view.getContext(), MainActivity.class);
                Pessoa pessoa = (Pessoa) adapterView.getItemAtPosition(i);
                it.putExtra(MainActivity.EXTRA_PESSOA, pessoa);
                //Gambiarra
                //forma encontrada para resgatar o id do objeto na activity de cadastrar/atualizar
                //alimentando novamente o id no objeto
                Long idExtra = pessoa.id;
                it.putExtra("ID", idExtra);
                startActivityForResult(it, REQUEST_CADASTRO_UPDATE);
            }
        });
    }


    private void initDatabase() {
        new Database(this);
    }

    public void abreTelaCadastro(View view)
    {
        Intent it = new Intent(this, MainActivity.class);
        startActivityForResult(it,REQUEST_CADASTRO_INSERT);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CADASTRO_UPDATE== requestCode && resultCode == RESULT_OK){
            updateUI();
        } else
        if (REQUEST_CADASTRO_INSERT== requestCode && resultCode == RESULT_OK){
            updateUI();
        }

    }

    private void updateUI() {
        lstPessoa.clear();
        lstPessoa. addAll ((ArrayList<Pessoa>) pessoaDAO.listaTodasPessoas());
        adapterPessoa.notifyDataSetChanged();
    }
}
