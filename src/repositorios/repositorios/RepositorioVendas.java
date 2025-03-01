package repositorios;

import classes.Vendas;
import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class RepositorioVendas {
    public Vendas getById(long id) {
        String sql = "SELECT * FROM venda WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int fk_usuario = rs.getInt("fk_usuario");
                    int fk_forma_ppgto= rs.getInt("fk_forma_pgto");
                    Date dt_venda= rs.getDate("dt_venda");
                    Double valor_total= rs.getDouble("valor_total");

                    return new Vendas((int) id, fk_usuario, fk_forma_ppgto, dt_venda, valor_total);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar venda com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
