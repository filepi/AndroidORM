package br.edu.unibratec.androidorm;

import android.os.Bundle;

import java.util.List;

import ollie.Model;
import ollie.query.Select;

/**
 * Created by felipe on 08/10/16.
 */

public class PessoaDAO {

    public long salvarOuAtualizar(Pessoa pessoa, boolean novoCadastro){ return pessoa.save(); }

    public List<Pessoa> listaTodasPessoas()
    {
        return Select.from(Pessoa.class).fetch();
    }

    public void excluir (Pessoa pessoa)
    {
        pessoa.delete();
    }

    public Pessoa getPessoaById(long pessoaID) { return Model.find(Pessoa.class, pessoaID); }

    public Pessoa getPessoaByNome(String nome)
    {
        Bundle args = new Bundle();
        args.putString("nome",nome);
        return Select.from(Pessoa.class).where("nome", args).fetchSingle();
    }

}

