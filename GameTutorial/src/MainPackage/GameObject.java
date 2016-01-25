/*
 * This classing
 */
package MainPackage;

/**
 *
 * @author huyviet
 */
import javax.swing.*;
import java.awt.*;
public abstract class GameObject {
    protected float x,y;
    protected ID id ;
    protected float velX, velY;
    private Handler handler;
    
    public GameObject(float x, float y, ID id) {
        this.x=x;
        this.y=y;
        this.id=id;
        //this.handler = handler;
       
    }
    
    public abstract Rectangle getBound();
   
    public ID getID() {
        return id;
    }
    
    public void setID(ID id) {
        this.id = id;
    }
    
    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x=x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public float getVelX() {
        return velX;
    }
    public float getVelY() {
        return velY;
    }
    public void setVelX(int velX) {
        this.velX =velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
