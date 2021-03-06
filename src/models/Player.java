/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.util.Random;

/**
 *
 * @author Owner
 */
public class Player extends Link {
    
    private String hand;
    private Deck pocketCards;
    private int chips;
    private int bet;
    private boolean isPlaying;
    private boolean isHuman;
    private int boldness;
    private boolean antedUp;
    private int total;
    
    
    public Player(int newChips) {
        pocketCards = new Deck();
        setChips(newChips);
        setBoldness();
        isHuman = false;
        antedUp = false; 
    }
    
    public void setHuman() {
        isHuman = true;
    }
    
    public void setTotal(int newTotal) {
        if (newTotal > 0 && newTotal < 40) {
            total = newTotal;
        }
    }
    
    public void setBoldness() {
        Random randomGenerator = new Random();
        boldness = randomGenerator.nextInt(25);
    }
   
    public Deck getPocketCards() {
        return pocketCards;
    }
    
    public void setPocketCards(Deck newPocketCards) {
        pocketCards = newPocketCards;
    }
    
    public int getChips() {
        return chips;
    }
    
    public void setChips(int newChips) {
        if (newChips > 0) {
            chips = newChips;
        }
    }
   
    public Deck getCards() {
        return pocketCards;
    }
    
    @Override
    public String toString() {
        String data = "";
        data += "Player has " + chips + " in chips.\n";
        data += "Player boldness level is: " + boldness + "\n";
        
        if (pocketCards.getNumElements() > 0) {
            data += "Player cards are: ";
            data += pocketCards.getLast().toString();
            data += " and ";
            data += pocketCards.getNth(2).toString();
            data += "\n\n";
        }
        else {
            data += "Player has no cards.\n\n";
        }
        return data;
    }
    
    public boolean isHuman() {
        return isHuman;
    }
    
    public boolean isAntedUp() {
        return antedUp;
    }
    
    public boolean anteUp(int ante) {
        Random randomGenerator = new Random();
        int anteProbability = randomGenerator.nextInt(100);
        
        if (anteProbability < 100 - boldness) {
            chips -= ante;
            antedUp = true;
            return true;
        }
        else {
            antedUp = false;
            return false;
        }
    }
}