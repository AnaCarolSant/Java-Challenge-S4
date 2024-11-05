package fiap.tds.model.bo;

import fiap.tds.model.beans.ModeloVeiculo;
import fiap.tds.model.dao.ModeloVeiculoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloVeiculoBO {

    private ModeloVeiculoDAO modeloVeiculoDAO;

    // Construtor
    public ModeloVeiculoBO(ModeloVeiculoDAO modeloVeiculoDAO) {
        this.modeloVeiculoDAO = modeloVeiculoDAO;
    }

    // Inserir modelo de veículo
    public void inserirBO(ModeloVeiculo modeloVeiculo) throws ClassNotFoundException, SQLException {
        // Aplicação de regras de negócio... (se houver)
        modeloVeiculoDAO.insert(modeloVeiculo);
    }

    // Atualizar modelo de veículo
    public void atualizarBO(ModeloVeiculo modeloVeiculo) throws ClassNotFoundException, SQLException {
        // Aplicação de regras de negócio... (se houver)
        modeloVeiculoDAO.update(modeloVeiculo);
    }

    // Deletar modelo de veículo
    public void deletarBO(int idModeloVeiculo) throws ClassNotFoundException, SQLException {
        // Aplicação de regras de negócio... (se houver)
        modeloVeiculoDAO.delete(idModeloVeiculo);
    }

    // Selecionar todos os modelos de veículo
    public ArrayList<ModeloVeiculo> selecionarBO() throws ClassNotFoundException, SQLException {
        return (ArrayList<ModeloVeiculo>) modeloVeiculoDAO.findAll();
    }

    // Selecionar modelo de veículo por ID
    public ModeloVeiculo selecionarPorIdBO(int idModeloVeiculo) throws ClassNotFoundException, SQLException {
        return modeloVeiculoDAO.findById(idModeloVeiculo);
    }
}
