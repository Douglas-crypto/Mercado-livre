package classes;

public class Frete {
    private int id;
    private int fkVenda;
    private double valor;
    private int prazoEntrega;
    private String transportadora;
    private String status;


    public Frete(int id, int fkVenda, double valor, int prazoEntrega, String transportadora, String status) {
        this.id = id;
        this.fkVenda = fkVenda;
        this.valor = valor;
        this.prazoEntrega = prazoEntrega;
        this.transportadora = transportadora;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkVenda() {
        return fkVenda;
    }

    public void setFkVenda(int fkVenda) {
        this.fkVenda = fkVenda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPrazoEntrega() {
        return prazoEntrega;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}