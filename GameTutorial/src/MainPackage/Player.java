package MainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/*+
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author huyviet
 */
public class Player extends GameObject {

    private Random r = new Random();
    Handler handler = new Handler(); 
    HeadUpDisplay hud = new HeadUpDisplay();
    public Player(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        //The code below is only for sample use 
    }
    public void tick() {
       x+=velX;
       y+=velY;
       
       x = Game.clamp((int)x,0,Game.WIDTH-30);
       y = Game.clamp((int)y,0,Game.HEIGHT-60);
       this.collision();
      
    }
     private void collision() {
       for (int i = 0; i< this.handler.object.size();i++) {
          GameObject tempObject = handler.object.get(i);
          if (tempObject.getID()==ID.BasicEnemy || tempObject.getID()==ID.FastEnemy || tempObject.getID() == ID.SmartEnemy || tempObject.getID() == ID.EnemyBoss) {
              //collision code
              if (getBound().intersects(tempObject.getBound())) 
                  hud.HEALTH-=2;
          }
       }
       
       
       
    }
    
    public void render(Graphics g) {
        
        if (id == ID.Player) {
           g.setColor(Color.WHITE);
        }
        g.setColor(Color.WHITE);
        g.fillRect((int)x,(int) y, 5,5);
    }

    
    public Rectangle getBound() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new Rectangle((int)x,(int)y,32,32);
    }
    
  
}
