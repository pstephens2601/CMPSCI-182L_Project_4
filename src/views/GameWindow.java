/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javax.swing.*;
import controllers.*;
        
/**
 *
 * @author Owner
 */
public class GameWindow extends JFrame {
    
    private GameController game;
    
    public GameWindow(GameController currentGame) {
        game = currentGame;
        MenuBar mainMenu = new MenuBar(game);
        setJMenuBar(mainMenu);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void startGame() {
        
    }
    
    public void getGameOptions() {
        
    }
}
