/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;

/**
 *
 * @author huyviet
 */
public class Game extends Canvas implements Runnable {
    public Thread thread;
    private boolean running = false;
    public static final int WIDTH = 960;
    public static final int HEIGHT = 640;
    private ObjectHandler objectHandler ;
    private MouseInput mouseInput;
    private HealthBar healthBar;
    private EnemyGenerator enemyGenerator;
    private Menu menu;
    private Tutorial tutorial;
    
    public enum STATE {
        Menu,
        Game,
        Tutorial;
    };
    public STATE gameState = STATE.Menu;
    
    public Game() throws IOException {
        
        //Initialize the objectHandler and add the keyInput 
        objectHandler = new ObjectHandler();
        mouseInput = new MouseInput(objectHandler);
        healthBar = new HealthBar(0,10,1);
        enemyGenerator = new EnemyGenerator (objectHandler,healthBar);
        menu = new Menu(this);
        tutorial = new Tutorial(this);
        
        this.addKeyListener(new KeyInput(objectHandler));
        this.addMouseListener(mouseInput);
        this.addMouseMotionListener(mouseInput);
        this.addMouseListener(menu);
        new Window (WIDTH, HEIGHT,"My first game", this);
        
        
        //add the player
        objectHandler.addObject(new Player(1000,1000, objectHandler,mouseInput,healthBar));
        // add the objects
        objectHandler.addObject(new EnemyType1(20,20,objectHandler));
        
        
        
        //test code
        System.out.println(objectHandler.objects);
        
    }
    
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running= true;
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
        //this.requestFocus();
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
                
                tick();
                delta--;
            }
            if (running) {
                this.render();
            }
            frames++;
            //System.out.println("Hello World!");
            if (System.currentTimeMillis()-timer>1000) {
                timer+=1000;
               // System.out.println("FPS:"+ frames);
                frames=0;
                
            }
            
        }
        
        stop();
        
    }
    
    public void tick() {
        if (gameState==STATE.Game) {
        objectHandler.tick();
        healthBar.tick();
        enemyGenerator.tick();
        } else if (gameState==STATE.Menu) {
            menu.tick();
        }
        else if (gameState==STATE.Tutorial) {
            tutorial.tick();
        }
    }
    
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs==null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //graphics drawing starts here
        paintComponent(g);
        if (gameState == STATE.Game) {
        objectHandler.render(g);
        healthBar.render(g);
        } else if (gameState == STATE.Menu) {
            menu.render(g);
        } 
        //graphics drawing ends here 
        else if (gameState == STATE.Tutorial) {
            tutorial.render(g);
        }
        g.dispose();
        bs.show();
    }
    
    private void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);
    }
    //object cannot go outside of the boundary 
    public static int clamp (int var, int min, int max) {
        if (var>=max) return var=max;
        else if (var<=min) return var =min;
        else return var;
    }
    
    public static void main (String[] args) throws IOException {
        new Game();
    }
    
    
}
