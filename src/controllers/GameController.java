/*------------------------------------------------------------------------------
Programmer: Patrick Stephens
Development Date: 4/8/2014
Project: CMPSCI 182L - Project #4 - Professor Ferguson
Project Description: Texas Hold'em card game demonstrating the use of linked
lists.
------------------------------------------------------------------------------*/

package controllers;

import models.*;
import views.*;
/**
 *
 * @author Owner
 */
public class GameController {
    
    private int pot;
    private int numberOfPlayers;
    private int startingChips;
    private int anteAmount;
    private PlayerList players;
    private Deck gameDeck;
    private Deck flop;
    private GameWindow window;
    
    public GameController() {
        window = new GameWindow(this);
        anteAmount = 2;
        startingChips = 100;
        setNumberOfPlayers(4);
    }
    
    public final void setNumberOfPlayers(int newNumberOfPlayers) {
        if (newNumberOfPlayers > 0 && newNumberOfPlayers < 7) {
            numberOfPlayers = newNumberOfPlayers;
        }
    }
    
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    
    public final void setAnteAmount(int newAnteAmount) {
        if (newAnteAmount > 0) {
            anteAmount = newAnteAmount;
        }
    }
    
    public int getAnteAmount() {
        return anteAmount;
    }
    
    public void startGame() {
        addPlayers();
        buildCardDeck();
        System.out.println(gameDeck.toString());
        gameDeck.shuffle();
        window.startGame();
        //startHand();
    }
    
    public void startHand() {
        collectAntes();
        dealCards();
        flop = new Deck(); 
    }
    
    public void collectAntes() {
        
    }
    
    public void endGame() {
        
    }
    
    public final void setGameOptions() {
        window.getGameOptions();
    }
    
    public void addPlayers() {
        
        players = new PlayerList();
        players.add(new Player(startingChips));
        
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(startingChips));
        }
    }
    
    private void dealCards() {
        Player currentPlayer = (Player)players.getFirst();
        
        for (int j = 0; j < numberOfPlayers; j++) {
            for (int i = 1; i <= 2; i++) {
               currentPlayer.getCards().copyToFirst((Card)gameDeck.getFirst());
               gameDeck.deleteFirst();
            }
        
            currentPlayer = (Player)currentPlayer.getNext();
        }
    }
    
    private void buildCardDeck() {
        
        gameDeck = new Deck();
        
        for (int i = 2; i <= 14; i ++) {
            gameDeck.addCard(new Card("hearts", i));
        }
        
        for (int i = 2; i <= 14; i ++) {
            gameDeck.addCard(new Card("diamonds", i));
        }
        
        for (int i = 2; i <= 14; i ++) {
            gameDeck.addCard(new Card("spades", i));
        }
        
        for (int i = 2; i <= 14; i ++) {
            gameDeck.addCard(new Card("clubs", i));
        }
    }
}