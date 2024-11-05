package fiap.tds.model.bo;

import fiap.tds.model.beans.Cliente;
import fiap.tds.model.dao.ClienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteBO {

    private ClienteDAO clienteDAO;

    // Construtor
    public ClienteBO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    // Inserir cliente
    public void inserirBO(Cliente cliente) throws ClassNotFoundException, SQLException {
        // Aplicação de regras de negócio... (se houver)
        clienteDAO.insert(cliente);
    }

    // Atualizar cliente
    public void atualizarBO(Cliente cliente) throws ClassNotFoundException, SQLException {
        // Aplicação de regras de negócio... (se houver)
        clienteDAO.update(cliente);
    }

    // Deletar cliente
    public void deletarBO(int idCliente) throws ClassNotFoundException, SQLException {
        // Aplicação de regras de negócio... (se houver)
        clienteDAO.delete(idCliente);
    }

    // Selecionar todos os clientes
    public ArrayList<Cliente> selecionarBO() throws ClassNotFoundException, SQLException {
        return (ArrayList<Cliente>) clienteDAO.findAll();
    }

    // Selecionar cliente por ID
    public Cliente selecionarPorIdBO(int idCliente) throws ClassNotFoundException, SQLException {
        return clienteDAO.findById(idCliente);
    }
}
