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
public class Bullet extends ObjectController{
    private ObjectHandler objectHandler;
    private ObjectController player;
    
    
    public Bullet(float x, float y, ObjectHandler objectHandler) {
        super(x, y);
        this.objectHandler = objectHandler;
 
    }

    
    public void tick() {
        x+=velX;
        y+=velY;
        //remove the object if it gets out of the boundary
        if (x<=0 || x>=Game.WIDTH -20) objectHandler.removeObject(this);
        if (y<=0 || y>=Game.HEIGHT - 20) objectHandler.removeObject(this);
        //add the trail for the bullet
        objectHandler.addObject(new Trail(x,y,Color.white,10,10,0.09f,objectHandler));
    }

    
    public void render(Graphics g) {
       g.setColor(Color.white);
       g.drawOval((int)x,(int)y,10,10);
    }

    
    public Rectangle boundedArea() {
       return new Rectangle((int)x,(int)y,25,25);
    }
    
}
