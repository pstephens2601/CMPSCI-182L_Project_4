/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javax.swing.*;
import java.awt.*;
import controllers.*;

/**
 *
 * @author Owner
 */
public class GameInfoPanel extends JPanel {
    
    private JLabel results;
    private GameController game;
    
    public GameInfoPanel(GameController currentGame) {
        game = currentGame;
        setBackground(new Color(110, 155, 66));
        setPreferredSize(new Dimension(1024, 40));
        setVisible(true);
        results = new JLabel("");
        results.setVisible(false);
        results.setForeground(Color.WHITE);
        results.setFont(new Font("Serif", Font.PLAIN, 24));
        add(results);  
    }
    
    public void endHand() {
        displayGameResults();
    }
    
    public void startGame() {
        results.setVisible(false);
    }
    
    public void endGame() {
        results.setVisible(false);
    }
    
    private void displayGameResults() {
        results.setText(game.getMessage());
        results.setVisible(true);
    }
}
