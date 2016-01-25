/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * The code for the trail class is completely taken from the this source: 
 * @author huyviet
 */
public class Trail extends ObjectController {

    private float alpha =1;
    private ObjectHandler objectHandler;
    private Color color;
    private int width, height;
    private double life;
    
    public Trail(float x, float y, Color color, int width, int height, double life, ObjectHandler objectHandler) {
        super(x, y);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.objectHandler = objectHandler;
    }
    
    
    public void tick() {
        if (alpha >life) {
            alpha -= life - 0.0001f;
        } else objectHandler.removeObject(this);
    }

    
    public void render(Graphics g) {
       Graphics2D g2d = (Graphics2D)g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.drawOval((int)x,(int)y,width,height);
        g2d.setComposite(makeTransparent(1));
    }

    
    public Rectangle boundedArea() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type,alpha));
    }

    
    
    
}
