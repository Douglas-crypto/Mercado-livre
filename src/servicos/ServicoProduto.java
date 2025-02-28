package servicos;

import database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ServicoProduto {
    public void cadastrarProduto(String nome, String descricao, float preco_venda, int estoque, String caminho_imagem, boolean usado) {
        String sql = "INSERT INTO produtos (nome, descricao, preco_venda, estoque, caminho_imagem, usado) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, nome);
            pstm.setString(2, descricao);
            pstm.setFloat(3, preco_venda);
            pstm.setInt(4, estoque);
            pstm.setString(5, caminho_imagem);
            pstm.setBoolean(6, usado);

            int linhaAfet = pstm.executeUpdate();

            if (linhaAfet > 0) {
                System.out.println("Cadastrado com êxito");
            } else {
                System.out.println("Não cadastrado");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void adicionarEstoque(int fk_produto, int quantidade, String modelo, String caminho_imagem) {
        String sql = "INSERT INTO estoque (fk_produto, quantidade, modelo, caminho_imagem) VALUES (?, ?, ?, ?)";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(11, fk_produto);
            pstm.setInt(2, quantidade);
            pstm.setString(3, modelo);
            pstm.setString(4, caminho_imagem);

            int linhaAfet = pstm.executeUpdate();

            if (linhaAfet > 0) {
                System.out.println("Cadastrado com êxito");
            } else {
                System.out.println("Não cadastrado");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarEstoque(int idEstoque, int novaQuantidade) {
        String sql = "UPDATE estoque SET quantidade = ? WHERE id = ?";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, novaQuantidade);
            pstm.setInt(2, idEstoque);

            int linhaAfet = pstm.executeUpdate();

            if (linhaAfet > 0) {
                System.out.println("classes.Estoque atualizado");
            } else {
                System.out.println("classes.Estoque não foi atualizado, verifique as informações");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarProduto(int id, String nome_produto, String descricao, float preco, boolean usado) {
        String sql = "UPDATE produto SET nome_produto = ?, descricao = ?, preco = ?, usado = ? WHERE id = ?";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, nome_produto);
            pstm.setString(2, descricao);
            pstm.setFloat(3, preco);
            pstm.setBoolean(4, usado);
            pstm.setInt(5, id);

            int linhaAfet = pstm.executeUpdate();

            if (linhaAfet > 0) {
                System.out.println("classes.Produto atualizado");
            } else {
                System.out.println("classes.Produto não foi atualizado, verifique as informações");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void visualizaProduto(int idProduto) {
        String sql = "SELECT id, nome_produto, descricao, preco, usado FROM produto WHERE id = ?";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, idProduto);

            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nome: " + resultSet.getString("nome_produto"));
                System.out.println("Descrição: " + resultSet.getString("descricao"));
                System.out.println("Preço: " + resultSet.getFloat("preco"));
                System.out.println("Usado: " + resultSet.getBoolean("usado"));
            } else {
                System.out.println("classes.Produto não foi encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao tentar visualizar o produto: " + e.getMessage());
        }
    }

    public void listaAvaliacao(int idProduto) {
        String sql = "SELECT id, fk_produto, fk_usuario, nota_produto, texto FROM avaliacao WHERE fk_produto = ?";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, idProduto);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID da Avaliação: " + resultSet.getInt("id"));
                System.out.println("ID do classes.Produto: " + resultSet.getInt("fk_produto"));
                System.out.println("ID do Usuário: " + resultSet.getInt("fk_usuario"));
                System.out.println("Nota: " + resultSet.getInt("nota_produto"));
                System.out.println("Comentário: " + resultSet.getString("texto"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar avaliações: " + e.getMessage());
        }
    }
}