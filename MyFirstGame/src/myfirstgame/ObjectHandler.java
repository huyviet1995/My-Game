/*
 * This class handles all functioning object within the program
 */
package myfirstgame;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author huyviet
 */
public class ObjectHandler {
    LinkedList<ObjectController> objects = new LinkedList<ObjectController>();
    
    public void tick() {
        for (int i=0;i<objects.size();i++) {
            objects.get(i).tick();
        }
    }
    public void render(Graphics g) {
        for (int i=0;i<objects.size();i++) {
            objects.get(i).render(g);
        }
    }
    public void addObject(ObjectController object) {
        this.objects.add(object);
    }
    public void removeObject (ObjectController object) {
        this.objects.remove(object);
    }
    
    
}
