package fiap.tds.resource;

import fiap.tds.conexoes.DatabaseConnection;
import fiap.tds.model.beans.VeiculoCliente;
import fiap.tds.model.bo.VeiculoClienteBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Path("veiculo")
public class VeiculoClienteResource {

    private VeiculoClienteBO veiculoClienteBO;

    public VeiculoClienteResource() {
        try {
            Connection connection = DatabaseConnection.getConnection(); // Certifique-se de ter essa classe que retorna uma conexão.
            this.veiculoClienteBO = new VeiculoClienteBO(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarVeiculos() {
        try {
            List<VeiculoCliente> veiculos = veiculoClienteBO.listar();
            return Response.ok(veiculos).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar veículos.").build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVeiculoPorId(@PathParam("id") int id) {
        try {
            VeiculoCliente veiculoCliente = veiculoClienteBO.obterPorId(id);
            if (veiculoCliente != null) {
                return Response.ok(veiculoCliente).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Veículo não encontrado").build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar veículo.").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastraVeiculo(VeiculoCliente veiculoCliente) {
        try {
            veiculoClienteBO.inserirVeiculo(veiculoCliente);
            return Response.status(Response.Status.CREATED).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar veículo.").build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizaVeiculo(@PathParam("id") int id, VeiculoCliente veiculoCliente) {
        try {
            veiculoCliente.setIdVeiculoCliente(id);
            veiculoClienteBO.atualizarVeiculo(veiculoCliente);
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar veículo.").build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deletaVeiculo(@PathParam("id") int id) {
        try {
            veiculoClienteBO.deletarVeiculo(id);
            return Response.ok().build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar veículo.").build();
        }
    }
}
