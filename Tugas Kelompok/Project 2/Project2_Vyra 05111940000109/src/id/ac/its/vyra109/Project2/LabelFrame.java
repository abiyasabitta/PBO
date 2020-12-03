package id.ac.its.vyra109.Project2;

import java.awt.FlowLayout; // specifies how components are arranged
import javax.swing.JFrame; // provides basic window features
import javax.swing.JLabel; // displays text and images
import javax.swing.SwingConstants; // common constants used with Swing
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon; // loads images

public class LabelFrame extends JFrame{
	
	private final JLabel label1;
	private final JLabel label2;
	
	public LabelFrame() {
		super("Testing JLabel");
		setLayout(new FlowLayout());
		
		label1 = new JLabel("05111940000109");
		label1.setToolTipText("nrp");
		add(label1);
		
		Icon pic = new ImageIcon(getClass().getResource("./sponge.jpg"));

		label2 = new JLabel();
		label2.setText("Vyra Fania Adelina");
		label2.setIcon(pic);
		label2.setHorizontalTextPosition(SwingConstants.CENTER);
		label2.setVerticalTextPosition(SwingConstants.BOTTOM);
		label2.setToolTipText("nama dan foto");
		add(label2);	
		
	}

}
