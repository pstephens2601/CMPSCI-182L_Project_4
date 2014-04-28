/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Owner
 */
public class TitleScreen extends JPanel {
    
    private Image title;
    
    public TitleScreen() {
        setBackground(new Color(110, 155, 66));
        setVisible(true);
        
        ImageIcon titlePic =  new ImageIcon(this.getClass().getResource("../images/title.png"));
        title = titlePic.getImage();
        
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.drawImage(title, 0, 0, this);
    }
    
    
}
