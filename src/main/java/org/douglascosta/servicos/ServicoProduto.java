package org.douglascosta.servicos;

import org.douglascosta.database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicoProduto {
    public void cadastrarProduto(String nome, String descricao, float preco, boolean usado) {
        String sql = "INSERT INTO produto (nome_produto, descricao, preco, usado) VALUES (?, ?, ?, ?)";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, nome);
            pstm.setString(2, descricao);
            pstm.setFloat(3, preco);
            pstm.setBoolean(4, usado);

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

    public void cadastrarFormaPagamento(String nome_forma, int quant_parcelas , float perc_juros, boolean inativo) {
        String sql = "INSERT INTO forma_pgto (nome_forma, quant_parcelas, perc_juros, inativo) VALUES (?, ?, ?, ?)";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, nome_forma);
            pstm.setInt(2, quant_parcelas);
            pstm.setFloat(3, perc_juros);
            pstm.setBoolean(4, inativo);

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

    public void editarProduto(int idProduto, String nome_produto) {
        String sql = "UPDATE produto SET nome_produto = ?, WHERE id = ?";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, nome_produto);
            pstm.setInt(2, idProduto);

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

    public void cadastrarFrete(int fk_venda, int valor , int prazo_entrega,
                               String transportadora, String status) {
        String sql = "INSERT INTO frete (fk_venda, valor, prazo_entrega, transportadora, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, fk_venda);
            pstm.setInt(2, valor);
            pstm.setInt(3, prazo_entrega);
            pstm.setString(4, transportadora);
            pstm.setString(5, status);

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

    public void visualizarProduto(int idProduto) {
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

    public void listarAvaliacao(int idProduto) {
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
