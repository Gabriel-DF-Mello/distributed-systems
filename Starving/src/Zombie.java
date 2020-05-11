
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author gabri
 */
public class Zombie {
    private Info info;
    private JButton sprite;

    public Zombie(Info info) {
        this.info = info;
        this.generateSprite();
    }
    
    public void generateSprite()
    {
        sprite = new JButton();
        sprite.setSize(52, 52);
        sprite.setBackground(new Color(102,153,0));
        sprite.setForeground(new Color(51,51,51));
        sprite.setText("X_X");
        sprite.setFont(new Font("Tahoma", Font.BOLD, 12));
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
    
    public boolean colided(Info object){
        if(this.info.shape.intersects(object.shape)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean inBounds()
    {
        if(!Game.bounds.contains(this.info.shape)){
            return false;
        }else{
            return true;
        }
    }
}


