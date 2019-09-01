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
import montador.de.decks.domain.dao.IMagicTrapDAO;
import montador.de.decks.domain.entidades.MagicTrap;

/**
 *
 * @author will
 */
public class MagicTrapDAOImplPostgreSQL implements IMagicTrapDAO {

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
    public void inserir(MagicTrap ent) {
        Connection con = criaConexao();
        
        String sql = "insert into magictrap(nome,effecttype,magictrap)" + "values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setString(2, ent.getEffectType());
            ps.setString(3, ent.getMagicTrap());
            ps.execute();
            ps.close();
            con.close();
        } catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public void atualizar(MagicTrap ent) {
        Connection con = criaConexao();
        String sql = "update magictrap set " + "nome = ? where id = ? ";
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
        String sql = "delete from magictrap where id ="+id;
        try{
            con.createStatement().execute(sql);
            
        } catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public List<MagicTrap> consultar() {
        try{
           List<MagicTrap> lista = new ArrayList<>();
           
           String sql = "select * from magictrap";
           Connection con = criaConexao();
           
           ResultSet res = con.createStatement().executeQuery(sql);
           while(res.next()){
               MagicTrap f = new MagicTrap();
               f.setId(res.getInt("id"));
               f.setNome(res.getString("nome"));
               f.setEffectType(res.getString("effecttype"));
               f.setMagicTrap(res.getString("magictrap"));
               lista.add(f);
           }
           
           return lista;
        }catch(Exception erro){
            erro.printStackTrace();
        }
        
        return null;
    }
    
    
    
}