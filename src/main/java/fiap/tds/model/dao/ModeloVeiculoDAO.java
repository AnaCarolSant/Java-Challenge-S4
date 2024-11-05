package fiap.tds.model.dao;


import fiap.tds.model.beans.ModeloVeiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloVeiculoDAO {
    private Connection connection;

    public ModeloVeiculoDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(ModeloVeiculo modeloVeiculo) throws SQLException {
        String sql = "INSERT INTO tb_modelo_veiculo (id_modelo_veiculo, nm_modelo_veiculo, marca_veiculo, ano_fabricacao, combustivel, tipo_carroceria, tipo_direcao, tipo_cambio, tipo_freios, tipo_suspensao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, modeloVeiculo.getIdModeloVeiculo());
            stmt.setString(2, modeloVeiculo.getNomeModeloVeiculo());
            stmt.setString(3, modeloVeiculo.getMarcaVeiculo());
            stmt.setDate(4, new Date(modeloVeiculo.getAnoFabricacao().getTime())); // Convert java.util.Date to java.sql.Date
            stmt.setString(5, modeloVeiculo.getCombustivel());
            stmt.setString(6, modeloVeiculo.getTipoCarroceria());
            stmt.setString(7, modeloVeiculo.getTipoDirecao());
            stmt.setString(8, modeloVeiculo.getTipoCambio());
            stmt.setString(9, modeloVeiculo.getTipoFreios());
            stmt.setString(10, modeloVeiculo.getTipoSuspensao());
            stmt.executeUpdate();
        }
    }

    public ModeloVeiculo findById(int idModeloVeiculo) throws SQLException {
        String sql = "SELECT * FROM tb_modelo_veiculo WHERE id_modelo_veiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idModeloVeiculo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ModeloVeiculo(
                        rs.getInt("id_modelo_veiculo"),
                        rs.getString("nm_modelo_veiculo"),
                        rs.getString("marca_veiculo"),
                        rs.getDate("ano_fabricacao"),
                        rs.getString("combustivel"),
                        rs.getString("tipo_carroceria"),
                        rs.getString("tipo_direcao"),
                        rs.getString("tipo_cambio"),
                        rs.getString("tipo_freios"),
                        rs.getString("tipo_suspensao")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    public List<ModeloVeiculo> findAll() throws SQLException {
        List<ModeloVeiculo> modelos = new ArrayList<>();
        String sql = "SELECT * FROM tb_modelo_veiculo";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                modelos.add(new ModeloVeiculo(
                    rs.getInt("id_modelo_veiculo"),
                    rs.getString("nm_modelo_veiculo"),
                    rs.getString("marca_veiculo"),
                    rs.getDate("ano_fabricacao"),
                    rs.getString("combustivel"),
                    rs.getString("tipo_carroceria"),
                    rs.getString("tipo_direcao"),
                    rs.getString("tipo_cambio"),
                    rs.getString("tipo_freios"),
                    rs.getString("tipo_suspensao")
                ));
            }
        }
        return modelos;
    }

    public void update(ModeloVeiculo modeloVeiculo) throws SQLException {
        String sql = "UPDATE tb_modelo_veiculo SET nm_modelo_veiculo = ?, marca_veiculo = ?, ano_fabricacao = ?, combustivel = ?, tipo_carroceria = ?, tipo_direcao = ?, tipo_cambio = ?, tipo_freios = ?, tipo_suspensao = ? WHERE id_modelo_veiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, modeloVeiculo.getNomeModeloVeiculo());
            stmt.setString(2, modeloVeiculo.getMarcaVeiculo());
            stmt.setDate(3, new Date(modeloVeiculo.getAnoFabricacao().getTime())); // Convert java.util.Date to java.sql.Date
            stmt.setString(4, modeloVeiculo.getCombustivel());
            stmt.setString(5, modeloVeiculo.getTipoCarroceria());
            stmt.setString(6, modeloVeiculo.getTipoDirecao());
            stmt.setString(7, modeloVeiculo.getTipoCambio());
            stmt.setString(8, modeloVeiculo.getTipoFreios());
            stmt.setString(9, modeloVeiculo.getTipoSuspensao());
            stmt.setInt(10, modeloVeiculo.getIdModeloVeiculo());
            stmt.executeUpdate();
        }
    }

    public void delete(int idModeloVeiculo) throws SQLException {
        String sql = "DELETE FROM tb_modelo_veiculo WHERE id_modelo_veiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idModeloVeiculo);
            stmt.executeUpdate();
        }
    }
}
