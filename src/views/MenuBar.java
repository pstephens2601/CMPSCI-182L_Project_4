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
        JMenu file = new JMenu("File");
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(exit);
        
        add(file);
    }
}
