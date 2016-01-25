/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/**
 *
 * @author huyviet
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;
public class Game extends Canvas implements Runnable{
    
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH*9/12;
    private Thread thread;
    private boolean running=false;
    private Handler handler;
    private Random r;
    private HeadUpDisplay hud;
    private Spawn spawner;
    private Menu menu;
    /**
     *
     */
    
    
    public enum STATE {
        Game,
        Menu;
    }
    
    public STATE gameState = STATE.Game;
    
    public Game() {
        //menu = new Menu(this);
        hud = new HeadUpDisplay();
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH,HEIGHT,"new game",this);
        r = new Random();
        this.spawner = new Spawn(handler,hud);
        if (STATE.Game==gameState) {
       // handler.addObject(new EnemyBoss(WIDTH/2,0,ID.EnemyBoss, handler));
        handler.addObject(new Player(WIDTH/2, HEIGHT/2, ID.Player,handler));
        //Create a bunch of enemies in here
       
        handler.addObject(new BasicEnemy(r.nextInt(WIDTH/2), r.nextInt(HEIGHT), ID.BasicEnemy,handler));
        }
        
     //  System.out.println(handler.object.size());
      
       
        
        
    }
    
   
    
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running=true;
        
    }
    
    public synchronized void stop() {
       try{
           thread.join();
           running=false;
       }catch(Exception e ) {
           e.printStackTrace();
           
       }
    }
    
    
    public void run() {
        this.requestFocus();
        long lastTime =System.nanoTime();
        double amountOfTicks =60.0;
        double ns =1000000000/amountOfTicks;
        double delta =0 ;
        int frames =0;
        long timer = System.currentTimeMillis();
        
        while (running) {
            long now =System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime = now;
            while (delta>=1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer >1000 ) {
                timer+=1000;
                System.out.println("FPS: "+frames);
                frames = 0;
            }
        }
        
        stop();
    }
    
    
    private void tick() {
        handler.tick();
        if (gameState == STATE.Game) {
            
            hud.tick();
            spawner.tick();  
         //   System.out.println(ID.Player);
        } else {
            menu.tick();
        }
    }
    
    
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null ) {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        // graphic rendering begins 
            this.painComponent(g);
            handler.render(g);
            if (gameState == STATE.Game) {
            hud.render(g);
            }
            else {
                menu.render(g);
                
                
                
            }
        // graphic rendering ends
       
        g.dispose();
        bs.show();
    }     
    public void painComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);
    }
    
    public static int clamp (int var, int min, int max) {
        if (var>=max) return var=max;
        else if (var<=min) return var =min;
        else return var;
    }
    
    public static void main(String[] args) {
        new Game();
    }
}
