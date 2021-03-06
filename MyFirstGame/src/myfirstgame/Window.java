/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;
import myfirstgame.Game.STATE;

/**
 *
 * @author huyviet
 */
public class Window extends Canvas {
    
    public Window(int width, int height, String Title, Game game ) {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width,height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(game);
        frame.setVisible(true);
  
        game.start();
    }
}
