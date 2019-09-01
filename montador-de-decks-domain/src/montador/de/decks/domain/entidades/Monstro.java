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
public class Monstro extends Carta {

    private String tipo;
    private String tipoinvocacao;
    private String effect;
    private String star;
    private String ataque;
    private String defesa;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoInvocacao() {
        return tipoinvocacao;
    }

    public void setTipoInvocacao(String tipoinvocacao) {
        this.tipoinvocacao = tipoinvocacao;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public String getDefesa() {
        return defesa;
    }

    public void setDefesa(String defesa) {
        this.defesa = defesa;
    }

    
}
