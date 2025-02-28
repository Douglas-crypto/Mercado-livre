package classes;

public class Produto {
    private final int id;
    private final String nome;
    private final String descricao;
    private float precoVenda;
    private int estoque;
    private final String caminhoImagem;
    private final boolean usado;

    public Produto(int id, String nome, String descricao, float precoVenda, int estoque, String caminhoImagem, boolean usado){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
        this.caminhoImagem = caminhoImagem;
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

    public int getEstoque() {
        return estoque;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }


    public void exibirInformacao() {
        System.out.println("ID: " + getId() +
                " Nome: " + getNome() +
                " Descrição: " + getDescricao() +
                " Preço da Venda: " + getPrecoVenda() +
                " classes.Estoque: " + getEstoque() +
                " Caminho da imagem: " + getCaminhoImagem() +
                " Estado: " + isUsado());
    }
}
