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
 * @author huyviet
 */
public class Menu extends MouseAdapter {
    Game game;
    public Menu (Game game) {
        this.game = game;
    }
    
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        System.out.println(mx+""+my);
        if (mouseOver(mx,my,Game.WIDTH/2-150,300,300,100)) {
            game.gameState = STATE.Game;
        }
        if (mouseOver(mx,my,Game.WIDTH/2-150,400,300,100)) {
            game.gameState = STATE.Tutorial;
        }
        
        
        
    }
    public void mouseReleased(MouseEvent e) {
        
    }
    public void tick() {
        
    }
    
    private boolean mouseOver(int mx, int my, int x,int y, int width, int height) {
        if (mx > x && mx < x+ width )
            if (my>y && my <y+height ) {
                return true;
            }
        return false;
    }
    
    public void render(Graphics g) {
        Font f1 = new Font("Liberation Mono",1,60);
        Font f2 = new Font("Liberation Mono",1,30);
        Font f3 = new Font("Liberation Mono",1,20);
        Font f4 = new Font("Liberation Mono",1,40);
        
        String intro ="Welcome to my shooting game";
        String footer="Copyright 2016, Viet H Dang, vietdanghuy.95@gmail.com";
        String play ="Let's play";
        
        
        
        g.setFont(f2);
        g.setColor(Color.blue);
        g.drawString(intro, Game.WIDTH/2-200,100);
        
        
        
        g.setFont(f1);
        g.setColor(Color.white);
        g.drawString("Menu",Game.WIDTH/2-60,200);
        
        //Let's play
        g.setFont(f4);
        g.setColor(Color.red);
        g.drawString(play, Game.WIDTH/2-120,350);
        
        //Tutorial
        g.setFont(f4);
        g.setColor(Color.red);
        g.drawString("Tutorial",Game.WIDTH/2-120,450);
        //Exit
        g.setFont(f4);
        g.setColor(Color.red);
        g.drawString("Exit game", Game.WIDTH/2-120,550);
        //set three menus of the game
        g.setColor(Color.white);
        g.drawRect(Game.WIDTH/2-150,300,300,100);
        
        g.setColor(Color.white);
        g.drawRect(Game.WIDTH/2-150,400,300,100);
        
        g.setColor(Color.white);
        g.drawRect(Game.WIDTH/2-150,500,300,100);
        //end of menu setup
        
        g.setFont(f3);
        g.setColor(Color.white);
        g.drawString(footer,Game.WIDTH/2-200,50);
        
    }
}
