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
    private GameScreen gameScreen;
    private MenuBar mainMenu;
    
    public GameWindow(GameController currentGame) {
        game = currentGame;
        screens = new CardLayout();
        screenContainer = new JPanel();
        add(screenContainer);
        screenContainer.setLayout(screens);
        mainMenu = new MenuBar(game);
        buildScreens();
        screens.show(screenContainer, "title");
        setJMenuBar(mainMenu);
        setTitle("Blackjack");
        setSize(1200, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void startGame() {
        gameScreen.startGame(); 
        screens.show(screenContainer, "game");
        mainMenu.startGame();
    }
    
    public void startHand() {
        gameScreen.startHand();
    }
    
    public void endHand() {
        gameScreen.endHand();
    }
    
    public void endGame() {
        screens.show(screenContainer, "title");
        mainMenu.endGame();
        gameScreen.endGame();
    }
    
    public void refresh() {
        gameScreen.refresh();
    }
    
    public void getGameOptions() {
        
    }
    
    private void buildScreens() {
        gameScreen = new GameScreen(game);
        screenContainer.add(gameScreen, "game");
        TitleScreen titleScreen = new TitleScreen();
        screenContainer.add(titleScreen, "title");
    }
}
