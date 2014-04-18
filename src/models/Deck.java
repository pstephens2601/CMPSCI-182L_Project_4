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
public class Deck extends LinkedList {
    
    private int numCards;
    
    public Deck() {
        
    }
    
    public void shuffle() {
        Deck tempDeck = new Deck();

        while (numElements > 0) {
            int rand = 1 + (int)(Math.random() * ((numElements - 1) + 1));
            if (rand <= numElements && rand > 0) { 
                tempDeck.copyToFirst(getCard(rand));
                delete(rand);
            }
        }
        
        while (tempDeck.getNumElements() > 0) {
            copyToFirst((Card)tempDeck.getFirst());
            tempDeck.deleteFirst();
        }
    }
    
    public void copyToLast(Card sourceCard) {
        Card copy = new Card(sourceCard.getSuit(), sourceCard.getCard());
        insertLast(copy);
    }
    
    public void copyToFirst(Card sourceCard) {
        Card copy = new Card(sourceCard.getSuit(), sourceCard.getCard());
        insertFirst(copy);
    }
    
    public void addCard(Card newCard) {
        insertFirst(newCard);
        numCards++;
    }
    
    @Override
    public String toString() {
        
        Link current = (Card)first;
        boolean stop = false;
        String data = "";
        
        while (!isEmpty() && stop != true) {
            data += current.toString();
            if (current.getNext() != null) {
                current = (Card)current.getNext();
            }
            else {
                stop = true;
            }
        }
        
        return data;
    }
    
    public Card getCard(int cardNumber) {
        Card selectedCard = (Card)getNth(cardNumber);
        return selectedCard;  
    }
    
}
