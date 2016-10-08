package br.edu.unibratec.androidorm;

import android.util.Log;

import java.util.List;

import ollie.Model;
import ollie.query.Select;

/**
 * Created by felipe on 08/10/16.
 */

public class PessoaDAO {

    public long salvarOuAtualizar(Pessoa pessoa)
    {
        return pessoa.save();
    }

    public List<Pessoa> listaTodasPessoas()
    {
        return Select.from(Pessoa.class).fetch();
    }

    public void excluir (Pessoa pessoa)
    {
        pessoa.delete();
    }

    public Pessoa getPessoaById(long pessoaID)
    {
       return Model.find(Pessoa.class, pessoaID);
    }
}

