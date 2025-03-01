import classes.*;
import repositorios.*;


public class Main {
    public static void main(String[] args) {

        RepositorioProduto repoProduto = new RepositorioProduto();
        Produto produto = repoProduto.getById(1);
        System.out.println("Produto encontrado: " + (produto != null ? produto.getNome() : "Nenhum produto encontrado"));

        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        Usuario usuario = repositorioUsuario.getById(1);
        System.out.println("Usuario encontrado: " + (usuario != null ? usuario.getNome_completo() : "Nenhum usuario encontrado"));

        RepositorioVendas repositorioVendas =new RepositorioVendas();
        Vendas vendas = repositorioVendas.getById(4);
        System.out.println("Chave estrangeira usuario : " + (vendas != null ? vendas.getFk_usuario() : "Nenhuma chave estrangeira encontrada"));

        RepositorioItensVenda repositorioItensVenda = new RepositorioItensVenda();
        ItensVenda itensVenda = repositorioItensVenda.getById(3);
        System.out.println("Repositorio itens venda: " + (itensVenda != null ? itensVenda.getFk_venda() : "Nenhum chave estrangeira de venda encontrada"));

        RepositorioFormasPagamento repositorioFormasPagamento = new RepositorioFormasPagamento();
        FormasPagamento formasPagamento = repositorioFormasPagamento.getById(5);
        System.out.println("Forma de pagamento encontrada: " +
                (formasPagamento != null ? formasPagamento.getQuantParcelas() : "Nenhuma forma de pagamento encontrada"));

        RepositorioEstoque repositorioEstoque = new RepositorioEstoque();
        Estoque estoque = repositorioEstoque.getById(1);
        System.out.println("Quantidade no estoque: " +
                (estoque != null ? estoque.getQuantidade() : "Nenhuma quantidade de produto no estoque"));

        RepositorioAvalicao repositorioAvalicao = new RepositorioAvalicao();
        AvaliaCao avaliaCao = repositorioAvalicao.getById(1);
        System.out.println("Nota do produto ID 1: " +
                (avaliaCao != null ? avaliaCao.getRating() : "Nenhuma nota encontrada"));
    }
}
