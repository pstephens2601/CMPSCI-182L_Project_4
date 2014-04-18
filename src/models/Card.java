/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author Owner
 */
public class Card extends Link {
    
    private String suit;
    private int card;
    
    public Card(Link newLink, String newSuit, int newCard) {
        super(newLink);
        setSuit(suit);
        setCard(newCard);
    }
    
    public Card(String newSuit, int newCard) {
        setSuit(newSuit);
        setCard(newCard);
    }
    
    public final void setSuit(String newSuit) {
        suit = newSuit;
    }
    
    public final void setCard(int newCard) {
        if (newCard > 0 && newCard <= 14) {
            card = newCard;
        }
    }
    
    public int getCard() {
        return card;
    }
    
    public String getSuit() {
        return suit;
    }
    
    @Override
    public String toString() {    
        String cardInfo = cardName() + " of " + suit + "\n";
        return cardInfo;
    }
    
    public String cardName() {
        String cardName = "";
        
        if (card <= 10) {
            cardName += card;
        }
        else {
            switch(card) {
                case 11:
                    cardName += "Jack";
                    break;
                case 12:
                    cardName += "Queen";
                    break;
                case 13:
                    cardName += "King";
                    break;
                case 14:
                    cardName += "Ace";       
            }
        }
        
        return cardName;
    }
}
