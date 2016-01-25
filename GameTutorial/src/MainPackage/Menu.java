/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import MainPackage.Game.STATE;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author huyviet
 */
public class Menu extends MouseAdapter{ 
    private Game game;
    private Handler handler;
    
    public Menu (Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }
    
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (mouseOver(mx, my, 210,150, 200,64)) {
            game.gameState = STATE.Game;
        }
    }
    
    public void mouseReleased(MouseEvent e) {
        
    }
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < width ) {
            if (my >y && my < y + height) {
                return true;
            } else return false;
        }
            else 
                return false;
    
    }
    
    public void tick(){
        
    }
    public void render(Graphics g) {
       Font font = new Font("Arial",1,50);
                
       g.setFont(font);
        g.setColor(Color.red);
                g.drawString("Menu",100,50);
                
                g.setColor(Color.white);
                g.drawRect(210,150,200,64);
                g.drawString("Play",270,190);
                
                
                g.setColor(Color.white);
                g.drawRect(210,250,200,64);
                g.drawString("Help",270,290);
                
                g.setColor(Color.white);
                g.drawRect(210,350,200,64);
                g.drawString("Quit",270,390);
    }
}
