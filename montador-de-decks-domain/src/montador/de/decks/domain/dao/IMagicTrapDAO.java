/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montador.de.decks.domain.dao;

import montador.de.decks.domain.entidades.MagicTrap;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface IMagicTrapDAO {

    public void inserir(MagicTrap ent);

    public void atualizar(MagicTrap ent);

    public void remover(int id);

    public List<MagicTrap> consultar();

}
