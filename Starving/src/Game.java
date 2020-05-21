
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Game extends javax.swing.JFrame {
    public static Rectangle bounds[];
    public static ArrayList<Bird> players;
    public static Fruit fruit;
    
    public static final int NONE = -1;
    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    
    public Game() {
        initComponents();
        bounds = new Rectangle[4];
        
        bounds[UP] = new Rectangle(0, 1, panelBoard.getWidth(), 1);
        bounds[RIGHT] = new Rectangle(panelBoard.getWidth() - 1, panelBoard.getY(), 1, panelBoard.getHeight());
        bounds[DOWN] = new Rectangle(0, panelBoard.getHeight() - 1, panelBoard.getWidth(), 1);
        bounds[LEFT] = new Rectangle(0, panelBoard.getY(), 1, panelBoard.getHeight());
        
        Bird b = new Bird(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spriteBird = new javax.swing.JButton();
        spriteFruit = new javax.swing.JButton();
        panelBoard = new javax.swing.JPanel();
        panelScore = new javax.swing.JPanel();

        spriteBird.setBackground(new java.awt.Color(102, 204, 255));
        spriteBird.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spriteBird.setForeground(new java.awt.Color(51, 51, 51));
        spriteBird.setText("* >*");
        spriteBird.setMaximumSize(new java.awt.Dimension(52, 52));
        spriteBird.setMinimumSize(new java.awt.Dimension(52, 52));
        spriteBird.setPreferredSize(new java.awt.Dimension(52, 52));
        spriteBird.getAccessibleContext().setAccessibleName("btnZombie");

        spriteFruit.setBackground(new java.awt.Color(255, 102, 51));
        spriteFruit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        spriteFruit.setForeground(new java.awt.Color(51, 51, 51));
        spriteFruit.setText("@:");
        spriteFruit.setMaximumSize(new java.awt.Dimension(37, 37));
        spriteFruit.setMinimumSize(new java.awt.Dimension(37, 37));
        spriteFruit.setPreferredSize(new java.awt.Dimension(37, 37));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBoard.setBackground(new java.awt.Color(235, 243, 247));
        panelBoard.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelBoard.setMaximumSize(new java.awt.Dimension(1770, 900));
        panelBoard.setMinimumSize(new java.awt.Dimension(1770, 900));

        javax.swing.GroupLayout panelBoardLayout = new javax.swing.GroupLayout(panelBoard);
        panelBoard.setLayout(panelBoardLayout);
        panelBoardLayout.setHorizontalGroup(
            panelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBoardLayout.setVerticalGroup(
            panelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelScore.setBorder(javax.swing.BorderFactory.createTitledBorder("Placar"));

        javax.swing.GroupLayout panelScoreLayout = new javax.swing.GroupLayout(panelScore);
        panelScore.setLayout(panelScoreLayout);
        panelScoreLayout.setHorizontalGroup(
            panelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );
        panelScoreLayout.setVerticalGroup(
            panelScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 1630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel panelBoard;
    public static javax.swing.JPanel panelScore;
    public static javax.swing.JButton spriteBird;
    public static javax.swing.JButton spriteFruit;
    // End of variables declaration//GEN-END:variables
}
