/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.Graphics;
import java.awt.*;
/**
 *
 * @author huyviet
 */
public class FastEnemy extends GameObject {
    private Handler handler;
    public FastEnemy(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX=10;
        velY=10;
    }

    
    public void tick() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        x=x+velX;
        y=y+velY;
        
        if (y<=0 || y>=Game.HEIGHT-32) velY=-velY;
        if (x<=0 || x>=Game.WIDTH-32) velX=-velX;
        handler.addObject(new Trail(x,y,ID.Trail,Color.cyan,16,16,0.1f,handler));
    }
   
    public void render(Graphics g) {
       //measuring the size of a basic enemy block;
        g.setColor(Color.cyan);
        g.fillRect((int)x,(int)y,16,16);
    }

    
    public Rectangle getBound() {
      //measuring the magnitude of impact.
      return new Rectangle((int)x,(int)y,16,16);
    }
    
}
