/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montador.de.decks.domain.dao;

import montador.de.decks.domain.entidades.Monstro;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface IMonstroDAO {
    
    public void inserir(Monstro ent);
    public void atualizar(Monstro ent);
    public void remover(int id);
    public List<Monstro> consultar();
    
}
