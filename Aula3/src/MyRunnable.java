
import javax.swing.JTextArea;



public class MyRunnable implements Runnable {
    int x = 0;
    JTextArea a;
    Thread t;
    
    MyRunnable(JTextArea a){
        this.a = a;
        t =  new Thread(this);
   }
    
    
   public void Inicia(){
       t.start();
   } 
   
    @Override
    public void run() {
        //synchronized(this){
        for (int i = 0, ii = 0; i < 20; i++) {
            a.append(" " + i + " ");
            ii++;
            if(ii == 5){
                ii = 0;
                a.append("\n");
            }
        }
        //}
    }
    
}
