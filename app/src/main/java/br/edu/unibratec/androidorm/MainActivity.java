package br.edu.unibratec.androidorm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ollie.Model;
import ollie.query.Select;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = (EditText) findViewById(R.id.editText_nome);
        editTextEndereco = (EditText) findViewById(R.id.editText_endereco);

        Database database = new Database(this);



    }

    public void CadastrarClick(View v)
    {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(editTextNome.getText().toString());
        pessoa.setEndereco(editTextNome.getText().toString());
        long id = pessoa.save();
        try
        {
            Pessoa teste = Model.find(Pessoa.class, (long) 5);
            List<Pessoa> pessoas = Select.from(Pessoa.class).fetch();
            for (Pessoa person: pessoas)
            {
                Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e)
        {
            String a =e.getMessage();

            Toast.makeText(this, "erro " + a, Toast.LENGTH_SHORT).show();

        }
        editTextEndereco.setText("");
        editTextNome.setText("");

    }

}
