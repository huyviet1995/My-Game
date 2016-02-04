/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirdremake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author huyviet1995
 */
public class Game extends Canvas implements Runnable {
    
    Thread thread;
    private boolean running = false;
    public static final int width = 640;
    public static final int height = 480;
    
    public Game() {
        new Window(width,height,"Flappy Bird Remake", this);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop() {
        try {
            thread.join();
            running =false;
        } 
        catch(Exception e) {
            e.printStackTrace();
            
        }
    }
    
    public void run() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta =0;
        int frames =0;
        long timer = System.currentTimeMillis();
        
        while (running) {
            long now = System.nanoTime();
            delta+= (now-lastTime)/ns;
            lastTime = now;
            while (delta >=1) {
                
                this.tick();
                delta--;
            }
            if (running) {
                this.render();
            }
            
            frames++;
            //System.out.println("Hello World!");
            if (System.currentTimeMillis()-timer>1000) {
                timer+=1000;
                System.out.println("FPS:"+ frames);
                frames=0;
                
            }
            
        }
        
        stop();
    }
    
    public void tick() {
        
    }
    
    public void render () {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs==null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        paintComponent(g);
        
        g.dispose();
        bs.show();
    }
    
    private void paintComponent (Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0,0,width,height);
        
    }
    
    public static void main(String[] args)
    {
        new Game();
    }    
    
    
    
}
