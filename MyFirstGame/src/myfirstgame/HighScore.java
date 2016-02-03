/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.Color;
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
    private HealthBar healthBar;
    public HighScore(Game game,HealthBar healthBar) {
        this.game = game;
        this.healthBar= healthBar;
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
        Font f1 = new Font("Liberation Mono",2,20);
        Font f3 = new Font("Liberation Mono",2,40);
        g.setColor(Color.red);
        g.setFont(f1);
        g.drawString("HIGH SCORE:"+healthBar.getScore(),Game.WIDTH/2-70,300);
        
        g.setFont(f3);
        g.drawRect(Game.WIDTH/2-150,500,300,100);
        g.drawString("BACK",Game.WIDTH/2-70,570);
    }
    
    
}
