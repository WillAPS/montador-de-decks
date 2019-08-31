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

    public int getQuantCards() {
        return quantCards;
    }

    public void setQuantCards(int quantCards) {
        this.quantCards = quantCards;
    }
    
    
    
    
}
