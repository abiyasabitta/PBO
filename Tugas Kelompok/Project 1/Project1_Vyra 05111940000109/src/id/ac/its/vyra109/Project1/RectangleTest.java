package id.ac.its.vyra109.Project1;

import  javax.swing.JOptionPane;

public class RectangleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String Length = JOptionPane.showInputDialog("Enter Length");
		String Width = JOptionPane.showInputDialog("Enter Width");
		
		double length = Double.parseDouble(Length);
		double width =  Double.parseDouble(Width);
		
		Rectangle recs = new Rectangle(length, width);
		
		JOptionPane.showMessageDialog(null, "The area is " + recs.getArea() + "\nThe circumference is " 
				+ recs.getCircumference(), 
				"Area and Circumference of The Rectangle", JOptionPane.PLAIN_MESSAGE);
	}

}
