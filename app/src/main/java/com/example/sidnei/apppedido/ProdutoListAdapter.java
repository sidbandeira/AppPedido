package com.example.sidnei.apppedido;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProdutoListAdapter extends ArrayAdapter<Produto> {
    public ProdutoListAdapter(Context context, List<Produto> objects) {
        super(context, 0, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Produto produto = getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_produto_list, null);
            holder = new ViewHolder();
            holder.txtIdProduto = (TextView)convertView.findViewById(R.id.txtIdProduto);
            holder.txtProdutoDescricao =  (TextView)convertView.findViewById(R.id.txtProdutoDescricao);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.txtIdProduto.setText(String.valueOf(produto.idProduto));
        holder.txtProdutoDescricao.setText(produto.produtoDescricao);

        return convertView;
    }
    static class ViewHolder {
        TextView txtIdProduto;
        TextView txtProdutoDescricao;

    }
}
