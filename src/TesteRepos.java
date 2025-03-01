public class TesteRepos {

import classes.AvaliaCao;
import classes.Produto;
import classes.Usuario;
import classes.Vendas;
import repositorios.RepositorioAvalicao;
import repositorios.RepositorioProduto;
import repositorios.RepositorioUsuario;
import repositorios.RepositorioVendas;


    public static void main(String[] args) {

        RepositorioProduto repoProduto = new RepositorioProduto();
        Produto produto = repoProduto.getById(1);
        System.out.println("classes.Produto encontrado: " + (produto != null ? produto.getNome() : "Nenhum produto encontrado"));


        RepositorioUsuario repoUsuario = new RepositorioUsuario();
        Usuario usuario = repoUsuario.getById(1);
        System.out.println("Usuário encontrado: " + (usuario != null ? usuario.getNome_completo() : "Nenhum usuário encontrado"));


        RepositorioVendas repoVendas = new RepositorioVendas();
        Vendas venda = repoVendas.getById(1);
        System.out.println("Venda encontrada: " + (venda != null ? "Venda ID " + venda.getId() : "Nenhuma venda encontrada"));


        RepositorioAvalicao repoAvaliacao = new RepositorioAvalicao();
        AvaliaCao avaliacao = repoAvaliacao.getById(1);
        System.out.println("Avaliação encontrada: " + (avaliacao != null ? "Rating " + avaliacao.getRating() : "Nenhuma avaliação encontrada"));
    }
}
