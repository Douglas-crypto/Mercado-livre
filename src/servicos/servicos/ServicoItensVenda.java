package servicos;

import database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicoItensVenda {
    public void cadastrarItemVenda(int fk_venda, int fk_produto, int fk_estoque, double preco_unit, int quantidade, double subtotal) {
        String sql = "INSERT INTO itens_venda (fk_venda, fk_produto, fk_estoque, preco_unit, quantidade, subtotal) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, fk_venda);
            pstm.setInt(2, fk_produto);
            pstm.setInt(3, fk_estoque);
            pstm.setDouble(4, preco_unit);
            pstm.setInt(5, quantidade);
            pstm.setDouble(6, subtotal);

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
