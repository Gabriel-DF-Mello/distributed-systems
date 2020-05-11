
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author gabri
 */
public class Brain {
    private Info info;
    private JButton sprite;

    public Brain(Info info) {
        this.info = info;
        this.generateSprite();
    }
    
    public void generateSprite()
    {
        sprite = new JButton();
        sprite.setSize(45, 45);
        sprite.setBackground(new Color(255,153,153));
        sprite.setForeground(new Color(51,51,51));
        sprite.setText("}'");
        sprite.setFont(new Font("Tahoma", Font.BOLD, 18));
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
