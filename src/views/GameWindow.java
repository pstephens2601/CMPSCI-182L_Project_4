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
public class GameWindow extends JFrame {
    
    private CardLayout screens;
    private JPanel screenContainer;
    private GameController game;
    
    public GameWindow(GameController currentGame) {
        game = currentGame;
        screens = new CardLayout();
        screenContainer = new JPanel();
        add(screenContainer);
        screenContainer.setLayout(screens);
        MenuBar mainMenu = new MenuBar(game);
        buildScreens();
        screens.show(screenContainer, "title");
        setJMenuBar(mainMenu);
        setTitle("Texas Hold'em");
        setSize(1024, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void startGame() {
        screens.show(screenContainer, "game");
    }
    
    public void getGameOptions() {
        
    }
    
    private void buildScreens() {
        GameScreen gameScreen = new GameScreen(game);
        screenContainer.add(gameScreen, "game");
        TitleScreen titleScreen = new TitleScreen();
        screenContainer.add(titleScreen, "title");
    }
}
