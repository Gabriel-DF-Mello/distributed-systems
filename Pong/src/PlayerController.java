
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class PlayerController implements Runnable {
    
    JButton player;
    JPanel board;
    int n;
    GeneralController ctrl;
    
    PlayerController(JButton player, JPanel board, int n){
        this.player = player;
        this.board = board;
        this.n = n;
        ctrl = new GeneralController(player, board);
    }
    
    @Override
    public void run() {
        if(n == 1){
            board.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == KeyEvent.VK_UP){
                        ctrl.moveUp(4);
                    }
                    
                    if (evt.getKeyCode() == KeyEvent.VK_DOWN){
                        ctrl.moveDown(4);
                    }
                }
            });
            
            board.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == KeyEvent.VK_UP){
                        ctrl.moveUp(4);
                    }
                    
                    if (evt.getKeyCode() == KeyEvent.VK_DOWN){
                        ctrl.moveDown(4);
                    }
                }
            });
        }
        
        else if(n == 2){
            board.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == KeyEvent.VK_W){
                        ctrl.moveUp(4);
                    }
                    
                    if (evt.getKeyCode() == KeyEvent.VK_S){
                        ctrl.moveDown(4);
                    }
                }
            });
            
            board.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == KeyEvent.VK_W){
                        ctrl.moveUp(4);
                    }
                    
                    if (evt.getKeyCode() == KeyEvent.VK_S){
                        ctrl.moveDown(4);
                    }
                }
            });
        }
    }
}
