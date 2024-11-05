package fiap.tds.resource;

import fiap.tds.conexoes.DatabaseConnection;
import fiap.tds.model.beans.Cliente;
import fiap.tds.model.bo.ClienteBO;
import fiap.tds.model.dao.ClienteDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

    @Path("cliente")
    public class ClienteResource {

        private ClienteBO clienteBO;

        public ClienteResource() throws SQLException {
            Connection connection = DatabaseConnection.getConnection();
            clienteBO = new ClienteBO(new ClienteDAO(connection));
        }

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response listarClientes() {
            try {
                List<Cliente> clientes = clienteBO.selecionarBO();
                return Response.ok(clientes).build();
            } catch (SQLException | ClassNotFoundException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar clientes").build();
            }
        }

        @GET
        @Path("{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getClientePorId(@PathParam("id") int id) {
            try {
                Cliente cliente = clienteBO.selecionarPorIdBO(id);
                return cliente != null
                        ? Response.ok(cliente).build()
                        : Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado").build();
            } catch (SQLException | ClassNotFoundException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar cliente").build();
            }
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public Response cadastraCliente(Cliente cliente) {
            try {
                clienteBO.inserirBO(cliente);
                return Response.status(Response.Status.CREATED).entity("Cliente cadastrado com sucesso").build();
            } catch (SQLException | ClassNotFoundException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar cliente").build();
            }
        }

        @PUT
        @Path("{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response atualizaCliente(@PathParam("id") int id, Cliente cliente) {
            try {
                Cliente clienteExistente = clienteBO.selecionarPorIdBO(id);
                if (clienteExistente == null) {
                    return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado").build();
                }
                cliente.setIdCliente(id);
                clienteBO.atualizarBO(cliente);
                return Response.ok("Cliente atualizado com sucesso").build();
            } catch (SQLException | ClassNotFoundException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar cliente").build();
            }
        }

        @DELETE
        @Path("{id}")
        public Response deletaCliente(@PathParam("id") int id) {
            try {
                Cliente clienteExistente = clienteBO.selecionarPorIdBO(id);
                if (clienteExistente == null) {
                    return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado").build();
                }
                clienteBO.deletarBO(id);
                return Response.ok("Cliente deletado com sucesso").build();
            } catch (SQLException | ClassNotFoundException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar cliente").build();
            }
        }
    }

