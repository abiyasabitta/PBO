package id.ac.its.vyra109;


public class Dog extends Character{
	
	//Constructor
    public Dog(int dots) {
        super(dots);

        initDog();
    }
    
    //Initializing the image
    private void initDog() {

        loadImages("dogface.png", "dogbody.png", "bones.png");
    }
    
    
    

}
