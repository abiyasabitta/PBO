package ac.id.its.abiya166.Project1;

public class Triangle {
    private int height;
    private int base;
    private int hypotenuse;

    public Triangle(int height, int base, int hypotenuse) {
        this.height = height;
        this.base = base;
        this.hypotenuse = hypotenuse;
    }

    public float Area(){
        return height * base / 2;
    }

    public int Circumference(){
        return height + base + hypotenuse;
    }
}
