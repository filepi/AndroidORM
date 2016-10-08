package br.edu.unibratec.androidorm;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.Table;

/**
 * Created by felipe on 08/10/16.
 */

@Table("Pessoa")
public class Pessoa extends Model {

    @Column("nome")
    public String nome;
    @Column("endereco")
    public String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "endereco='" + endereco + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
