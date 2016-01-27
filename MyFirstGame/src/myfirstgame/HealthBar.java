/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author huyviet
 */
public class HealthBar {
    public static int HEALTH = 200;
    private int greenValue = 255;
    private int score;
    private int life;
    private int level;
    
    public HealthBar(int score, int life, int level) {
        this.score = score;
        this.life = life;
        this.level = level;
    }
    
    public void tick() {
        
    }
    
    
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Liberation Mono",1,20));
        g.drawString("Life: " + life,10,30);
        
        g.drawString("Score: " + score, 10,50);
        /*
        g.setColor(Color.gray);
        g.fillRect(15,15,200,32);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(15,15, HEALTH*2,32);
        g.setColor(Color.white);
        g.drawRect(15,15, 200,32);
        g.drawString("Score:"+score,10,64);
        g.drawString("Level:"+level,10,84);*/
        
        
    }
    
    public void score(int score) {
        this.score = score;
    }
    public int getScore(){
        return score;
    }
    public int getLife() {
        return this.life;
    }
    
    public void setLife(int life) {
        this.life = life;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    
}
