package org.douglascosta.servicos;

import org.douglascosta.database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicoEstoque {

    public void adicionarEstoque(int fk_produto, int quantidade, String modelo, String caminho_imagem) {
        String sql = "INSERT INTO estoque (fk_produto, quantidade, modelo, caminho_imagem) VALUES (?, ?, ?, ?)";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, fk_produto);
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
}
