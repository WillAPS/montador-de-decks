/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montador.de.decks.domain.entidades;

/**
 *
 * @author will
 */
public class MagicTrap extends Carta{
    
    private String effecttype;
    private String magictrap;

    public String getEffectType() {
        return effecttype;
    }

    public void setEffectType(String effecttype) {
        this.effecttype = effecttype;
    }

    public String getMagicTrap() {
        return magictrap;
    }

    public void setMagicTrap(String magictrap) {
        this.magictrap = magictrap;
    }
    
    
    
}
