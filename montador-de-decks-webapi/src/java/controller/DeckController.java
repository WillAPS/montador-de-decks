
package controller;


import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import montador.de.decks.domain.dao.IDeckDAO;
import montador.de.decks.domain.dao.postgresql.DeckDAOImplPostgreSQL;
import montador.de.decks.domain.entidades.Deck;


@Path("/deck")
public class DeckController {

    private final IDeckDAO banco = new DeckDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<Deck> index(){
        return banco.consultar();
    }
    
    @GET
    @Path("/select")
    @Produces(MediaType.APPLICATION_JSON)
    public Deck select(@QueryParam("id") int pk){
        System.out.println("Parametro:"+pk);
        for(Deck cat : banco.consultar()){
            if(cat.getId() == pk)
                return cat;
        }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar")
    public String cadastrar(@QueryParam("nome") String nome){
        System.out.println("Cadastrando ...");
        Deck nova = new Deck();
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
        Deck nova = new Deck();
        nova.setNome(nome);
        nova.setId(id);
        banco.atualizar(nova);
        String ret = "{\"status\":2}";
        return ret;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/remover")
    public Deck remove(@QueryParam("id") int pk){
        for(Deck cat : banco.consultar()){
            if(cat.getId() == pk )
            {
                banco.remover(cat.getId());
                return cat;
            }
        }
       return null;
    }
    
}

