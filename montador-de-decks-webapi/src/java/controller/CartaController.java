package controller;


import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import montador.de.decks.domain.dao.ICartaDAO;
import montador.de.decks.domain.dao.postgresql.CartaDAOImplPostgreSQL;
import montador.de.decks.domain.entidades.Carta;



@Path("/carta")
public class CartaController{

    private final ICartaDAO banco = new CartaDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<Carta> index(){
        System.out.println();
        return banco.consultar();
    }
    
    @GET
    @Path("/select")
    @Produces(MediaType.APPLICATION_JSON)
    public Carta select(@QueryParam("id") int id){
        System.out.println("Parametro:"+id);
        for(Carta cat : banco.consultar()){
            if(cat.getId() == id)
                return cat;
        }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar")
    public String cadastrar(@QueryParam("nome") String nome){
        System.out.println("Cadastrando ...");
        Carta nova = new Carta();
        nova.setNome(nome);
        banco.inserir(nova);
        String ret = "{\"status\":1}";
        return ret;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/atualizar")
    public String atualizar(@QueryParam("id") int id, @QueryParam("nome") String nome){
        System.out.println("Att ...");
        Carta nova = new Carta();
        nova.setNome(nome);
        nova.setId(id);
        banco.atualizar(nova);
        String ret = "{\"status\":2}";
        return ret;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/remover")
    public Carta remove(@QueryParam("id") int pk){
        for(Carta cat : banco.consultar()){
            if(cat.getId() == pk )
            {
                banco.remover(cat.getId());
                return cat;
            }
        }
       return null;
    }
    
}