/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import myfirstgame.Game.STATE;

/**
 *
 * @author huyviet
 */
// 
public class Player extends ObjectController {
    private ObjectHandler objectHandler;
    private BufferedImage img;
    private MouseInput mouseInput;
    private int timer=10;
    private HealthBar healthBar;
    private int recoveryTime=100;
    private int sparkleTime = 5;
    private Game game;
    
    public Player(float x, float y, ObjectHandler objectHandler,MouseInput mouseInput, HealthBar healthBar, Game game) throws IOException {
        super(x, y);
        this.objectHandler = objectHandler;
        this.mouseInput = mouseInput;
        this.healthBar = healthBar;
        this.game = game;
        
        //mouseInput = new MouseInput(objectHandler);
    }
    

    public void tick() {
        x=x+velX;
        y=y+velY;
        
        if (recoveryTime >0) recoveryTime -- ;
        if (sparkleTime>=0) sparkleTime --;
        //System.out.println(recoveryTime);
        x=Game.clamp((int)x,0,Game.WIDTH-55);
        
        y=Game.clamp ((int)y,0,Game.HEIGHT-80);
        if (mouseInput.holding) {
            timer --;
            if (timer <= 0) {
                timer = 5;
                float deltaX = mouseInput.pointerX - this.getX();
                float deltaY = mouseInput.pointerY - this.getY();
                float distance = (float) Math.sqrt(deltaX*deltaX + deltaY*deltaY);
                float bulletVelX = (float) (10.0/distance*deltaX);
                float bulletVelY = (float) (10.0/distance*deltaY);
                Bullet bullet = new Bullet(x,y,objectHandler);
                bullet.setVelX(bulletVelX);
                bullet.setVelY(bulletVelY);
                objectHandler.addObject(bullet);
                
                
            }
        }
        this.isCollided();
    }
    
    
    public void render(Graphics g) {
        
        g.setColor(Color.white);
        g.fillOval((int)x,(int)y,25,25);
            
        //g.drawImage(scaleImage(50,50,"Image/triangle.jpg"),(int)x,(int)y,null);
    }

    //set the Rectangle that bounds the player
    public Rectangle boundedArea() {
        return new Rectangle((int)x,(int)y,25,25);
    }
    //set the collision of the object with the enemy
    public void isCollided() {
        for (int i =0;i<objectHandler.objects.size();i++) {
            ObjectController object = objectHandler.objects.get(i);
            if (object instanceof EnemyType1) {
                if (this.boundedArea().intersects(object.boundedArea()))
                    if (recoveryTime<=0) {
                        recoveryTime = 100;
                        healthBar.setLife(healthBar.getLife()-1);
                        objectHandler.addObject(new Explosion(x,y,Color.blue,objectHandler));
                        if (healthBar.getLife()==0) {
                            game.gameState = STATE.HighScore;
                        }
                    }
                
            }
        }
    }

    

    private Object ImgUtils() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //This code is fully copied from this source completely. I am still trying to understand the code/ 
    public BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) {
    BufferedImage bi = null;
    try {
        ImageIcon ii = new ImageIcon(filename);//path to image
        bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    return bi;
}
    
    
}
