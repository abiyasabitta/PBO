package id.ac.its.sabrina022;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class CollisionEx extends JFrame {
	
	//Constructor
    public CollisionEx() {
        
        initUI();
    }
    
    private void initUI() {
    	
        //Create object>> board
        add(new Board());
        
        //Set board size permanently
        setResizable(false);
        pack();
        
        //Set game title
        setTitle("Collision");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            CollisionEx ex = new CollisionEx();
            ex.setVisible(true);
        });
    }
}