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
public class Player extends Link {
    
    private Deck hand;
    private Deck cards;
    private int chips;
    private int bet;
    private boolean isPlaying;
    private boolean isHuman;
    
    
    public Player(int newChips) {
        cards = new Deck();
        setChips(newChips);
        isHuman = false;
    }
    
    public void setHuman() {
        isHuman = true;
    }
    
    public Deck getHand() {
        return hand;
    }
    
    public void setHand(Deck newHand) {
        hand = newHand;
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
        return cards;
    }
    
    @Override
    public String toString() {
        String data = "";
        data += chips;
        return data;
    }
}