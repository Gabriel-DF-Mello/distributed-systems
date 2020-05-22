
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author gabri
 */
public class Fruit implements Runnable {
    public Info info;
    private JButton sprite;
    public static boolean colided;
    Thread t;
    private final int delay = 3;
    
    @Override
    public void run() {
        while(true){
            try{
                System.out.println("Fruit - " + this.info.shape);
                for (Bird b: Game.players){
                    if(b.info.shape.intersects(this.info.shape)){
                        b.info.score += 1;
                        generatePosition(sprite);
                        flagScore();
                    }
                }
                Thread.sleep(delay);
            }catch(Exception e){
                
            }
        }
    }

    public Fruit() {
        this.generateSprite();
        this.info = new Info("Fruit", this.getSprite(), -1, -1);
        generatePosition(sprite);
        this.start();
    }
    
    public void start(){
        this.t = new Thread(this);
        t.start();
    }
    
    public void generateSprite()
    {
        sprite = new JButton();
        Game.panelBoard.add(sprite);
        sprite.setVisible(true);
        sprite.setSize(45, 45);
        sprite.setBackground(new Color(255,102,51));
        sprite.setForeground(new Color(51,51,51));
        sprite.setText("@:");
        sprite.setFont(new Font("Tahoma", Font.BOLD, 13));
    }
    
    public static void flagScore(){
        System.out.println("\n\n\n\n\n\n\n\n\nhey\n\n\n\n\n\n\n\n\n");
        Game.score_changed = true;
    }
    
    public void generatePosition(JButton sprite){
        boolean positioned = false;
        boolean colided = false;
        int x = 0, y = 0;
        while (!positioned){
            colided = false;
            Random rand = new Random();
            x = rand.nextInt(Game.panelBoard.getWidth());
            y = rand.nextInt(Game.panelBoard.getHeight());
            Rectangle r = new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
            for (Bird b: Game.players){
                if(b.info.shape.intersects(r)){
                    colided = true;
                    break;
                }
            }
            if(!colided){
                positioned = true;
            }
        }
        sprite.setLocation(x, y);
        updateInfo();
    }
    
    public void updateInfo(){
        this.setInfo(new Info(this.info.name, this.getSprite(), this.info.order, this.info.score));
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
    
}
