/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author huyviet
 */
public class Explosion extends ObjectController {
    private Color color;
    private float[][] explosionLine = new float[4][4];
    private int[] direction = {-3,-3,3,3};
    public Explosion(float x, float y,Color color) {
        super(x, y);
        this.color = color;
        this.velX=1;
        this.velY=1;
        //initialize all the line
     
    }
    public void oneTick() {
        
    }
    
    public void tick() {
        
    }

    public void render(Graphics g) {
        g.setColor(this.color);
        
    }
    
    public Rectangle boundedArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
