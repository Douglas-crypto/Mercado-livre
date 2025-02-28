package repositorios;

import classes.Produto;
import database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioProduto {
    public Produto getById(long id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    String descricao = rs.getString("descricao");
                    float preco_venda = rs.getFloat("preco_venda");
                    int estoque = rs.getInt("estoque");
                    String caminho_imagem = rs.getString("caminho_imagem");
                    boolean usado = rs.getBoolean("usado");

                    return new Produto((int) id, nome, descricao,  preco_venda, estoque, caminho_imagem, usado);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
