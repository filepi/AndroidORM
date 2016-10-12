package br.edu.unibratec.androidorm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Priscila on 09/10/2016.
 */

public class PessoaAdapter extends BaseAdapter {

    Context ctx;
    List<Pessoa> pessoas;

    public PessoaAdapter(Context ctx, List<Pessoa> pessoas) {
        this.ctx = ctx;
        this.pessoas = pessoas;
    }

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Object getItem(int i) {
        return pessoas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Pessoa pessoa = pessoas.get(i);

        View item_lst = LayoutInflater.from(ctx).inflate(R.layout.item_lista, null);
        TextView txtID = (TextView) item_lst.findViewById(R.id.txtViewID);
        TextView txtNome = (TextView) item_lst.findViewById(R.id.txtViewNome);
        TextView txtEndereco = (TextView) item_lst.findViewById(R.id.txtViewEndereco);
        txtID.setText(      "ID:   " + String.valueOf(pessoa.id).toString());
        txtNome.setText(    "Nome: " + pessoa.getNome());
        txtEndereco.setText("End:  " + pessoa.getEndereco());

        return item_lst;
    }
}
