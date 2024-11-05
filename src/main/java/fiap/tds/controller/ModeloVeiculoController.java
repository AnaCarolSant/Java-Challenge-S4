package fiap.tds.controller;

import fiap.tds.model.beans.ModeloVeiculo;
import fiap.tds.model.dao.ModeloVeiculoDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ModeloVeiculoController {
    private ModeloVeiculoDAO modeloVeiculoDAO;

    public ModeloVeiculoController(Connection connection) {
        this.modeloVeiculoDAO = new ModeloVeiculoDAO(connection);
    }

    // Inserir Modelo de Veículo
    public void inserirModeloVeiculo(ModeloVeiculo modeloVeiculo) throws SQLException {
        modeloVeiculoDAO.insert(modeloVeiculo);
    }

    // Atualizar Modelo de Veículo
    public void atualizarModeloVeiculo(ModeloVeiculo modeloVeiculo) throws SQLException {
        modeloVeiculoDAO.update(modeloVeiculo);
    }

    // Excluir Modelo de Veículo
    public void excluirModeloVeiculo(int idModeloVeiculo) throws SQLException {
         modeloVeiculoDAO.delete(idModeloVeiculo);
     
    }

    // Buscar Modelo de Veículo por ID
    public ModeloVeiculo buscarModeloVeiculoPorId(int idModeloVeiculo) throws SQLException {
        return modeloVeiculoDAO.findById(idModeloVeiculo);
    }

    // Listar Todos os Modelos de Veículo
    public List<ModeloVeiculo> listarTodosModelos() throws SQLException {
        return modeloVeiculoDAO.findAll();
    }


}
