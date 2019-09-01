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
import montador.de.decks.domain.dao.IMonstroDAO;
import montador.de.decks.domain.entidades.Monstro;
import montador.de.decks.domain.entidades.Deck;

/**
 *
 * @author will
 */
public class MonstroDAOImplPostgreSQL implements IMonstroDAO {

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
    public void inserir(Monstro ent) {
        Connection con = criaConexao();
        String sql = "insert into monstro (nome,tipo,tipoinvocacao,effect,star,ataque,defesa) " + "values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setString(2, ent.getTipo());
            ps.setString(3, ent.getTipoInvocacao());
            ps.setString(4, ent.getEffect());
            ps.setString(5, ent.getStar());
            ps.setString(6, ent.getAtaque());
            ps.setString(7, ent.getDefesa());
            
            ps.execute();
            ps.close();
            con.close();
        } catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public void atualizar(Monstro ent) {
        Connection con = criaConexao();
        String sql = "update monstro set " + "nome = ? where id = ? ";
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
        String sql = "delete from monstro where id ="+id;
        try{
            con.createStatement().execute(sql);
            
        } catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public List<Monstro> consultar() {
        try{
           List<Monstro> lista = new ArrayList<>();
           
           String sql = "select * from monstro";
           Connection con = criaConexao();
           
           ResultSet res = con.createStatement().executeQuery(sql);
           
           while(res.next()){
               Monstro e = new Monstro();
               e.setId(res.getInt("id"));
               e.setNome(res.getString("nome"));
               e.setTipo(res.getString("tipo"));
               e.setTipoInvocacao(res.getString("tipoinvocacao"));
               e.setEffect(res.getString("effect"));
               e.setStar(res.getString("star"));
               e.setAtaque(res.getString("ataque"));
               e.setDefesa(res.getString("defesa"));
               lista.add(e);
           }
           
           return lista;
        }catch(Exception erro){
            erro.printStackTrace();
        }
        
        return null;
    }
    
    
    
}