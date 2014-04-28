/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import controllers.*;
import models.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class ActionBar extends JPanel {
    
    private GameController game;
    private JButton startHandButton;
    private JButton hitButton;
    private JButton stayButton;
    
    public ActionBar(GameController currentGame) {
        game = currentGame;
        setPreferredSize(new Dimension(1024, 40));
        setBackground(Color.BLACK);
        setLayout(new FlowLayout());
        addButtons();
        setVisible(true);
    }
    
    private void addButtons() {
        startHandButton = new JButton("Deal Cards");
        startHandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startHand();
            }
        });
        
        add(startHandButton);
        
        hitButton = new JButton("Hit");
        hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Player player = (Player)game.getPlayers().getFirst();
               game.hit(player);
            }
        });
        hitButton.setVisible(false);
        add(hitButton);
        
        stayButton = new JButton("Stay");
        stayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Player player = (Player)game.getPlayers().getFirst();
               game.stay();
            }
        });
        stayButton.setVisible(false);
        add(stayButton);
    }
    
    public void startHand() {
        startHandButton.setVisible(false);
        hitButton.setVisible(true);
        stayButton.setVisible(true);
        repaint();
    }
    
    public void endGame() {
        hitButton.setVisible(false);
        stayButton.setVisible(false);
        startHandButton.setVisible(true);
        repaint();
    }
    
    public void endHand() {
        hitButton.setVisible(false);
        stayButton.setVisible(false);
        startHandButton.setVisible(true);
        repaint();
    }
}
    
