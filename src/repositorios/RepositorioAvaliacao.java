package repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import classes.Avaliacao;
import database.ConnectionDB;

public class RepositorioAvaliacao {

    public Avaliacao getById(long id) {
        String sql = "SELECT * FROM avaliacao WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int fk_produto = rs.getInt("fk_produto");
                    int fk_usuario = rs.getInt("fk_usuario");
                    int rating = rs.getInt("nota_produto");
                    String texto = rs.getString("texto");



                    return new Avaliacao((int) id, fk_produto, fk_usuario, rating, texto);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
