package org.douglascosta.classes;

public class Produto {
    private final int id;
    private final String nome;
    private final String descricao;
    private final int precoVenda;
    private final boolean usado;

    public Produto(int id, String nome, String descricao, int precoVenda, boolean usado){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.usado = usado;

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public boolean isUsado() {
        return usado;
    }





    public void exibirInformacao() {
        System.out.println("ID: " + getId() +
                " Nome: " + getNome() +
                " Descrição: " + getDescricao() +
                " Preço da Venda: " + getPrecoVenda() +
                " Estado: " + isUsado());
    }
}
