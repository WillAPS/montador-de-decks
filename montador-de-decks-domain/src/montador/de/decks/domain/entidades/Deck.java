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
public class Deck {
    
    private int id;
    private String nome;
    private String resumo;
    private int quantCards;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getQuantCards() {
        return quantCards;
    }

    public void setQuantCards(int quantCards) {
        this.quantCards = quantCards;
    }
    
    
    
    
}
