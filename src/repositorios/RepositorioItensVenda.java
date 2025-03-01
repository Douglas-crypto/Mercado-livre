package repositorios;

import classes.Frete;
import classes.ItensVenda;
import database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioItensVenda {
    public ItensVenda getById(long id) {
        String sql = "SELECT * FROM itens_venda WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int fk_venda = rs.getInt("fk_venda");
                    int fk_produto = rs.getInt("fk_produto");
                    int fk_estoque = rs.getInt("fk_estoque");
                    Double preco_unit = rs.getDouble("preco_unit");
                    int quantidade = rs.getInt("quantidade");
                    Double subtotal = rs.getDouble("subtotal");

                    return new ItensVenda((int) id, fk_venda, fk_produto, fk_estoque, preco_unit, quantidade, subtotal);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}



