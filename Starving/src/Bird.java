
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

/**
 *
 * @author gabri
 */
public class Bird implements Runnable {
    
    Thread t;
    
    Info info;
    JButton sprite;
    private int direction = Game.NONE;
    private final int spd = 1;
    private final int delay = 3;

    public Bird(String name, int order) {
        this.generateSprite(order);
        sprite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
               if (evt.getKeyCode() == KeyEvent.VK_W){
                    setDirection(Game.UP);
                 }

                 if (evt.getKeyCode() == KeyEvent.VK_S){
                    setDirection(Game.DOWN);
                 }

                 if (evt.getKeyCode() == KeyEvent.VK_D){
                    setDirection(Game.RIGHT);
                 }

                if (evt.getKeyCode() == KeyEvent.VK_A)
                {
                    setDirection(Game.LEFT);
                }
            }
        });
        this.setInfo(new Info(name, this.getSprite(), order, 0));
        this.start();
    }
    
    @Override
    public void run() 
    {
        try
        {
            while(true) 
            {
                if(direction == Game.UP){
                    move(Game.UP, spd);
                    this.updateInfo();
                }
                else if(direction == Game.RIGHT){
                    move(Game.RIGHT, spd);
                    this.updateInfo();
                }
                else if (direction == Game.DOWN){
                    move(Game.DOWN, spd);
                    this.updateInfo();
                }
                
                else if (direction == Game.LEFT){
                    move(Game.LEFT, spd);
                    this.updateInfo();
                }
                Thread.sleep(delay);
                
            }
        }catch(InterruptedException ex){
            
        }
    }
    
    public void generateSprite(int order)
    {
        sprite = new JButton();
        Game.panelBoard.add(sprite);
        sprite.setVisible(true);
        sprite.setSize(52, 52);
        sprite.setBackground(new Color(102,204,255));
        sprite.setForeground(new Color(51,51,51));
        sprite.setText(">" + String.valueOf(order) + "<");
        sprite.setFont(new Font("Tahoma", Font.BOLD, 10));
        sprite.requestFocus();
        sprite.setLocation(Game.panelBoard.getX() + 10, Game.panelBoard.getY() + 10);
        
    }
                             
    public void start(){
        t = new Thread(this);
        t.start();
    }
    
    public void updateInfo(){
        this.setInfo(new Info(this.info.name, this.getSprite(), this.info.order, this.info.score));
    }

    private void keyReleased(java.awt.event.KeyEvent evt) {                                       
        if (evt.getKeyCode() == KeyEvent.VK_W){
            this.direction = Game.UP;
         }

         if (evt.getKeyCode() == KeyEvent.VK_S){
            this.direction = Game.DOWN;
         }

         if (evt.getKeyCode() == KeyEvent.VK_D){
            this.direction = Game.RIGHT;
         }

         if (evt.getKeyCode() == KeyEvent.VK_DOWN){
            this.direction = Game.LEFT;
         }
    }     
    
    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public JButton getSprite() {
        return sprite;
    }

    public void setSprite(JButton sprite) {
        this.sprite = sprite;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    
    public void move(int dir, int spd){
        System.out.println(this.info.shape);
        if(dir == Game.UP){
            if(!this.info.shape.intersects(Game.bounds[Game.UP])){
                sprite.setLocation(sprite.getX(), sprite.getY() - spd);
            }
        }
        else if (dir == Game.DOWN){
            if(!this.info.shape.intersects(Game.bounds[Game.DOWN])){
                sprite.setLocation(sprite.getX(), sprite.getY() + spd);
            }
        }
        else if(dir == Game.RIGHT){
            if(!this.info.shape.intersects(Game.bounds[Game.RIGHT])){
                sprite.setLocation(sprite.getX() + spd, sprite.getY());
            }
        }
        else if(dir == Game.LEFT){
            if(!this.info.shape.intersects(Game.bounds[Game.LEFT])){
                sprite.setLocation(sprite.getX() - spd, sprite.getY());
            }
        }
    }
}


