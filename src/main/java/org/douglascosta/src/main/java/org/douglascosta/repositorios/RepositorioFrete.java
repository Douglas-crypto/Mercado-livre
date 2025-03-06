package org.douglascosta.repositorios;

import org.douglascosta.classes.Frete;
import org.douglascosta.database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioFrete {
        public Frete getById(long id) {
            String sql = "SELECT * FROM frete WHERE id = ?";

            try (Connection conn = new ConnectionDB().getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setLong(1, id);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int fk_venda = rs.getInt("fk_venda");
                        int valor = rs.getInt("valor");
                        int rating = rs.getInt("prazo_entrega");
                        String transportadora = rs.getString("transportadora");
                        String status = rs.getString("status");

                        return new Frete((int) id, fk_venda, valor, rating, transportadora, status);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Erro ao buscar usuário com ID: " + id);
                e.printStackTrace();
            }
            return null;
        }
    }
