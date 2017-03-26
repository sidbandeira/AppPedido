package com.example.sidnei.apppedido;

public class Produto {
    public int idProduto;
    public String produtoDescricao;
    public Double produtoPrecovenda;
    public Double produtoPrecoCusto;

    public Produto(int idProduto, String produtoDescricao, Double produtoPrecovenda,Double produtoPrecoCusto){
        this.idProduto = idProduto;
        this.produtoDescricao = produtoDescricao;
        this.produtoPrecovenda = produtoPrecovenda;
        this.produtoPrecoCusto = produtoPrecoCusto;
    }
}
