package fiap.tds.model.bo;

import fiap.tds.controller.VeiculoClienteController;
import fiap.tds.model.beans.VeiculoCliente;
import fiap.tds.model.dao.ClienteDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VeiculoClienteBO {

    private VeiculoClienteController veiculoClienteController;
    private ClienteDAO clienteDAO;

    public VeiculoClienteBO(Connection connection) {
        this.veiculoClienteController = new VeiculoClienteController(connection);
        this.clienteDAO = new ClienteDAO(connection);
    }

    // Verificação de Cliente Existente
    public boolean clienteExiste(int idCliente) throws SQLException {
        return clienteDAO.findById(idCliente) != null;
    }

    // Validação de Veículo (não duplicado para o mesmo cliente)
    public boolean veiculoDuplicado(int idCliente, String placa) throws SQLException {
        List<VeiculoCliente> veiculos = veiculoClienteController.listarTodosVeiculos();
        for (VeiculoCliente veiculo : veiculos) {
            if (veiculo.getIdCliente() == idCliente && veiculo.getPlacaVeiculo().equals(placa)) {
                return true;
            }
        }
        return false;
    }

    // Atualização de Veículo
    public void atualizarVeiculo(VeiculoCliente veiculoCliente) throws SQLException {
        if (!clienteExiste(veiculoCliente.getIdCliente())) {
            throw new IllegalArgumentException("Cliente não existe.");
        }
        veiculoClienteController.atualizarVeiculoCliente(veiculoCliente);
    }

    // Método para inserir veículo com validações
    public void inserirVeiculo(VeiculoCliente veiculoCliente) throws SQLException {
        if (!clienteExiste(veiculoCliente.getIdCliente())) {
            throw new IllegalArgumentException("Cliente não existe.");
        }
        if (veiculoDuplicado(veiculoCliente.getIdCliente(), veiculoCliente.getPlacaVeiculo())) {
            throw new IllegalArgumentException("Veículo já cadastrado para este cliente.");
        }
        veiculoClienteController.inserirVeiculoCliente(veiculoCliente);
    }

    // Método para deletar veículo
    public void deletarVeiculo(int idVeiculoCliente) throws SQLException {
        veiculoClienteController.excluirVeiculoCliente(idVeiculoCliente);
    }

    // Método para buscar veículo por ID
    public VeiculoCliente obterPorId(int idVeiculoCliente) throws SQLException {
        return veiculoClienteController.buscarVeiculoClientePorId(idVeiculoCliente);
    }

    // Método para listar veículos
    public List<VeiculoCliente> listar() throws SQLException {
        return veiculoClienteController.listarTodosVeiculos();
    }
}
