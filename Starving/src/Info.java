
import java.awt.Rectangle;
import java.io.Serializable;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
public class Info implements Serializable {
    String name;
    int order;
    Rectangle shape;
    int score;

    public Info(String name, JButton sprite, int order, int score) {
        this.name = name;
        shape = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        this.order = order;
        this.score = score;
    }
    
    
    
}



