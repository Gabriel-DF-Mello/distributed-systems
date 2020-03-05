
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usrlab06
 */
public class ScoreController {
    JLabel label_p1_score;
    JLabel label_p2_score;
    JLabel instructions;
    int p1_score = 0;
    int p2_score = 0;
    boolean game_ended = false;

    public ScoreController(JLabel label_p1_score, JLabel label_p2_score, JLabel instructions) {
        this.label_p1_score = label_p1_score;
        this.label_p2_score = label_p2_score;
        this.instructions = instructions;
    }
    
    public void increaseScore(int n){
        if(n == 1){
            p1_score += 1;
            
            if(p1_score == 6){
                label_p1_score.setText("W");
                instructions.setText("JOGADOR LARANJA GANHOU!!!");
                game_ended = true;
            }else{
                label_p1_score.setText("" + p1_score);
                instructions.setText("Jogador Laranja marcou um ponto");
            }
        }else{
            p2_score += 1;
            if(p2_score == 6){
                label_p2_score.setText("W");
                instructions.setText("JOGADOR AZUL GANHOU!!!");
                game_ended = true;
            }else{
                label_p1_score.setText("" + p2_score);
                instructions.setText("Jogador Azul marcou um ponto");
            }
        }
    }
    
    public void resetScore(){
        p1_score = 0;
        p2_score = 0;
        
        label_p1_score.setText("" + p1_score);
        label_p2_score.setText("" + p2_score);
        
        instructions.setText("O jogo começou");
    }
}
