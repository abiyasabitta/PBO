package id.ac.its.sabrina022;

public class Circle extends Shape {
	
	// property 
	final double pi = 3.14;
	double radius;
	
	// constructor to set the circle for no input
	public Circle() {
		this.radius = 0.0;
	}
	
	// constructor to equalize property w/ parameter
	public Circle(double radius) {
		this.radius = radius;
	}
	
	// get the radius 
	public double getRadius() {
		return radius;
	}
	
	// set the radius
	public void setRadius(double radius) {
		this.radius = radius;
	}

	// calculate the area
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return pi * radius * radius;
	}
	
	// calculate the circumtances
	@Override
	double getCircumtances() {
		// TODO Auto-generated method stub
		return pi * 2 * radius;
	}
	
			
}
