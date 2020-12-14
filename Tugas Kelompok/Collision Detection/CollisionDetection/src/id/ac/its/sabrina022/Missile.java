package id.ac.its.sabrina022;

public class Missile extends Sprite {
	
	//Data for 
    private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 2;
    
    //Constructor
    public Missile(int x, int y) {
        super(x, y);

        initMissile();
    }
    
    //Initializing the missile image & size
    private void initMissile() {
        
        loadImage("missile.png");
        getImageDimensions();        
    }
    
    //Method to move the missile
    @Override
    public void move() {
        
        x += MISSILE_SPEED;
        
        //Limit for missile movement
        if (x > BOARD_WIDTH)
            visible = false;
    }
}