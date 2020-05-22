
import java.awt.GridLayout;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
public class Score implements Runnable {
    public static boolean score_changed = false;
    
    @Override
    public void run() {
        int num_score = 0;
        while (true)
        {
            if(num_score != Game.players.size()){
                num_score = Game.players.size();
                Game.panelScore.removeAll();
                Game.panelScore.revalidate();
                GridLayout g = new GridLayout(num_score, 2);
                Game.panelScore.setLayout(g);
                score_changed = true;
            }

            if(score_changed){
                Game.panelScore.removeAll();
                Game.panelScore.revalidate();
                for(Bird b: Game.players){
                    JLabel name = new JLabel();
                    name.setText(b.info.name);
                    JLabel score = new JLabel();
                    score.setText(String.valueOf(b.info.score));

                    Game.panelScore.add(name);
                    Game.panelScore.add(score);
                }
                score_changed = false;
            }  
        }
    }
}
