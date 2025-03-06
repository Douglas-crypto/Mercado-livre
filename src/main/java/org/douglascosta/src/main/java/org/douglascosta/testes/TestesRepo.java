package org.douglascosta.testes;

import org.douglascosta.classes.*;
import org.douglascosta.repositorios.*;

public class TestesRepo {
    public static void main(String[] args) {
        RepositorioProduto repositorioProduto = new RepositorioProduto();
        Produto produto = repositorioProduto.getById(4);
        System.out.println("Produto encontrado: " + (produto != null ? produto.getNome() : "Nenhum produto encontrado"));

        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        Usuario usuario = repositorioUsuario.getById(4);
        System.out.println("Usuario encontrado: " + (usuario != null ? usuario.getNome_completo() : "Nenhum usuario encontrado"));

        RepositorioVendas repositorioVendas =new RepositorioVendas();
        Vendas vendas = repositorioVendas.getById(4);
        System.out.println("Chave estrangeira usuario : " + (vendas != null ? vendas.getFk_usuario() : "Nenhuma chave estrangeira encontrada"));

        RepositorioItensVenda repositorioItensVenda = new RepositorioItensVenda();
        ItensVenda itensvenda = repositorioItensVenda.getById(4);
        System.out.println("Repositorio itens venda: " + (itensvenda != null ? itensvenda.getFk_venda() : "Nenhum chave estrangeira de venda encontrada"));

        RepositorioEstoque repositorioEstoque = new RepositorioEstoque();
        Estoque estoque = repositorioEstoque.getById(4);
        System.out.println("Quantidade no estoque: " +
                (estoque != null ? estoque.getQuantidade() : "Nenhuma quantidade de produto no estoque"));

        RepositorioAvaliacao repositorioAvalicao = new RepositorioAvaliacao();
        Avaliacao avaliaCao = repositorioAvalicao.getById(4);
        System.out.println("Nota do produto ID 1: " +
                (avaliaCao != null ? avaliaCao.getRating() : "Nenhuma nota encontrada"));

        RepositorioFormasPagamento repositorioFormasPagamento = new RepositorioFormasPagamento();
        FormasPagamento formasPagamento =  repositorioFormasPagamento.getById(4);
        System.out.println("Forma de pagamento encontrada: " +
                (formasPagamento != null ? formasPagamento.getQuantParcelas() : "Nenhuma forma de pagamento encontrada"));

        RepositorioFrete repositorioFrete = new RepositorioFrete();
        Frete frete =  repositorioFrete.getById(4);
        System.out.println("Transportadora encontrda: " +
                (frete != null ? frete.getTransportadora() : "Nenhuma transportadora encontrada"));









    }
}