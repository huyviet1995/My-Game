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
import myfirstgame.Game.STATE;

/**
 *
 * @author huyviet1995
 */
public class Tutorial extends MouseAdapter{
    private Game game;
    public Tutorial(Game game) {
        this.game = game;
    }
    
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (mouseOver(mx,my,Game.WIDTH/2-150,500,300,100))
            game.gameState=STATE.Menu;
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
        Font f1 = new Font("Liberation Mono",1,40);
        Font f2 = new Font("Liberation Mono",1,20);
        Font f3 = new Font("Liberation Mono",2,40);
        String intro = new String("Welcome to the 2D shooting games");
    
        
        g.setFont(f1);
        g.setColor(Color.red);
        g.drawString(intro,30,150);
        
        g.setFont(f2);
        g.drawString("The rules of this game are very simple, all you have to do is",30,250);
        g.drawString("Use the four keys WASD to move the player around",30,300);
        g.drawString("Use the mouse to aim at the enemies",30,350);
        g.drawString("Try to survive before losing all your give lives",30,400);
        
        g.setFont(f3);
        g.drawRect(Game.WIDTH/2-150,500,300,100);
        g.drawString("BACK",Game.WIDTH/2-70,570);
    }
}
