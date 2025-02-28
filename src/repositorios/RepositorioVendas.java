package repositorios;

import classes.Vendas;
import database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioVendas {
    public Vendas getById(long id) {
        String sql = "SELECT * FROM vendas WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                   int fk_user = rs.getInt("fk_user");
                   int fkProduto= rs.getInt("fk_produto");
                   int quantidade= rs.getInt("quantidade");
                   int fk_frm_pgto= rs.getInt("fk_frm_pgto");
                   boolean cancelado = rs.getBoolean("cancelado");
                   String  motivo_cancel= rs.getString("motivo_cancel");

                    return new Vendas((int) id, fk_user, fkProduto, quantidade, fk_frm_pgto, cancelado, motivo_cancel );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar venda com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}

