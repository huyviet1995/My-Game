/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author huyviet
 */
public class EnemyType1 extends ObjectController {
    private ObjectController player;
    private ObjectHandler objectHandler;
    private int timer =100;
    
    
    public EnemyType1(int x, int y,ObjectHandler objectHandler) {
        super(x,y);
        this.objectHandler = objectHandler;
        //this.tag = tag;
        for (ObjectController tempObject: objectHandler.objects) {
            if (tempObject instanceof Player) player = tempObject;
            break;
        }
    }
    public void isCollided() {
        for (int i =0;i<objectHandler.objects.size();i++) {
            ObjectController object = objectHandler.objects.get(i);
            if (object instanceof Bullet) {
                if (this.boundedArea().intersects(object.boundedArea())) {
                    objectHandler.removeObject(object);
                    objectHandler.removeObject(this);
                }
            }
        }
    }
   
    public void tick() {
        timer -- ;
        if (timer<=0) {
        x=x+velX;
        y=y+velY;
        float deltaX = x - player.getX();
        float deltaY = y - player.getY();
        float distance = (float) Math.sqrt(deltaX*deltaX+deltaY*deltaY);
        velX = (float)-3.0/distance*deltaX;
        velY = (float)-3.0/distance*deltaY;
        //set the trajectory of the tag
        
        //set the rotation of the mouse
        //add the trail for the object
        //objectHandler.addObject(new Trail(x,y,Color.red,25,25,0.1f,objectHandler));
        this.isCollided();
        }
        }
    

    
    public void render(Graphics g) {
       g.setColor(Color.white);
       g.drawOval((int)x, (int)y, 25,25);
       
    }

    
    public Rectangle boundedArea() {
        return new Rectangle((int)x,(int)y,25,25);
    }
    
}
