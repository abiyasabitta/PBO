package ac.id.its.abiya166.Project1;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	String Height = JOptionPane.showInputDialog("Enter the height of the triangle :");
	String Base = JOptionPane.showInputDialog("Enter the base of the triangle :");
	String Hypotenuse = JOptionPane.showInputDialog("Enter the hypotenuse of the triangle :");

	int height = Integer.parseInt(Height);
	int base = Integer.parseInt(Base);
	int hypotenuse = Integer.parseInt(Hypotenuse);

	Triangle t1 = new Triangle(height, base, hypotenuse);

	JOptionPane.showMessageDialog(null, "The Area of the triangle is " + t1.Area() + "\nThe Circumference of the triangle is " + t1.Circumference(), "Triangle", JOptionPane.PLAIN_MESSAGE);
    }
}
