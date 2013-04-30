package br.com.myquimica.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.myquimica.dao.MisturaDAO;
import br.com.myquimica.database.Banco;
import br.com.myquimica.exception.NoContentException;
import br.com.myquimica.model.Mistura;

import com.google.gson.Gson;

@Path("/mistura")
public class MisturaResource {
   
    @GET
    @Path("/buscar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mistura> selTodos(){
     return MisturaDAO.getInstance().getAllMisturas();
    }

    @GET
    @Path("/buscarTodas")
    @Produces(MediaType.APPLICATION_JSON)
    public String selTodosGSON(){
     return new Gson().toJson(MisturaDAO.getInstance().getAllMisturas());
    }
   
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Mistura getCliente(@PathParam("id") int id){
     Mistura mistura = Banco.getBancoInstance().buscar(id);
    
     if(mistura == null)
         throw new NoContentException("Mistura não encontrado!");
    
     return mistura;
    }
   
    @GET
    @Path("/delete/{id}")
    @Produces("application/json")
    public String deleteMistura(@PathParam("id") int id){
     return Banco.getBancoInstance().delete(id);
    }
   
    @POST
    @Path("/inserir")
    @Produces("application/json")
    @Consumes("application/json")
    public String inserirMistura(Mistura mistura) {
     return Banco.getBancoInstance().inserir(mistura);
    }
}