package fiap.tds.model.dao;


import fiap.tds.model.beans.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO tb_cliente (id_cliente, nome_cliente, cpf_cliente, data_nascimento, data_cadastro, email_cliente, telefone_cliente, genero, cep_cliente, numero_cliente, complemento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getIdCliente());
            stmt.setString(2, cliente.getNomeCliente());
            stmt.setString(3, cliente.getCpfCliente());
            stmt.setDate(4, (Date) cliente.getDataNascimento());
            stmt.setDate(5, (Date) cliente.getDataCadastro());
            stmt.setString(6, cliente.getEmailCliente());
            stmt.setInt(7, cliente.getTelefoneCliente());
            stmt.setString(8, cliente.getGenero());
            stmt.setString(9, cliente.getCepCliente());
            stmt.setInt(10, cliente.getNumeroCliente());
            stmt.setString(11, cliente.getComplemento());
            stmt.executeUpdate();
        }
    }

    public Cliente findById(int idCliente) throws SQLException {
        String sql = "SELECT * FROM tb_cliente WHERE id_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome_cliente"),
                        rs.getString("cpf_cliente"),
                        rs.getDate("data_nascimento"),
                        rs.getDate("data_cadastro"),
                        rs.getString("email_cliente"),
                        rs.getInt("telefone_cliente"),
                        rs.getString("genero"),
                        rs.getString("cep_cliente"),
                        rs.getInt("numero_cliente"),
                        rs.getString("complemento")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    public List<Cliente> findAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM tb_cliente";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clientes.add(new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nome_cliente"),
                    rs.getString("cpf_cliente"),
                    rs.getDate("data_nascimento"),
                    rs.getDate("data_cadastro"),
                    rs.getString("email_cliente"),
                    rs.getInt("telefone_cliente"),
                    rs.getString("genero"),
                    rs.getString("cep_cliente"),
                    rs.getInt("numero_cliente"),
                    rs.getString("complemento")
                ));
            }
        }
        return clientes;
    }

    public void update(Cliente cliente) throws SQLException {
        String sql = "UPDATE tb_cliente SET nome_cliente = ?, cpf_cliente = ?, data_nascimento = ?, data_cadastro = ?, email_cliente = ?, telefone_cliente = ?, genero = ?, cep_cliente = ?, numero_cliente = ?, complemento = ? WHERE id_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getCpfCliente());
            stmt.setDate(3, (Date) cliente.getDataNascimento());
            stmt.setDate(4, (Date) cliente.getDataCadastro());
            stmt.setString(5, cliente.getEmailCliente());
            stmt.setInt(6, cliente.getTelefoneCliente());
            stmt.setString(7, cliente.getGenero());
            stmt.setString(8, cliente.getCepCliente());
            stmt.setInt(9, cliente.getNumeroCliente());
            stmt.setString(10, cliente.getComplemento());
            stmt.setInt(11, cliente.getIdCliente());
            stmt.executeUpdate();
        }
    }

    public void delete(int idCliente) throws SQLException {
        String sql = "DELETE FROM tb_cliente WHERE id_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        }
    }
}
