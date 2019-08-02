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
    
    private String effectType;
    private boolean magicTrap;

    public String getEffectType() {
        return effectType;
    }

    public void setEffectType(String effectType) {
        this.effectType = effectType;
    }

    public boolean isMagicTrap() {
        return magicTrap;
    }

    public void setMagicTrap(boolean magicTrap) {
        this.magicTrap = magicTrap;
    }
    
    
    
}
