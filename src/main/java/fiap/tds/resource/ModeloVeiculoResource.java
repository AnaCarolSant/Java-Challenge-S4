package fiap.tds.resource;

import fiap.tds.conexoes.DatabaseConnection;
import fiap.tds.model.beans.ModeloVeiculo;
import fiap.tds.model.bo.ModeloVeiculoBO;
import fiap.tds.model.dao.ModeloVeiculoDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Path("modeloVeiculo")
public class ModeloVeiculoResource {

    private ModeloVeiculoBO modeloVeiculoBO;

    public ModeloVeiculoResource() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            modeloVeiculoBO = new ModeloVeiculoBO(new ModeloVeiculoDAO(connection));
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarModelosVeiculo() {
        try {
            List<ModeloVeiculo> modelos = modeloVeiculoBO.selecionarBO();
            return Response.ok(modelos).build();
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar modelos de veículo").build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModeloVeiculoPorId(@PathParam("id") int id) {
        try {
            ModeloVeiculo modelo = modeloVeiculoBO.selecionarPorIdBO(id);
            return modelo != null
                    ? Response.ok(modelo).build()
                    : Response.status(Response.Status.NOT_FOUND).entity("Modelo de veículo não encontrado").build();
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar modelo de veículo").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastraModeloVeiculo(ModeloVeiculo modeloVeiculo) {
        try {
            modeloVeiculoBO.inserirBO(modeloVeiculo);
            return Response.status(Response.Status.CREATED).entity("Modelo de veículo cadastrado com sucesso").build();
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar modelo de veículo").build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizaModeloVeiculo(@PathParam("id") int id, ModeloVeiculo modeloVeiculo) {
        try {
            ModeloVeiculo modeloExistente = modeloVeiculoBO.selecionarPorIdBO(id);
            if (modeloExistente == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Modelo de veículo não encontrado").build();
            }
            modeloVeiculo.setIdModeloVeiculo(id); // Define o ID do modelo de veículo a ser atualizado
            modeloVeiculoBO.atualizarBO(modeloVeiculo);
            return Response.ok("Modelo de veículo atualizado com sucesso").build();
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar modelo de veículo").build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deletaModeloVeiculo(@PathParam("id") int id) {
        try {
            ModeloVeiculo modeloExistente = modeloVeiculoBO.selecionarPorIdBO(id);
            if (modeloExistente == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Modelo de veículo não encontrado").build();
            }
            modeloVeiculoBO.deletarBO(id);
            return Response.ok("Modelo de veículo deletado com sucesso").build();
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar modelo de veículo").build();
        }
    }
}
