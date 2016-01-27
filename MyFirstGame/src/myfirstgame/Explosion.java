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
    private ObjectHandler objectHandler;
    public Explosion(float x, float y,Color color,ObjectHandler objectHandler) {
        super(x, y);
        this.color = color;
        this.velX=1;
        this.velY=1;
        this.objectHandler = objectHandler;
        //initialize all the line
     
    }
    
    public void tick() {
        velX =velX+2;
        velY=velY+2;
        if (velX>=40 || velY>=40) {
            objectHandler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        g.setColor(this.color);
        g.drawOval((int)x,(int)y,(int)velX,(int)velY);
    }
    
    public Rectangle boundedArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
