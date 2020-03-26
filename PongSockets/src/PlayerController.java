
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
    int type;
    int speed = 2;
    int delay = 4;
    boolean moveUp = false, moveDown = false;
    ObjectOutputStream writer;
    
    PlayerController(JButton player, JPanel board, int type){
        this.player = player;
        this.board = board;
        this.type = type;
    }
    
    @Override
    public void run() 
    {
        try
        {
            while(true) 
            {
                if(moveUp){
                    moveUp(speed);
                }

                else if(moveDown){
                    moveDown(speed);
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
    
    public void moveUp(int n){
        synchronized(writer){
            if(player.getY() + n > 6){
                player.setLocation(player.getX(), player.getY() - n);
                if(writer != null){
                    try{
                        writer.writeObject(new Info(player.getX(), player.getY(), type));
                    }catch(Exception e){

                    }
                }
            }  
        }
    }
    
    public void moveDown(int n){
        synchronized(writer){
            if(player.getY() + player.getHeight() + n < board.getHeight()){
                player.setLocation(player.getX(), player.getY() + n);
                if(writer != null){
                    try{
                        writer.writeObject(new Info(player.getX(), player.getY(), type));
                    }catch(Exception e){

                    }
                }
            }
        }
    }

    public ObjectOutputStream getWriter() {
        return writer;
    }

    public void setWriter(ObjectOutputStream writer) {
        this.writer = writer;
    }
}
