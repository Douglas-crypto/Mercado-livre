package org.douglascosta.repositorios;

import org.douglascosta.classes.Produto;
import org.douglascosta.database.ConnectionDB;

import java.sql.*;

public class RepositorioProduto {
    public Produto getById(long id) {
        String sql = "SELECT * FROM produto WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome_produto = rs.getString("nome_produto");
                    String descricao = rs.getString("descricao");
                    int preco = rs.getInt("preco");
                    boolean usado = rs.getBoolean("usado");

                    return new Produto((int) id,nome_produto, descricao, preco, usado);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
