package org.douglascosta.classes;

public class Vendas {
    private final int id;
    private final int fkUsuario;
    private final int fkProduto;
    private int quantidade;
    private final int fk_frm_pgto;
    private boolean cancelado;
    private String motivoCancelamento;

    public Vendas(int id, int fkUsuario, int fkProduto, int quantidade, int fk_frm_pgto, boolean cancelado, String motivoCancelamento) {
        this.id = id;
        this.fkUsuario = fkUsuario;
        this.fkProduto = fkProduto;
        this.quantidade = quantidade;
        this.fk_frm_pgto = fk_frm_pgto;
        this.cancelado = cancelado;
        this.motivoCancelamento = motivoCancelamento;
    }

    public boolean isCancelado() {
        if (cancelado) {
            System.out.println("Venda cancelada");
            return true;
        } else {
            System.out.println("Venda não cancelada");
            return false;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getId() {
        return id;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public int getFkProduto() {
        return fkProduto;
    }

    public int getFkFormaPagamento() {
        return fk_frm_pgto;
    }

    public void exibirInformacao() {
        System.out.println("ID: " + getId() +
                " Chave estrangeira do usuario : " +  getFkUsuario() +
                " Chave estrangeira do produto: " +  getFkProduto() +
                " Quantidade: " +  getQuantidade() +
                " Chave estrangeira da forma de pagamento: " +  getFkFormaPagamento() +
                " cancelado: " +  isCancelado() +
                " Motivo do cancelamento: " + getMotivoCancelamento());
    }
}