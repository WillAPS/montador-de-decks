package controller;


import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import montador.de.decks.domain.dao.IMonstroDAO;
import montador.de.decks.domain.dao.postgresql.MonstroDAOImplPostgreSQL;
import montador.de.decks.domain.entidades.Monstro;



@Path("/monstro")
public class MonstroController{

    private final IMonstroDAO banco = new MonstroDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<Monstro> index(){
        return banco.consultar();
    }
    
    @GET
    @Path("/select")
    @Produces(MediaType.APPLICATION_JSON)
    public Monstro select(@QueryParam("id") int id){
        System.out.println("Parametro:"+id);
        for(Monstro cat : banco.consultar()){
            if(cat.getId() == id)
                return cat;
        }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar")
    public String cadastrar(@QueryParam("nome") String nome,@QueryParam("tipo") String tipo,@QueryParam("tipoinvocacao") String tipoinvocacao,@QueryParam("effect") String effect,
            @QueryParam("star") String star,@QueryParam("ataque") String ataque,@QueryParam("defesa") String defesa){
        System.out.println("Cadastrando ...");
        Monstro nova = new Monstro();
        nova.setNome(nome);
        nova.setTipo(tipo);
        nova.setTipoInvocacao(tipoinvocacao);
        nova.setEffect(effect);
        nova.setStar(star);
        nova.setAtaque(ataque);
        nova.setDefesa(defesa);
        System.out.println(tipoinvocacao);
        banco.inserir(nova);
        String ret = "{\"status\":1}";
        return ret;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/atualizar")
    public String atualizar(@QueryParam("id") int id, @QueryParam("nome") String nome){
        System.out.println("Att ...");
        Monstro nova = new Monstro();
        nova.setNome(nome);
        nova.setId(id);
        banco.atualizar(nova);
        String ret = "{\"status\":2}";
        return ret;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/remover")
    public Monstro remove(@QueryParam("id") int pk){
        System.out.println("Remove ...");
        for(Monstro cat : banco.consultar()){
            if(cat.getId() == pk )
            {
                banco.remover(cat.getId());
                return cat;
            }
        }
       return null;
    }
    
}