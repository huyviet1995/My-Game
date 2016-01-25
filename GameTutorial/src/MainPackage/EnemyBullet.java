/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.Graphics;
import java.awt.*;
import java.util.Random;
/**
 *
 * @author huyviet
 */
public class EnemyBullet extends GameObject {
    private Handler handler;
    Random r = new Random();
    public EnemyBullet(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX=(r.nextInt(5- - 5)+-5);
        velY=5;
    }

    
    public void tick() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        x=x+velX;
        y=y+velY;
        
        //if (y<=0 || y>=Game.HEIGHT-32) velY=-velY;
        //if (x<=0 || x>=Game.WIDTH-32) velX=-velX;
        if (y>=Game.HEIGHT) handler.removeObject(this);
        handler.addObject(new Trail(x,y,ID.Trail,Color.blue,16,16,0.1f,handler));
    }
   
    public void render(Graphics g) {
       //measuring the size of a basic enemy block;
        g.setColor(Color.blue);
        g.fillRect((int)x,(int)y,16,16);
    }

    
    public Rectangle getBound() {
      //measuring the magnitude of impact.
      return new Rectangle((int)x,(int)y,16,16);
    }
    
    
    
    
    
}
