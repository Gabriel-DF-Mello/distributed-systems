
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

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
    GeneralController ctrl;
    int delay = 10;
    boolean moveUp = false, moveDown = false;
    
    PlayerController(JButton player, JPanel board){
        this.player = player;
        this.board = board;
        ctrl = new GeneralController(player, board);
    }
    
    @Override
    public void run() 
    {
        try
        {
            while(true) 
            {
                if(moveUp){
                    ctrl.moveUp(3);
                }

                else if(moveDown){
                    ctrl.moveDown(3);
                }
            Thread.sleep(delay);
            }
        }catch(InterruptedException ex){
            
        }
    }

    public boolean willMoveUp() {
        return moveUp;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }

    public boolean willMoveDown() {
        return moveDown;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }
    
    
}
