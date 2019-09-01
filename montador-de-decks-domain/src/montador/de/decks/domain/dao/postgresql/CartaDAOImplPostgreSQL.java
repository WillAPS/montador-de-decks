/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montador.de.decks.domain.dao.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import montador.de.decks.domain.dao.ICartaDAO;
import montador.de.decks.domain.entidades.Carta;
import montador.de.decks.domain.entidades.Deck;

/**
 *
 * @author will
 */
public class CartaDAOImplPostgreSQL implements ICartaDAO {

   private Connection criaConexao(){
        Connection conexao = null;
        try{
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/decks", "postgres", "123");
        } catch(Exception erro){
            erro.printStackTrace();
        }
        return conexao;
    }
    
   @Override
    public void inserir(Carta ent) {
        Connection con = criaConexao();
        String sql = "insert into (nome,deck_id) " + "value(?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setInt(2, ent.getDeck().getId());
            ps.execute();
            ps.close();
            con.close();
        } catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public void atualizar(Carta ent) {
        Connection con = criaConexao();
        String sql = "update carta set " + "nome = ? , deck_id = ? where id = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setInt(2, ent.getDeck().getId());
            ps.setInt(3, ent.getId());
            ps.execute();
            ps.close();
            con.close();
        } catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public void remover(int id) {
        Connection con = criaConexao();
        String sql = "delete from carta where id ="+id;
        try{
            con.createStatement().execute(sql);
            
        } catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public List<Carta> consultar() {
        try{
           List<Carta> lista = new ArrayList<>();
           
           String sql = "select * from carta";
           Connection con = criaConexao();
           
           ResultSet res = con.createStatement().executeQuery(sql);
           
           while(res.next()){
               Carta e = new Carta();
               e.setId(res.getInt("id"));
               e.setNome(res.getString("nome"));
               e.setDeck((Deck) res);
               lista.add(e);
           }
           
           return lista;
        }catch(Exception erro){
            erro.printStackTrace();
        }
        
        return null;
    }
    
    
    
}