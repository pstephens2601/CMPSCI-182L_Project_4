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
    private String gameResult;
    private PlayerList players;
    private Deck gameDeck;
    private Deck flop;
    private GameWindow window;
    private int button;
    private String game;
    private String message;
    private int playerTotal;
    private int dealerTotal;
     
    public GameController() {
        game = "blackjack";
        window = new GameWindow(this);
        
        if (game.compareTo("blackjack") == 0) {
            setNumberOfPlayers(1);
        }
        else {
            anteAmount = 2;
            startingChips = 100;
            setNumberOfPlayers(4);
        }
    }
    
    public final void setNumberOfPlayers(int newNumberOfPlayers) {
        if (newNumberOfPlayers > 0 && newNumberOfPlayers < 7) {
            numberOfPlayers = newNumberOfPlayers;
        }
    }
    
    public String getGame() {
        return game;
    }
    
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    
    public PlayerList getPlayers() {
        return players;
    }
    
    public final void setAnteAmount(int newAnteAmount) {
        if (newAnteAmount > 0) {
            anteAmount = newAnteAmount;
        }
    }
    
    public int getPlayerTotal() {
        return playerTotal;
    }
    
    public int getDealerTotal() {
        return dealerTotal;
    }
    
    public int getAnteAmount() {
        return anteAmount;
    }
    
    public void startGame() {
        addPlayers();
        window.startGame();
    }
    
    public void startHand() {
        deletePlayerCards();
        buildCardDeck();
        gameDeck.shuffle();
        dealCards();
        window.startHand();
        checkForBlackJack();
    }
    
    public void hit(Player player) {
        Deck cards = player.getCards();
        cards.copyToFirst((Card)gameDeck.getFirst());
        gameDeck.deleteFirst();
        player.setTotal(getTotal(player));
        
        if (getTotal(player) > 21) {
            endHand();
        }
        
        window.refresh();
    }
    
    public void stay() {
        Player dealer = (Player)players.getNth(2);
        
        if (getTotal(dealer) < 17) {  
            while (getTotal(dealer) < 17) {
                hit(dealer);
            }
        }
        else {
            endHand();
        }  
        endHand();
    }
    
    public int getTotal(Player player) {
        Deck playerCards = player.getCards();
        int newPlayerTotal = 0;
        int numAces = 0;
        
        for (int i = 1; i <= playerCards.getNumElements(); i++) {
            Card currentCard = (Card)playerCards.getNth(i);
            int cardNum = currentCard.getCard();
            
            if (cardNum > 1 && cardNum < 11) {
                newPlayerTotal += cardNum;
            }
            else if (cardNum > 10 && cardNum < 14) {
                newPlayerTotal += 10;
            }
            else {
                numAces++;
                newPlayerTotal += 11;
            }
        }
        
        if (numAces > 0 && newPlayerTotal > 21) {
            newPlayerTotal -= 10;
            if (numAces > 1 && newPlayerTotal > 21) {
                newPlayerTotal -= 10;
                if (numAces > 2 && newPlayerTotal > 21) {
                    newPlayerTotal -= 10;
                    if (numAces > 3 && newPlayerTotal > 21) {
                        newPlayerTotal -= 10;
                    }
                }
            }
        }
        
        return newPlayerTotal;
   }
   
   public String getMessage() {
       return message;
   }
   
   private void setMessage(int playerScore, int dealerScore) {
       
       String newMessage;
       
       if (playerScore > 21) {
           newMessage = "You bust with " + playerScore + "! Dealer has " + dealerScore + ".";  
       }
       else if (dealerScore > 21) {
           newMessage = "You Win! Dealer bust with " + dealerScore + "! You have " + playerScore + ".";
       }
       else if (playerScore > dealerScore) {
           newMessage = "You Win! You have " + playerScore + ", dealer has " + dealerScore + ".";
       }
       else if (playerScore == dealerScore) {
           newMessage = "It's a push. You have " + playerScore + ", dealer has " + dealerScore + ".";
       }
       else {
           newMessage = "You Lose! You have " + playerScore + ", dealer has " + dealerScore + ".";
       }
       
       message = newMessage;
   }
   
   public void endHand() {
       int playerScore = getTotal((Player)players.getFirst());
       int dealerScore = getTotal((Player)players.getNth(2)); 
       
       setMessage(playerScore, dealerScore);       
       window.endHand();
   }
    
    public void endGame() {
        endHand();
        deletePlayerCards();
        window.endGame();
        
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

        for (int j = 0; j <= numberOfPlayers; j++) {
            
            for (int i = 1; i <= 2; i++) {
                currentPlayer.getPocketCards().copyToFirst((Card)gameDeck.getFirst());
                gameDeck.deleteFirst();
            }
            currentPlayer = (Player)currentPlayer.getNext();
        }
    }
    
    private void checkForBlackJack() {
        if ((getTotal((Player)players.getFirst()) == 21) && (getTotal((Player)players.getNth(2)) != 21)) {
            message = "Blackjack! You win.";
            window.endHand();
        }
    }
    
    private void deletePlayerCards() {
        for (int i = 1; i <= players.getNumElements(); i++) {
            Player currentPlayer = (Player)players.getNth(i);
            Deck playerHand = currentPlayer.getCards();
            
            playerHand.deleteAll();
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