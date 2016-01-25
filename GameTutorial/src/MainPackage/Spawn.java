/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import static MainPackage.Game.WIDTH;
import java.util.Random;

/**
 *
 * @author huyviet
 */
public class Spawn {
    private Handler handler;
    private HeadUpDisplay hud;
    private int scoreKeep=0;
    private Random r;
    
    public Spawn(Handler handler, HeadUpDisplay hud) {
        this.handler= handler;
        this.hud = hud;
    }
    
    
    public void tick() {
        scoreKeep++;
        //System.out.println(scoreKeep);
        if (scoreKeep>=100) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel()+1);
            if (hud.getLevel() == 1) {
                handler.addObject(new EnemyBoss(100,100,ID.EnemyBoss, handler));
            }
            
            if (hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(100,100,ID.BasicEnemy,handler));
            }
            if (hud.getLevel() == 3)  {
                handler.addObject(new BasicEnemy(100,100,ID.BasicEnemy,handler));
            }
            if (hud.getLevel() == 4) {
                handler.addObject(new FastEnemy(100,100,ID.FastEnemy,handler));
            }
            if (hud.getLevel() == 5) {
                handler.addObject(new SmartEnemy(100,100,ID.SmartEnemy, handler));
            }
            
            if (hud.getLevel() == 6) {
                //handler.clearEnemy();
                handler.addObject(new EnemyBoss(WIDTH/2,0,ID.EnemyBoss,handler));
            }
            
        }
        
        
            
        }
        
    
}
