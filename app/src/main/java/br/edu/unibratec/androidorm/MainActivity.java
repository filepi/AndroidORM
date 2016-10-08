package br.edu.unibratec.androidorm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextEndereco;
    PessoaDAO pessoaDAO = new PessoaDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome = (EditText) findViewById(R.id.editText_nome);
        editTextEndereco = (EditText) findViewById(R.id.editText_endereco);


    }

    public void cadastrarPessoa(View v) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(editTextNome.getText().toString());
        pessoa.setEndereco(editTextNome.getText().toString());
        long id = pessoaDAO.salvarOuAtualizar(pessoa);
        Toast.makeText(this, pessoaDAO.getPessoaById(id).getNome()+ " cadastrado com sucesso", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(this, ListActivity.class);
        startActivity(it);
    }


    private void excluir(Pessoa pessoa)
    {
        pessoa.delete();
    }

}
