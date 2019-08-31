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
import montador.de.decks.domain.dao.IDeckDAO;
import montador.de.decks.domain.entidades.Deck;

/**
 *
 * @author will
 */
public class DeckDAOImplPostgreSQL implements IDeckDAO {

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
    public void inserir(Deck ent) {
        Connection con = criaConexao();
        
        String sql = "insert into deck (nome)" + "VALUES('"+ent.getNome()+"')";
        try {
            con.createStatement().execute(sql);
        } catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public void atualizar(Deck ent) {
        Connection con = criaConexao();
        String sql = "update deck set " + "nome = ? where id = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setInt(2, ent.getId());
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
        String sql = "delete from deck where id ="+id;
        try{
            con.createStatement().execute(sql);
            
        } catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public List<Deck> consultar() {
        try{
           List<Deck> lista = new ArrayList<>();
           
           String sql = "select * from deck";
           Connection con = criaConexao();
           
           ResultSet res = con.createStatement().executeQuery(sql);
           
           while(res.next()){
               Deck c = new Deck();
               c.setId(res.getInt("id"));
               c.setNome(res.getString("nome"));
               c.setQuantCards(res.getInt("quantCards"));
               lista.add(c);
           }
           
           return lista;
        }catch(Exception erro){
            erro.printStackTrace();
        }
        
        return null;
    }
    
    
    
}