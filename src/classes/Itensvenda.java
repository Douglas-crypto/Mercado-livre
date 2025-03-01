package classes;

public class Itensvenda {

   private int id;
   private int fk_venda;
   private int fk_produto;
   private int fk_estoque;
   private double preco_unit;
   private int quantidade;
   private double subtotal;

    public ItensVenda(int id, int fk_venda, int fk_produto, int fk_estoque, double preco_unit, int quantidade, double subtotal) {
        this.id = id;
        this.fk_venda = fk_venda;
        this.fk_produto = fk_produto;
        this.fk_estoque = fk_estoque;
        this.preco_unit = preco_unit;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public int getFk_venda() {
        return fk_venda;
    }

    public int getFk_produto() {
        return fk_produto;
    }

    public int getFk_estoque() {
        return fk_estoque;
    }

    public double getPreco_unit() {
        return preco_unit;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
