
import javax.swing.JButton;
import javax.swing.JLabel;
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
public class BallController implements Runnable {
    JPanel board;
    JButton ball;
    JButton p1;
    JButton p2;
    int points_p1 = 0;
    int points_p2 = 0;
    JLabel score_p1;
    JLabel score_p2;
    int collision_counter;
    int delay = 20 ;
    int l_speed = 3;
    int v_speed = 2;
    boolean moveUp = true, moveDown = false, moveRight = false, moveLeft = true;

    public BallController(JPanel board, JButton ball, JButton p1, JButton p2, JLabel p1_score, JLabel p2_score) {
        this.board = board;
        this.ball = ball;
        this.p1 = p1;
        this.p2 = p2;
    }

    
    @Override
    public void run() {
        while(true){
            try
            {
                while(true) 
                {
                    if((moveUp)){
                        moveUp(v_speed);
                    }

                    else if(moveDown){
                        moveDown(v_speed);
                    }
                    
                    if(moveRight){
                        moveRight(l_speed);
                    }
                    
                    else if (moveLeft){
                        moveLeft(l_speed);
                    }
                Thread.sleep(delay);
                }
            }catch(InterruptedException ex){

            }
        }
    }
    
    public void moveUp(int n){
        if(ball.getY() + n > 4){
            ball.setLocation(ball.getX(), ball.getY() - n);
        }else{
            moveUp = false;
            moveDown = true;
        }  
    }
    
    public void moveDown(int n){
        if(ball.getY() + ball.getHeight() + n < board.getHeight()){
            ball.setLocation(ball.getX(), ball.getY() + n);
        }else{
            moveDown = false;
            moveUp = true;
        }
    }
    
    public void moveRight(int n){
        if((ball.getX() + ball.getWidth() + n < board.getWidth())&&(ball.getX() + ball.getWidth() + n < p2.getX())){
            ball.setLocation(ball.getX() + n, ball.getY());
            
        }else if(ball.getX() + ball.getWidth() + n >= board.getWidth()){
            
        }else{
            moveRight = false;
            moveLeft = true;
            collision_counter += 1;
            if((collision_counter == 1)&&(delay > 3)){
                delay -= 1;
                collision_counter = 0;
            }
        }
    }
    
    public void moveLeft(int n){
        if((ball.getX() - n > 4)|| ((ball.getX() - n > p1.getX() + p1.getWidth()) && ((ball.getY() + ball.getHeight() >= p1.getY()) || (ball.getY() <= p1.getY() + p1.getHeight())) )){
            ball.setLocation(ball.getX() - n, ball.getY());
        }else if(ball.getX() - n <= 4){
            
        }else{
            moveLeft = false;
            moveRight = true;
            collision_counter += 1;
            if((collision_counter == 1)&&(delay > 3)){
                delay -= 1;
                collision_counter = 0;
            }
        }
    }
}
