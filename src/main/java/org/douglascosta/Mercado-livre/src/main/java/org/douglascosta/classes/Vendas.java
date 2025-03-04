package org.douglascosta.classes;

import java.util.Date;

public class Vendas {
    private final int id;
    private final int fk_usuario;
    private final int fk_frm_pgto;
    private Date dt_venda;
    private double valor_total;

    public Vendas(int id, int fk_usuario, int fk_frm_pgto, Date dt_venda, double valor_total) {
        this.id = id;
        this.fk_usuario = fk_usuario;
        this.fk_frm_pgto = fk_frm_pgto;
        this.dt_venda = dt_venda;
        this.valor_total = valor_total;
    }

    public int getId() {
        return id;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public Date getDt_venda() {
        return dt_venda;
    }

    public double getValor_total() {
        return valor_total;
    }

    public int getFkFormaPagamento() {
        return fk_frm_pgto;
    }

    public void exibirInformacao() {
        System.out.println("ID: " + getId() +
                " Chave estrangeira do usuario : " +  getFk_usuario() +
                " Chave estrangeira da forma de pagamento: " +  getFkFormaPagamento() +
                " Data da venda: " + getDt_venda() +
                " Valor total da venda: " + getValor_total());


    }
}