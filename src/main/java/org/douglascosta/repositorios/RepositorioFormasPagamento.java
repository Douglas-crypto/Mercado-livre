package org.douglascosta.repositorios;

import org.douglascosta.classes.FormasPagamento;
import org.douglascosta.classes.TipoFormaPagamento;
import org.douglascosta.database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioFormasPagamento {
    public FormasPagamento getById(long id) {
        String sql = "SELECT * FROM forma_pgto WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String formapagamento = rs.getString("nome_forma");
                    int quantidade_parcelas = rs.getInt("quant_parcelas");
                    int percentual_juros = rs.getInt("perc_juros");
                    boolean inativo = rs.getBoolean("inativo");

                    TipoFormaPagamento formaPagamento = null;
                    try {
                        formaPagamento = TipoFormaPagamento.valueOf(
                                formapagamento.toUpperCase().replace(" ", "_"));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Erro: Valor inválido para TipoFormaPagamento no ID " + id + ": " + formapagamento);
                        // Tratar o erro (por exemplo, definir um valor padrão, registrar o erro, etc.)
                        return null; // Ou lançar uma exceção customizada, dependendo da sua lógica
                    }


                    return new FormasPagamento((int) id, formaPagamento, quantidade_parcelas, percentual_juros, inativo);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}