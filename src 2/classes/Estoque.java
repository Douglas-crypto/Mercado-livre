package classes;

public class Estoque {
    private int id;
    private int fkProduto;
    private int quantidade;
    private String modelo;
    private String caminhoImagem;


    public Estoque(int id, int fkProduto, int quantidade, String modelo, String caminhoImagem) {
        this.id = id;
        this.fkProduto = fkProduto;
        setQuantidade(quantidade);
        this.modelo = modelo;
        this.caminhoImagem = caminhoImagem;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(int fkProduto) {
        this.fkProduto = fkProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}