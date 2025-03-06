
package org.douglascosta.servicos;

import org.douglascosta.database.ConnectionDB;
import org.douglascosta.classes.GerenciaSenha;

import java.sql.*;


public class ServicoUsuario {
    private GerenciaSenha gerenciaSenha;

    public ServicoUsuario() {
        this.gerenciaSenha = new GerenciaSenha();
    }

    public void cadastrarUsuario(String nome_completo, String cpf_cnpj, String endereco, String email, String senha) {
        String sql = "INSERT INTO usuario (nome_completo, cpf_cnpj, endereco, email, senha) VALUES (?, ?, ?, ?, ?)";

        String senhaCriptografada = gerenciaSenha.criptografarSenha(senha);

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, nome_completo.toUpperCase());
            pstm.setString(2, cpf_cnpj);
            pstm.setString(3, endereco.toUpperCase());
            pstm.setString(4, email);
            pstm.setString(5, senhaCriptografada);

            int linhaAfet = pstm.executeUpdate();

            if (linhaAfet > 0) {
                System.out.println("classes.Usuario cadastrado com exito");
            } else {
                System.out.println("classes.Usuario não cadastrado");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarUsuario(int idUsuario, String novoNomeCompleto) {

        if (novoNomeCompleto == null || novoNomeCompleto.trim().isEmpty()) {
            System.out.println("Nome completo não pode ser nulo ou vazio.");
            return;
        }

        String sql = "UPDATE usuario SET nome_completo = ? WHERE id = ?";

        // Criptografa a nova senha
        // Caso seja a senha a se editar: String senhaCriptografada = gerenciaSenha.criptografarSenha(senha);

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, novoNomeCompleto.toUpperCase());
            pstm.setInt(2, idUsuario);

            int linhaAfet = pstm.executeUpdate();

            if (linhaAfet > 0) {
                System.out.println("classes.Usuario atualizado");
            } else {
                System.out.println("classes.Usuario não foi atualizado, verifique as informações");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public boolean autenticarUsuario(String email, String senha) {
        String sql = "SELECT senha FROM usuario WHERE email = ?";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, email);
            java.sql.ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                String senhaCriptografada = rs.getString("senha");
                return gerenciaSenha.verificarSenha(senha, senhaCriptografada);
            }
            return false;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
