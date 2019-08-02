/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montador.de.decks.domain.dao;

import montador.de.decks.domain.entidades.Carta;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface ICartaDAO {
    
    public void inserir(Carta ent);
    public void atualizar(Carta ent);
    public void remover(int id);
    public List<Carta> consultar();
    
}