
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
        if(obj.getY() > board.getY()){
            obj.setLocation(obj.getX(), obj.getY() - n);
        }
    }
    
    public void moveDown(int n){
        if(obj.getY() < board.getX() + board.getHeight()){
            obj.setLocation(obj.getX(), obj.getY() + n);
        }
    }
    
    public void moveRight(int n){
        if(obj.getY() < board.getY() + board.getWidth()){
            obj.setLocation(obj.getX() + n, obj.getY());
        }
    }
    
    public void moveLeft(int n){
        if(obj.getX() > board.getY()){
            obj.setLocation(obj.getX() - n, obj.getY());
        }
    }
}
