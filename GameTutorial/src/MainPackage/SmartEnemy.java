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
public class SmartEnemy extends GameObject {
    private Handler handler;
    private GameObject player;
    public SmartEnemy(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        for (GameObject tempObject: handler.object)
            if (tempObject instanceof Player) player = tempObject;
        
    }

    
    public void tick() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        x=x+velX;
        y=y+velY;
        float diffX = x - player.getX();
        float diffY = y - player.getY();
        float distance = (float) Math.sqrt(diffX*diffX + diffY*diffY);
        velX = (float) (-1.0/distance*diffX);
        velY = (float) (-1.0/distance*diffY);
        
        
        if (y<=0 || y>=Game.HEIGHT-32) velY=-velY;
        if (x<=0 || x>=Game.WIDTH-32) velX=-velX;
        handler.addObject(new Trail(x,y,ID.Trail,Color.red,16,16,0.1f,handler));
        System.out.println(player instanceof Player);
    }
   
    public void render(Graphics g) {
       //measuring the size of a basic enemy block;
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,16,16);
    }

    
    public Rectangle getBound() {
      //measuring the magnitude of impact.
      return new Rectangle((int)x,(int)y,16,16);
    }
    
}
