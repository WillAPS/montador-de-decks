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
import montador.de.decks.domain.dao.IPersonagemDAO;
import montador.de.decks.domain.entidades.Personagem;

/**
 *
 * @author will
 */
public class PersonagemDAOImplPostgreSQL implements IPersonagemDAO {

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
    public void inserir(Personagem ent) {
        Connection con = criaConexao();
        
        System.out.println(ent.getGeracao());
        
        String sql = "insert into personagem(nome,geracao) values" + "(?,?)";
        try {
            System.out.println(ent.getGeracao());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setString(2, ent.getGeracao());
            ps.execute();
            ps.close();
            con.close();
        } catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public void atualizar(Personagem ent) {
        Connection con = criaConexao();
        String sql = "update personagem set " + "nome = ? where id = ? ";
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
        String sql = "delete from personagem where id ="+id;
        try{
            con.createStatement().execute(sql);
            
        } catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public List<Personagem> consultar() {
        try{
           List<Personagem> lista = new ArrayList<>();
           
           String sql = "select * from personagem";
           Connection con = criaConexao();
           
           ResultSet res = con.createStatement().executeQuery(sql);
           
           while(res.next()){
               Personagem c = new Personagem();
               c.setId(res.getInt("id"));
               c.setNome(res.getString("nome"));
               c.setGeracao(res.getString("geracao"));
               lista.add(c);
           }
           
           return lista;
        }catch(Exception erro){
            erro.printStackTrace();
        }
        
        return null;
    }
    
    
    
}
