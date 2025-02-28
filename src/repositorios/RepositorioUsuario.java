package repositorios;

import classes.Usuario;
import database.ConnectionDB;

import java.sql.*;

public class RepositorioUsuario {

    public Usuario getById(long id) {
        String sql = "SELECT * FROM cad_usuarios WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String username = rs.getString("username");
                    String cpfCnpj = rs.getString("cpf_cnpj");
                    String endereco = rs.getString("endereco");
                    String email = rs.getString("email");
                    String senha = rs.getString("senha");

                    return new Usuario((int) id, username, cpfCnpj, endereco, email, senha);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
