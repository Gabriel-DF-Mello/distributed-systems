
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
public class Info implements Serializable {
    private int x, y, type, event = -1;
    
    //type 1 = p1, type 2 = p2, type 0 = ball

    public Info(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    
    public Info(int x, int y, int type, int event) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.event = event;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }
    
    
    
    
}
