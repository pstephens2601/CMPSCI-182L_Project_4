/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import java.awt.*;
import javax.swing.*;
import controllers.*;
import models.*;

/**
 *
 * @author Owner
 */
public class GameTable extends JPanel {
    
    private Image card;
    private GameController game;
    private Deck playerHand;
    private Deck dealerHand;
    private boolean cardsDealt = false;
    private boolean showCards = false;
    
    public GameTable(GameController currentGame) {
        setPreferredSize(new Dimension(500, 1024));
        setBackground(new Color(110, 155, 66));
        setVisible(true);
        
        game = currentGame;
    }
    
    public void startHand() {
        showCards = false;
        
        Player player = (Player)game.getPlayers().getFirst();
        playerHand = player.getCards();

        Player dealer = (Player)game.getPlayers().getNth(2);
        dealerHand = dealer.getCards();
            
        cardsDealt = true;
        repaint();
    }
    
    public void endHand() {
        showCards = true;
        repaint();
    }
    
    public void refresh() {
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        
        ImageIcon backPic = new ImageIcon(this.getClass().getResource("../images/background.png"));
        Image background = backPic.getImage();
        g2d.drawImage(background, 90, 0, this);
                
        if (cardsDealt == true) {
            
            int drawDistance; //sets card distance from edge

            int d_pos = 0;

            for (int i = dealerHand.getNumElements(); i >= 1; i--) {
                Card currentCard = (Card)dealerHand.getNth(i);
                currentCard.toString();
                currentCard.setCardImage();
                if(showCards || i <  dealerHand.getNumElements()) {
                    g2d.drawImage(currentCard.getCardImage(), (10 + d_pos), 10, this);
                }
                else {
                    ImageIcon pic = new ImageIcon(this.getClass().getResource("../images/card_back.png"));
                    Image cardBack = pic.getImage();
                    g2d.drawImage(cardBack, (10 + d_pos), 10, this);
                }
                d_pos += 170;
            }

            int pos = 0;

            for (int i = playerHand.getNumElements(); i >= 1; i--) {  
                Card currentCard = (Card)playerHand.getNth(i);
                currentCard.toString();
                currentCard.setCardImage();
                g2d.drawImage(currentCard.getCardImage(), (10 + pos), 300, this);
                pos += 170;
            }
        }
    }
}
