/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirdremake;

import java.awt.Graphics;

/**
 *
 * @author huyviet1995
 */
public abstract class ObjectController {
    protected float x;
    protected float y;
    public ObjectController(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    
    public void setX (int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int get
    
}
