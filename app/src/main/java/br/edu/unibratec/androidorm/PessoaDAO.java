package br.edu.unibratec.androidorm;

import java.util.List;

import ollie.Model;
import ollie.query.Query;
import ollie.query.Select;

/**
 * Created by felipe on 08/10/16.
 */

public class PessoaDAO {

    public List<Pessoa> listar(){
        return Select.from(Pessoa.class).fetch();
    }

    public long salvar(Pessoa pessoa)
    {
        return pessoa.save();
    }

    public Pessoa buscar()
    {
        Pessoa pessoa = Model.find(Pessoa.class, (long) 1);
        return Select.from(Pessoa.class).fetchSingle();
    }
}
