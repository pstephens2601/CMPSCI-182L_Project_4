/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controllers.*;

/**
 *
 * @author Owner
 */
public class MenuBar extends JMenuBar {
    
    private GameController game;
    
    public MenuBar(GameController currentGame) {
        game = currentGame;
        buildMenu();
    }
    
    private void buildMenu() {
        JMenu fileMenu = new JMenu("File");
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exit);
        
        JMenu gameMenu = new JMenu("Game");
        
        JMenuItem start = new JMenuItem("New Game");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGame();
            }
        });
        gameMenu.add(start);
        
        JMenuItem end = new JMenuItem("End Game");
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.endGame();
            }
        });
        gameMenu.add(end);
        
        JMenu optionsMenu = new JMenu("Options");
        
                
        add(fileMenu);
        add(gameMenu);
        add(optionsMenu);
    }
}
