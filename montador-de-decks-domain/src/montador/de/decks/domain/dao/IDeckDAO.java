/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montador.de.decks.domain.dao;

import montador.de.decks.domain.entidades.Deck;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface IDeckDAO {
    
    public void inserir(Deck ent);
    public void atualizar(Deck ent);
    public void remover(int id);
    public List<Deck> consultar();
    
}