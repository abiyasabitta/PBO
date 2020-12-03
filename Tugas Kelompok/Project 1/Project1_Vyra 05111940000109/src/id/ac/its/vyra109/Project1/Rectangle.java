package id.ac.its.vyra109.Project1;

public class Rectangle {
	
	double a;
	double b;

	public Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public double getArea() {
		return a * b;
	}
	
	public double getCircumference() {
		return 2 * (a + b);
	}
	
//	@Override
//	public String toString() {
//		return String.format("%s = %f %n%s = %f %n%s = %f %n%s = %f %n%s = %f %n%s = %f%n", 
//				"sisi a", a, "sisi b", b, "sisi c", c, "sisi d", d, "Luas Rectangle", getArea(), 
//				"Keliling Rectangle", getCircumference());
//	}
	
}
