package br.edu.unibratec.androidorm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final String EXTRA_PESSOA = "pessoa";
    EditText editTextNome;
    EditText editTextEndereco;
    Button btnCadastrar;
    PessoaDAO pessoaDAO = new PessoaDAO();
    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome = (EditText) findViewById(R.id.editText_nome);
        editTextEndereco = (EditText) findViewById(R.id.editText_endereco);
        btnCadastrar = (Button) findViewById(R.id.button_cadastrar);
        Bundle b = getIntent().getExtras();
        if(b != null)
        {
            pessoa = (Pessoa) b.get(EXTRA_PESSOA);
            //Gambiarra
            //Se reparar o campo id está nulo, abaixo seto o valor para o atributo, tornando possível a atualizacao
            pessoa.id = b.getLong("ID");
            editTextNome.setText(pessoa.getNome());
            editTextEndereco.setText(pessoa.getEndereco());
            btnCadastrar.setText(R.string.txt_atualizar);
        }
    }

    public void cadastrarOuAtualizarPessoa(View v) {

        if (pessoa == null) {
            //Novo cadastro
            Pessoa pessoaNew = new Pessoa();
            pessoaNew.setNome(editTextNome.getText().toString());
            pessoaNew.setEndereco(editTextEndereco.getText().toString());
            long id = pessoaDAO.salvarOuAtualizar(pessoaNew, true);
            Toast.makeText(this, pessoaDAO.getPessoaById(id).getNome()+ " cadastrado com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            //Atualizar Cadastro
            pessoa.setNome(editTextNome.getText().toString());
            pessoa.setEndereco(editTextEndereco.getText().toString());
            long id = pessoaDAO.salvarOuAtualizar(pessoa, false);
            Toast.makeText(this, pessoaDAO.getPessoaById(id).getNome()+ " cadastrado atualizado", Toast.LENGTH_SHORT).show();
        }
        setResult(RESULT_OK);
        finish();
    }


    private void excluir(Pessoa pessoa)
    {
        pessoa.delete();
    }

    public void removeCadastro(View view) {
        if (pessoa != null){
            excluir(pessoa);
            Toast.makeText(this, "Registro removido com sucesso", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        }
    }
}
