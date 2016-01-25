/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 *
 * @author huyviet
 */
public class KeyInput extends KeyAdapter {
    private ObjectHandler objectHandler;
    private ObjectController player;
    private boolean[] keydown = new boolean[4];
    public KeyInput (ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
        keydown[0]=false;
        keydown[1]=false;
        keydown[2]=false;
        keydown[3]=false;
    }
    
    private boolean isPlayer (ObjectController object) {
        if (object instanceof Player) {
        return true;
    }
        return false;
    }
    
    public void keyPressed (KeyEvent e) {
        int key = e.getKeyCode();
        for (int i =0;i<objectHandler.objects.size();i++) {
            if (objectHandler.objects.get(i) instanceof Player) {
                player = objectHandler.objects.get(i);
                break;
            }
        }
        
                float velX = player.getVelX();
                float velY = player.getVelY();
                
                if (key == KeyEvent.VK_W) {
                    player.setVelY(-5);
                    keydown[0]=true;
                }
                if (key == KeyEvent.VK_S) {
                    player.setVelY(5);
                    keydown[1]=true;
                }
                if (key == KeyEvent.VK_D) {
                    player.setVelX(5);
                    keydown[2]=true;
                }
                if (key == KeyEvent.VK_A) {
                    player.setVelX(-5);
                    keydown[3]=true;
                }
                
            
           // System.out.println(isPlayer(object));
        }
        
    
    
   public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i =0;i<objectHandler.objects.size();i++) {
            if (objectHandler.objects.get(i) instanceof Player) {
                player = objectHandler.objects.get(i);
                break;
            }
        }
            if (key == KeyEvent.VK_W) {
                    keydown[0]=false;
                }
                if (key == KeyEvent.VK_S) {
                    keydown[1]=false;
                }
                if (key == KeyEvent.VK_D) {;
                    keydown[2]=false;
                }
                if (key == KeyEvent.VK_A) {
                    keydown[3]=false;
                }
        if (!keydown[0] && !keydown[1]) player.setVelY(0);
        if (!keydown[2] && !keydown[3]) player.setVelX(0);
        
   }
}

