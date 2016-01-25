/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author huyviet
 */
public class Menu extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
        
    }
    public void mouseReleased(MouseEvent e) {
        
    }
    public void tick() {
        
    }
    
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(400,200,100,100);
        
    }
}
