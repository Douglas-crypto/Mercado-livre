package repositorios;

import classes.Usuario;
import database.ConnectionDB;

import java.sql.*;

public class RepositorioUsuario {

    public Usuario getById(long id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome_completo = rs.getString("nome_completo");
                    String cpf_cnpj = rs.getString("cpf_cnpj");
                    String email = rs.getString("email");
                    String senha = rs.getString("senha");
                    String endereco = rs.getString("endereco");

                    return new Usuario((int) id, nome_completo, cpf_cnpj, email, senha, endereco);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
