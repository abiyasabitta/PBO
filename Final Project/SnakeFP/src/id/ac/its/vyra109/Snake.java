package id.ac.its.vyra109;


public class Snake extends Character {
	
	//Constructor
    public Snake(int dots) {
        super(dots);

        initSnake();
    }
    
    //Initializing the image
    private void initSnake() {

        loadImages("snakeface.png", "snakebody.png", "apple.png");
    }
    
    

}
