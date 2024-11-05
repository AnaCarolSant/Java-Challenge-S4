package fiap.tds.controller;

import fiap.tds.model.beans.VeiculoCliente;
import fiap.tds.model.dao.VeiculoClienteDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VeiculoClienteController {
    private VeiculoClienteDAO veiculoClienteDAO;

    public VeiculoClienteController(Connection connection) {
        this.veiculoClienteDAO = new VeiculoClienteDAO(connection);
    }

    // Inserir Veículo
    public void inserirVeiculoCliente(VeiculoCliente veiculoCliente) throws SQLException {
        veiculoClienteDAO.insert(veiculoCliente);
    }

    // Atualizar Veículo
    public void atualizarVeiculoCliente(VeiculoCliente veiculoCliente) throws SQLException {
        veiculoClienteDAO.update(veiculoCliente);
    }

    // Excluir Veículo
    public void excluirVeiculoCliente(int idVeiculoCliente) throws SQLException {
        veiculoClienteDAO.delete(idVeiculoCliente);
    }

    // Buscar Veículo por ID
    public VeiculoCliente buscarVeiculoClientePorId(int idVeiculoCliente) throws SQLException {
        return veiculoClienteDAO.findById(idVeiculoCliente);
    }

    // Listar Todos os Veículos
    public List<VeiculoCliente> listarTodosVeiculos() throws SQLException {
        return veiculoClienteDAO.findAll();
    }
}
