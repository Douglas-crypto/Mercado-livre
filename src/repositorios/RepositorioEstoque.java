package repositorios;

import classes.Estoque;
import database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioEstoque {

    public Estoque getById(int id) {
        String sql = "SELECT * FROM estoque WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int fkProduto = rs.getInt("fk_produto");
                    int quantidade = rs.getInt("quantidade");
                    String modelo = rs.getString("modelo");
                    String caminhoImagem = rs.getString("caminho_imagem");


                    return new Estoque(id, fkProduto, quantidade, modelo, caminhoImagem);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar estoque com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}