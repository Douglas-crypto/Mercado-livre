package repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import classes.AvaliaCao;
import database.ConnectionDB;

public class RepositorioAvalicao {
    public AvaliaCao getById(long id) {
        String sql = "SELECT * FROM avaliacoes WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int fk_produto = rs.getInt("fk_produto");
                    int fk_usuario = rs.getInt("fk_usuario");
                    int rating = rs.getInt("rating");
                    String texto = rs.getString("texto");



                    return new AvaliaCao((int) id, fk_produto, fk_usuario, rating, texto);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}

