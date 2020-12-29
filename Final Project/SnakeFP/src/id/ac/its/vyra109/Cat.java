package id.ac.its.vyra109;


public class Cat extends Character {
	
	//Constructor
    public Cat(int dots) {
        super(dots);

        initCat();
    }
    
    //Initializing the image
    private void initCat() {

        loadImages("catface.png", "catbody.png", "fish.png");
    }
    
    

}
