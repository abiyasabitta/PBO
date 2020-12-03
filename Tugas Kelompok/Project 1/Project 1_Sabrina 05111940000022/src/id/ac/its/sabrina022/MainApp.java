package id.ac.its.sabrina022;

import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {
		
		String Radius = JOptionPane.showInputDialog("Enter the radius");
		
		double radius = Double.parseDouble(Radius);
		
		Circle cr1 = new Circle(radius);
		
		JOptionPane.showMessageDialog(null, "The are is " + cr1.getArea() + "\nThe Circumstances is " + cr1.getCircumtances(), 
				"Result of The Circle", JOptionPane.PLAIN_MESSAGE);
		
		
		
	}

}
