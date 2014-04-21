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
public class GameScreen extends JPanel {
    
    private GameController game;
    private GameTable gameTable;
    
    public GameScreen(GameController currentGame) {
        setLayout(new BorderLayout());
        buildGameScreens();
        setVisible(true);
    }
    
    public void buildGameScreens() {
        gameTable = new GameTable();
        add(gameTable, BorderLayout.WEST);
    }
 
}
