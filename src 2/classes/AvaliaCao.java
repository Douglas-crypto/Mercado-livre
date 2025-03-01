package classes;

public class AvaliaCao {
    private final int id;
    private final int fkProduto;
    private final int fkUsuario;
    private int rating;
    private final String texto;

    public AvaliaCao(int id, int fkProduto, int fkUsuario,int rating, String texto) {
        this.id = id;
        this.fkProduto = fkProduto;
        this.fkUsuario = fkUsuario;
        this.rating = rating;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public int getFkProduto() {
        return fkProduto;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public int getRating() {
        return rating;
    }

    public String getTexto() {
        return texto;
    }

    public void exibirInformacao() {
        System.out.println("ID: " + getId() +
                " classes.Produto ID: " + getFkProduto() +
                " Usuário ID: " + getFkUsuario() +
                " Nota: " + getRating() +
                " Comentário: " + getTexto());
    }
}