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
    private ActionBar playersInfo;
    private GameInfoPanel resultsPanel;
    
    public GameScreen(GameController currentGame) {
        game = currentGame;
        setLayout(new BorderLayout());
        setVisible(true);
    }
    
    public void startGame() {
        buildGameScreens();
    }
    
    public void endGame() {
        remove(gameTable);
        remove(playersInfo);
        remove(resultsPanel);
    }
    
    public void startHand() {
        gameTable.startHand();
        playersInfo.startHand();
        resultsPanel.startGame();
    }
    
    public void endHand() {
        gameTable.endHand();
        playersInfo.endHand();
        resultsPanel.endHand();
    }
    
    public void refresh() {
        gameTable.refresh();
    }
    
    public void buildGameScreens() {
        gameTable = new GameTable(game);
        add(gameTable, BorderLayout.CENTER);
        playersInfo = new ActionBar(game);
        add(playersInfo, BorderLayout.SOUTH);
        resultsPanel = new GameInfoPanel(game);
        add(resultsPanel, BorderLayout.NORTH);
    }
}
