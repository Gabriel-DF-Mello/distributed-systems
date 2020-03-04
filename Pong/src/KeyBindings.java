
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
public class KeyBindings implements Runnable {
    PlayerController p1;
    PlayerController p2;
    JPanel board;

    public KeyBindings(PlayerController p1, PlayerController p2, JPanel board) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
    }

    @Override
    public void run() {
        board.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
               if (evt.getKeyCode() == KeyEvent.VK_UP){
                   p1.setMoveUp(true);
               }
            }
        });
        
        board.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
               if (evt.getKeyCode() == KeyEvent.VK_UP){
                   p1.setMoveUp(false);
               }
            }
        });
        
        board.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
               if (evt.getKeyCode() == KeyEvent.VK_DOWN){
                   p1.setMoveDown(true);
               }
            }
        });
        
        board.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
               if (evt.getKeyCode() == KeyEvent.VK_DOWN){
                   p1.setMoveDown(false);
               }
            }
        });
        
        board.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
               if (evt.getKeyCode() == KeyEvent.VK_W){
                   p2.setMoveUp(true);
               }
            }
        });
        
        board.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
               if (evt.getKeyCode() == KeyEvent.VK_W){
                   p2.setMoveUp(false);
               }
            }
        });
        
        board.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
               if (evt.getKeyCode() == KeyEvent.VK_S){
                   p2.setMoveDown(true);
               }
            }
        });
        
        board.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
               if (evt.getKeyCode() == KeyEvent.VK_S){
                   p2.setMoveDown(false);
               }
            }
        });
    }

    public PlayerController getP1() {
        return p1;
    }

    public void setP1(PlayerController p1) {
        this.p1 = p1;
    }

    public PlayerController getP2() {
        return p2;
    }

    public void setP2(PlayerController p2) {
        this.p2 = p2;
    }

    public JPanel getBoard() {
        return board;
    }

    public void setBoard(JPanel board) {
        this.board = board;
    }
}
