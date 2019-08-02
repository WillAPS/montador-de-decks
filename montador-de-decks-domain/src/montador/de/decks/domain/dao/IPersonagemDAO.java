/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montador.de.decks.domain.dao;

import montador.de.decks.domain.entidades.Personagem;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface IPersonagemDAO {
    
    public void inserir(Personagem ent);
    public void atualizar(Personagem ent);
    public void remover(int id);
    public List<Personagem> consultar();
    
}
