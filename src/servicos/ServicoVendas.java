package servicos;

import database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicoVendas {
    public void listarVendas() {
        String sql = "SELECT id, fk_venda, fk_produto, fk_estoque, preco_unit, quantidade, subtotal FROM item_venda";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet resultSet = pstm.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("ID da Venda: " + resultSet.getInt("fk_venda"));
                System.out.println("ID do classes.Produto: " + resultSet.getInt("fk_produto"));
                System.out.println("ID do classes.Estoque: " + resultSet.getInt("fk_estoque"));
                System.out.println("Preço Unitário: " + resultSet.getBigDecimal("preco_unit"));
                System.out.println("Quantidade: " + resultSet.getInt("quantidade"));
                System.out.println("Subtotal: " + resultSet.getBigDecimal("subtotal"));

            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar vendas: " + e.getMessage());
        }
    }
}
