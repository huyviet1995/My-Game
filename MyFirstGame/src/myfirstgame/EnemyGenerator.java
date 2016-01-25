/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.util.Random;

/**
 *
 * @author huyviet
 */

public class EnemyGenerator {
    private ObjectHandler objectHandler;
    private HealthBar healthBar;
    private int timer;
    
    
    public EnemyGenerator(ObjectHandler objectHandler,HealthBar healthBar) {
        this.objectHandler = objectHandler;
        this.healthBar = healthBar;
        
    }
    
    public void tick() {
        timer --;
        if (timer<=0) {
            timer =10;
            int random = (int)(Math.random()*960);
            int random2 = (int)(Math.random()*640);
            objectHandler.addObject(new EnemyType1(random,random2,objectHandler));
            System.out.println(random+" "+ random2);
        }
        
    }
    
    public void render() {
        
    }
}
