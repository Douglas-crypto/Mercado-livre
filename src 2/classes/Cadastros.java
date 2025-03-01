package classes;

import database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Cadastros {

    public void adicionaUsuario(String username, String cpf_cnpj, String endereco, String email, String senha) {
        String sql = "INSERT INTO cad_usuarios (username, cpf_cnpj, endereco, email, senha) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, username);
            pstm.setString(2, cpf_cnpj);
            pstm.setString(3, endereco);
            pstm.setString(4, email);
            pstm.setString(5, senha);

            int linhaAfet = pstm.executeUpdate();

            if (linhaAfet > 1) {
                System.out.println("classes.Usuario cadastrado com exito");
            } else {
                System.out.println("classes.Usuario não cadastrado");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}