package br.edu.unibratec.androidorm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initDatabase();
        final PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> pessoasList = pessoaDAO.listaTodasPessoas();
        String[] values = new String[pessoasList.size()];
        for (int i = 0; i < pessoasList.size(); i++)
        {
            values[i] = pessoasList.get(i).nome;
        }
        listView = (ListView) findViewById(R.id.listPessoas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              Intent it = new Intent(view.getContext(), MainActivity.class);
                Pessoa pessoa = pessoaDAO.getPessoaById(i + 1);
                it.putExtra(MainActivity.EXTRA_PESSOA, pessoa);
                startActivity(it);
            }
        });
    }


    private void initDatabase() {
        new Database(this);
    }

    public void abreTelaCadastro(View view)
    {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}
