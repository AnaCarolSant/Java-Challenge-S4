package fiap.tds;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("tarefa")
public class TarefaResource {

    public static List<Tarefa> tarefas = new ArrayList<>(List.of(
            new Tarefa("Estudar java pra GS", false),
            new Tarefa("Estudar python pra GS", false),
            new Tarefa("Estudar oracle pra GS", false)
    ));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tarefa> getTarefas(){
        return tarefas;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Tarefa> getTarefa(@PathParam("id") int id){
        if(id >= 0 && id < tarefas.size())
            return Optional.of(tarefas.get(id));
        return Optional.empty();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }
}
