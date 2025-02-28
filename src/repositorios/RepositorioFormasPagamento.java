package repositorios;

import classes.FormasPagamento;
import classes.TipoFormaPagamento;
import database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioFormasPagamento {
    public FormasPagamento getById(long id) {
        String sql = "SELECT * FROM cad_formas_pgto WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String formapagamento = rs.getString("frm_pgto");
                    int quantidade_parcelas = rs.getInt("quant_parcelas");
                    float percentual_juros = rs.getFloat("perc_juros");

                    TipoFormaPagamento formaPagamento = TipoFormaPagamento.valueOf(
                            formapagamento.toUpperCase().replace(" ","_"));

                    return new FormasPagamento((int) id, formaPagamento, quantidade_parcelas, percentual_juros);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}

