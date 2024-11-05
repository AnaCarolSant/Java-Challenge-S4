package fiap.tds.model.dao;

import fiap.tds.model.beans.VeiculoCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoClienteDAO {
    private Connection connection;

    public VeiculoClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(VeiculoCliente veiculoCliente) throws SQLException {
        String sql = "INSERT INTO tb_veiculo_cliente (id_veiculo_cliente, id_cliente, placa_veiculo, id_modelo_veiculo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, veiculoCliente.getIdVeiculoCliente());
            stmt.setInt(2, veiculoCliente.getIdCliente());
            stmt.setString(3, veiculoCliente.getPlacaVeiculo());
            stmt.setInt(4, veiculoCliente.getIdModeloVeiculo()); // Aqui você usa o ID diretamente
            stmt.executeUpdate();
        }
    }

    public VeiculoCliente findById(int idVeiculoCliente) throws SQLException {
        String sql = "SELECT * FROM tb_veiculo_cliente WHERE id_veiculo_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idVeiculoCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new VeiculoCliente(
                        rs.getInt("id_veiculo_cliente"),
                        rs.getInt("id_cliente"),
                        rs.getString("placa_veiculo"),
                        rs.getInt("id_modelo_veiculo")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    public List<VeiculoCliente> findAll() throws SQLException {
        List<VeiculoCliente> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM tb_veiculo_cliente";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                veiculos.add(new VeiculoCliente(
                    rs.getInt("id_veiculo_cliente"),
                    rs.getInt("id_cliente"),
                    rs.getString("placa_veiculo"),
                    rs.getInt("id_modelo_veiculo")
                ));
            }
        }
        return veiculos;
    }

    public void update(VeiculoCliente veiculoCliente) throws SQLException {
        String sql = "UPDATE tb_veiculo_cliente SET id_cliente = ?, placa_veiculo = ?, id_modelo_veiculo = ? WHERE id_veiculo_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, veiculoCliente.getIdCliente());
            stmt.setString(2, veiculoCliente.getPlacaVeiculo());
            stmt.setInt(3, veiculoCliente.getIdModeloVeiculo());
            stmt.setInt(4, veiculoCliente.getIdVeiculoCliente());
            stmt.executeUpdate();
        }
    }

    public void delete(int idVeiculoCliente) throws SQLException {
        String sql = "DELETE FROM tb_veiculo_cliente WHERE id_veiculo_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idVeiculoCliente);
            stmt.executeUpdate();
        }
    }
}
