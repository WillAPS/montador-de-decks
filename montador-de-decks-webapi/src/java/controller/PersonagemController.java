
package controller;


import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import montador.de.decks.domain.dao.IPersonagemDAO;
import montador.de.decks.domain.dao.postgresql.PersonagemDAOImplPostgreSQL;
import montador.de.decks.domain.entidades.Personagem;


@Path("/personagem")
public class PersonagemController {

    private final IPersonagemDAO banco = new PersonagemDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<Personagem> index(){
        return banco.consultar();
    }
    
    @GET
    @Path("/select")
    @Produces(MediaType.APPLICATION_JSON)
    public Personagem select(@QueryParam("id") int pk){
        System.out.println("Parametro:"+pk);
        for(Personagem cat : banco.consultar()){
            if(cat.getId() == pk)
                return cat;
        }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar")
    public String cadastrar(@QueryParam("geracao") String geracao, @QueryParam("nome") String nome){
        System.out.println("Cadastrando ...");
        Personagem nova = new Personagem();
        nova.setNome(nome);
        nova.setGeracao(geracao);
        banco.inserir(nova);
        String ret = "{\"status\":1}";
        return ret;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/atualizar")
    public String atualizar(@QueryParam("id") int id, @QueryParam("nome") String nome){
        System.out.println("Att ...");
        Personagem nova = new Personagem();
        nova.setNome(nome);
        nova.setId(id);
        banco.atualizar(nova);
        String ret = "{\"status\":2}";
        return ret;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/remover")
    public Personagem remove(@QueryParam("id") int pk){
        for(Personagem cat : banco.consultar()){
            if(cat.getId() == pk )
            {
                banco.remover(cat.getId());
                return cat;
            }
        }
       return null;
    }
    
}

