 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;

/**
 *
 * @author huyviet
 */

//I want to build something big
public class KeyInput extends KeyAdapter {
    private Handler handler;
    private boolean[] keydown = new boolean[4];
    public KeyInput(Handler handler) {
        this.handler = handler;
        keydown[0]=false;
        keydown[1]=false;
        keydown[2]=false;
        keydown[3]=false;
        
        
    }
    
    public void keyPressed (KeyEvent e) {
       this.keyHandler(e);
        
    }
    public void keyReleased (KeyEvent e) {
        int key = e.getKeyCode();
        for (int i=0; i<handler.object.size();i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ID.Player) {
                if (key == KeyEvent.VK_W) keydown[0]=false;
                if (key == KeyEvent.VK_A) keydown[1]=false;
                if (key == KeyEvent.VK_D) keydown[2]=false;
                if (key == KeyEvent.VK_S) keydown[3]=false;
                
                //vertical movment 
                if (!keydown[0] && !keydown[3]) tempObject.setVelY(0);
                
                //horizontal movmementt
                if (!keydown[1] && !keydown[2]) tempObject.setVelX(0);
                
                //test code
                System.out.println();
            }
        }
        
    }
    
    public void keyHandler(KeyEvent e) {
        int key = e.getKeyCode();
       for (int i=0; i<handler.object.size(); i++ ) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.Player) {
                float velX = tempObject.getVelX();
                float velY = tempObject.getVelY();
                //all the KeyEvent for player 1
                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5);
                    
                    keydown[0]=true;
                }    
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(-5);
                    
                    keydown[1]=true;
                }   
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(+5);
                    
                    keydown[2]=true;
                }  
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(5);
                    
                    keydown[3] = true;
                }  
                
                 
            }
            
       }
       if (key  == KeyEvent.VK_ESCAPE) System.exit(1);
    }
    
}
