package id.ac.its.CollisionDetectionWithMouse;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;

public class SpaceShip extends Sprite {

	//Data for Spaceship movement & missile quantity
    private int dx;
    private int dy;
    private List<Missile> missiles;

    //Constructor
    public SpaceShip(int x, int y) {
        super(x, y);

        initCraft();
    }

    //Initializing Spaceship image & size
    private void initCraft() {

        missiles = new ArrayList<>();
        super.loadImage("spaceship.png");
        super.getImageDimensions();
    }

    //Method to move the Spaceship
    public void move(MouseEvent event) {

        dx = event.getX();
        dy = event.getY();
        x = dx;
        y = dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public void mousePressed(MouseEvent e) {

        int key = e.getButton();

        if (key == 1) {
            fire();
        }
    }

    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }

//    public void keyReleased(KeyEvent e) {
//
//        int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_LEFT) {
//            dx = 0;
//        }
//
//        if (key == KeyEvent.VK_RIGHT) {
//            dx = 0;
//        }
//
//        if (key == KeyEvent.VK_UP) {
//            dy = 0;
//        }
//
//        if (key == KeyEvent.VK_DOWN) {
//            dy = 0;
//        }
//    }
}