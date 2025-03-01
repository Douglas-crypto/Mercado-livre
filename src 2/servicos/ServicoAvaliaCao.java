package servicos;

import database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicoAvaliaCao {

    public void cadastraAvaliaCao(int id_produto, int id_usuario, int nota_produto, String texto){

        String sql = "INSERT INTO avaliacao (fk_produto, fk_usuario, nota_produto, texto)  VALUES (?, ?, ?, ?)";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm =  connection.prepareStatement(sql)) {

            pstm.setInt(1, id_produto);
            pstm.setInt(2,id_usuario);
            pstm.setInt(3, nota_produto);
            pstm.setString(4, texto);

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
}

