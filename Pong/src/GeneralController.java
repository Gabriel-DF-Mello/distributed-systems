
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usrlab01
 */
public class GeneralController {
    JButton obj;
    JPanel board;
    
    GeneralController(JButton obj, JPanel game){
        this.obj = obj;
        this.board = game;
    }
    
    public void moveUp(int n){
        if(obj.getY() + n > 4){
            obj.setLocation(obj.getX(), obj.getY() - n);
        }
    }
    
    public void moveDown(int n){
        if(obj.getY() + obj.getHeight() + n < board.getHeight()){
            obj.setLocation(obj.getX(), obj.getY() + n);
        }
    }
    
    public void moveRight(int n){
        if(obj.getX() + obj.getWidth() + n < board.getWidth()){
            obj.setLocation(obj.getX() + n, obj.getY());
        }
    }
    
    public void moveLeft(int n){
        if(obj.getX() - n > 4){
            obj.setLocation(obj.getX() - n, obj.getY());
        }
    }
}
