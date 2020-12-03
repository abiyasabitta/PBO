package id.ac.its.sabrina022;

import java.awt.FlowLayout; // specifies how components are arranged
import javax.swing.JFrame; // provides basic window features
import javax.swing.JLabel; // displays text and images
import javax.swing.SwingConstants; // common constants used with Swing
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon; // loads images

public class LabelFrame extends JFrame {
	
	private final JLabel label1; // JLabel with just text
	private final JLabel label2; // JLabel constructed with text and icon
	private final JLabel label3; // JLabel with added text and icon
	
	// LabelFrame constructor adds JLabels to JFrame
	public LabelFrame() {
		
		super("Testing JLabel");
		setLayout(new FlowLayout()); // set frame layout
		
		// JLabel constructor with a string argument
		label1 = new JLabel("NRP 05111940000022");
//		label1.setVerticalTextPosition(SwingConstants.TOP);
		label1.setVerticalTextPosition(SwingConstants.CENTER);
		label1.setToolTipText("This is label1");
		add(label1); // add label1 to JFrame
		
		// JLabel constructor with string, Icon and alignment arguments
		Icon TY = new ImageIcon(getClass().getResource( "profile.jpeg"));
		label2 = new JLabel();
		label2.setToolTipText("This is label2");
		add(label2); // add label2 to JFrame
		
		label3 = new JLabel("Afifah Nur Sabrina Syamsudin"); // JLabel constructor no arguments
		label3.setIcon(TY); // add icon to JLabel
//		label3.setVerticalTextPosition(SwingConstants.TOP);
		label3.setVerticalTextPosition(SwingConstants.CENTER);
		label3.setToolTipText("This is label3");
		add(label3); // add label3 to JFrame
	}
}
