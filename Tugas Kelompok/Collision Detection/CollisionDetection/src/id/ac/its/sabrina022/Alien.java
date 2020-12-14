package id.ac.its.sabrina022;

public class Alien extends Sprite {
	
	//Data for the alient speed
    private static int INITIAL_X = 400;
    
    //Constructor
    public Alien(int x, int y) {
        super(x, y);

        initAlien();
    }
    
    //Initializing the alien image & size
    private void initAlien() {

        loadImage("alien.png");
        getImageDimensions();
    }
    
    //Method to move the Alien
    @Override
    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1;
    }
}