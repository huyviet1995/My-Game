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
public class EnemyBoss extends GameObject {
    private Handler handler;
    private int timer=10;
    private int timer2 = 50;
    Random r = new Random();
    
    public EnemyBoss(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX=0;
        velY=5;
    }
    
    
    public void tick() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        x=x+velX;
        y=y+velY;
        if (timer<=0) velY=0;
        else timer --;
        
        if (timer<=0) timer2--;
        if (timer2<=0) {
            if (velX==0) velX=2; 
            int spawn = r.nextInt(10);
            if (spawn ==0) handler.addObject(new EnemyBullet((int)x, (int)y,ID.BasicEnemy,handler));
             
        }
        if (y<=0 || y>=Game.HEIGHT-32) velY=-velY;
        if (x<=0 || x>=Game.WIDTH-64) velX=-velX;
        //handler.addObject(new Trail(x,y,ID.Trail,Color.blue,64,64,0.002f,handler));
    }
   
    public void render(Graphics g) {
       //measuring the size of a basic enemy block;
        g.setColor(Color.blue);
        g.fillRect((int)x,(int)y,64,64);
    }
    
    
    public Rectangle getBound() {
      //measuring the magnitude of impact.
      return new Rectangle((int)x,(int)y,16,16);
    }
    
    
    
    
    
    
    
}
