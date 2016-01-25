/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import javax.swing.Timer;
import java.util.TimerTask;
import javax.swing.SwingUtilities;


/**
 *
 * @author huyviet
 */
public class MouseInput extends MouseInputAdapter {
    private ObjectHandler objectHandler;
    private ObjectController player;
    private Timer timer;
    public boolean holding;
    public float pointerX;
    public float pointerY;
    public MouseInput(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
        
    }
    
    
    
    public void mouseDragged(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if (SwingUtilities.isLeftMouseButton(e)) {
           holding = true;
           pointerX=e.getX();
           pointerY=e.getY();
       }
    }
    
    
    public void mouseMoved(MouseEvent e) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public void mouseClicked(MouseEvent e) {
     // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     if (SwingUtilities.isLeftMouseButton(e)) {
           holding = true;
           pointerX=e.getX();
           pointerY=e.getY();
       }
    }

    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if (SwingUtilities.isLeftMouseButton(e)) {
           e.consume();
           holding =false;
       }
       
       
    }

    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
    }

    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}