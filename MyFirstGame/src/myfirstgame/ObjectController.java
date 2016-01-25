/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author huyviet
 */

public abstract class ObjectController {
    protected float x;
    protected float y;
    //protected ID id;
    protected float velX;
    protected float velY;
    protected double degree;
    private ObjectHandler objectHandler;
    
    public ObjectController(float x, float y) {
        this.x =x;
        this.y=y;
        
        //this.id = id;
       
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle boundedArea();
    
   // public void setID (ID id) {
     //   this.id = id;
    
   // public ID getID() {
     //   return this.id;
    public void setDegree (double degree) {
        this.degree= degree;
    }
    public void setX (float x) {
        this.x=x;
    }
    public float getX() {
        return x;
    } 
    public void setY(float y) {
        this.y=y;
    }
    public float getY() {
        return y;
    }
    
    public void setVelX(float velX) {
        this.velX = velX;
    }
    public float getVelX() {
        return velX;
    }
    public void setVelY(float velY) {
        this.velY= velY;
    }
    
    public float getVelY () {
        return velY;
    }
        
}
