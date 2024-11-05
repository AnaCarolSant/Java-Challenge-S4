package fiap.tds.controller;

import fiap.tds.model.beans.Cliente;
import fiap.tds.model.bo.VeiculoClienteBO;
import fiap.tds.model.dao.ClienteDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClienteController {
    private ClienteDAO clienteDAO;
    private VeiculoClienteBO veiculoClienteBO;

    public ClienteController(Connection connection) {
        this.clienteDAO = new ClienteDAO(connection);
        this.veiculoClienteBO = new VeiculoClienteBO(connection);
    }

    // Inserir Cliente
    public void inserirCliente(Cliente cliente) throws SQLException {
        clienteDAO.insert(cliente);
    }

    // Atualizar Cliente
    public void atualizarCliente(Cliente cliente) throws SQLException {
        clienteDAO.update(cliente);
    }

    // Excluir Cliente
    public void excluirCliente(int idCliente) throws SQLException {
        if (!veiculoClienteBO.clienteExiste(idCliente)) {
            throw new SQLException("O cliente não pode ser excluído porque não existe.");
        }
        
        if (!clienteTemVeiculos(idCliente)) {
            clienteDAO.delete(idCliente);
        } else {
            throw new SQLException("O cliente não pode ser excluído porque possui veículos associados.");
        }
    }

    // Buscar Cliente por ID
    public Cliente buscarClientePorId(int idCliente) throws SQLException {
        return clienteDAO.findById(idCliente);
    }

    // Listar Todos os Clientes
    public List<Cliente> listarTodosClientes() throws SQLException {
        return clienteDAO.findAll();
    }

    // Verifica se o cliente tem veículos associados
    private boolean clienteTemVeiculos(int idCliente) throws SQLException {
        // Utilizando o método da BO para verificar se o cliente possui veículos
        return veiculoClienteBO.veiculoDuplicado(idCliente, "");
    }
}
