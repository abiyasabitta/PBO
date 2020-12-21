package id.ac.its.CollisionDetectionWithMouse;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Sprite {
	
	protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    
    //Constructor
    public Sprite(int x, int y) {

        this.x = x;
        this.y = y;
        this.visible = true;
    }
    
    //Get the image dimensions
    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }
    
    //Get the image
    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    //Getter for visibility
    public boolean isVisible() {
        return visible;
    }
    
    //Setter for visibility
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    
    //Shaping the Image as Rectangle
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

}
