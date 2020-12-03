package ac.id.its.abiya166.Project1;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	    LabelFrame label = new LabelFrame();
	    JFrame app = new JFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(label);
	    app.setSize(350,  250);
	    app.setVisible(true);
    }
}
