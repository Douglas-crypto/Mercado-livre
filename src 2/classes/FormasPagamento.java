package classes;

public class
FormasPagamento {
    private final int id;
    private TipoFormaPagamento forma;
    private final int quantParcelas;
    private final float percJuros;
    private final boolean inativo;

    public FormasPagamento(int id, TipoFormaPagamento forma, int quantParcelas, float percJuros, boolean inativo) {
        this.id = id;
        this.forma = forma;
        this.quantParcelas = quantParcelas;
        this.percJuros = percJuros;
        this.inativo = inativo;
    }

    public TipoFormaPagamento getForma() {
        return forma;
    }

    public int getQuantParcelas() {
        return quantParcelas;
    }

    public double getPercJuros() {
        return percJuros;
    }

    public int getId() {
        return id;
    }

    public void  ExibirInformacao(){
        System.out.println("ID: " + getId() +
                " Forma : " + getForma() +
                " Qunatidade de parcelas: " + getQuantParcelas() +
                " Percentual Juros: " + getPercJuros());
    }
}
