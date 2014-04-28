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
    private JMenuItem start;
    private JMenuItem end;
    private JMenu gameMenu;
    
    public MenuBar(GameController currentGame) {
        game = currentGame;
        buildMenu();
    }
    
    public void startGame() {
        gameMenu.insert(end, 0);
        gameMenu.remove(start);
    }
    
    public void endGame() {
        gameMenu.insert(start, 0);
        gameMenu.remove(end);
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
        
        gameMenu = new JMenu("Game");
        
        start = new JMenuItem("New Game");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGame();
            }
        });
        gameMenu.add(start);
        
        end = new JMenuItem("End Game");
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.endGame();
            }
        });
        //gameMenu.add(end);
                
        add(fileMenu);
        add(gameMenu);
    }
}
