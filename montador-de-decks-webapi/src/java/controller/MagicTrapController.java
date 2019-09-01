
package controller;


import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import montador.de.decks.domain.dao.IMagicTrapDAO;
import montador.de.decks.domain.dao.postgresql.MagicTrapDAOImplPostgreSQL;
import montador.de.decks.domain.entidades.MagicTrap;


@Path("/magictrap")
public class MagicTrapController {

    private final IMagicTrapDAO banco = new MagicTrapDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MagicTrap> index(){
        return banco.consultar();
    }
    
    @GET
    @Path("/select")
    @Produces(MediaType.APPLICATION_JSON)
    public MagicTrap select(@QueryParam("id") int id){
        System.out.println("Parametro:"+id);
        for(MagicTrap cat : banco.consultar()){
            if(cat.getId() == id)
                return cat;
        }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar")
    public String cadastrar(@QueryParam("nome") String nome, @QueryParam("effecttyoe") String effecttype, @QueryParam("magictrap") String magictrap){
        System.out.println("Cadastrando ...");
        MagicTrap nova = new MagicTrap();
        nova.setNome(nome);
        nova.setEffectType(effecttype);
        nova.setMagicTrap(magictrap);
        System.out.println(nome);
        banco.inserir(nova);
        String ret = "{\"status\":1}";
        return ret;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/atualizar")
    public String atualizar(@QueryParam("id") int id, @QueryParam("nome") String nome){
        System.out.println("Att ...");
        MagicTrap nova = new MagicTrap();
        nova.setNome(nome);
        nova.setId(id);
        banco.atualizar(nova);
        String ret = "{\"status\":2}";
        return ret;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/remover")
    public MagicTrap remove(@QueryParam("id") int pk){
        for(MagicTrap cat : banco.consultar()){
            if(cat.getId() == pk )
            {
                banco.remover(cat.getId());
                return cat;
            }
        }
       return null;
    }
    
}
