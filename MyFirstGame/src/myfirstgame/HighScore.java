/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author huyviet1995
 */
public class HighScore extends MouseAdapter {
    private Game game;
    public HighScore(Game game) {
        this.game = game;
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        if (game.gameState == Game.STATE.HighScore) {
        if (mouseOver(mx,my,Game.WIDTH/2-150,500,300,100)) {
            game.gameState=Game.STATE.Menu;
        }
        }
    }
    
    public void mouseReleased(MouseEvent e) {
        
    }
    
    private boolean mouseOver(int mx, int my, int x,int y, int width, int height) {
        if (mx > x && mx < x+ width )
            if (my>y && my <y+height ) {
                return true;
            }
        return false;
    }
    
    public void tick() {
        
    }
    public void render(Graphics g) {
        //set the high score of the game
        
        
        Font f3 = new Font("Liberation Mono",2,40);
        g.setFont(f3);
        g.drawRect(Game.WIDTH/2-150,500,300,100);
        g.drawString("BACK",Game.WIDTH/2-70,570);
    }
    
    
}
