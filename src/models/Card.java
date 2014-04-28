/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import javax.swing.ImageIcon;
import java.awt.*;

/**
 *
 * @author Owner
 */
public class Card extends Link {
    
    private String suit;
    private int card;
    private Image cardImage;
    
    public Card(Link newLink, String newSuit, int newCard) {
        super(newLink);
        setSuit(suit);
        setCard(newCard);
        //setCardImage();
    }
    
    public Card(String newSuit, int newCard) {
        setSuit(newSuit);
        setCard(newCard);
        //setCardImage();
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
    
    public Image getCardImage() {
        return cardImage;
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
    
    public void setCardImage() {
        String imagePath = "/images/" + cardName() + "_of_" + suit + ".png";
        //System.out.println(this.getClass().getResource(imagePath));
        ImageIcon pic = new ImageIcon(this.getClass().getResource(imagePath));
        cardImage = pic.getImage();
    }
}
