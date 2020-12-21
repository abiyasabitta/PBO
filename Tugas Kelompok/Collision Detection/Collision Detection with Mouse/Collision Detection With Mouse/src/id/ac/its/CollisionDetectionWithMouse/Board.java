package id.ac.its.CollisionDetectionWithMouse;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private SpaceShip spaceship;
    private List<Alien> aliens;
    private boolean ingame;
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int B_WIDTH = 400;
    private final int B_HEIGHT = 300;
    private final int DELAY = 15;

    private final int[][] pos = {
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
    };
    
    //Constructor
    public Board() {

        initBoard();
    }
    
    //Initializing the window
    private void initBoard() {
    	
    	//Detecting input from keyboard
        addMouseListener(new TAdapter());
        addMouseMotionListener(new MAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;
        
        //Set the window
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        //Create object>>SpaceShip
        spaceship = new SpaceShip(ICRAFT_X, ICRAFT_Y);
        
        //Create object>>Alien
        initAliens();
        
        //Create object timer>> duration
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    //Initializing alien based on the position
    public void initAliens() {
        
        aliens = new ArrayList<>();

        for (int[] p : pos) {
            aliens.add(new Alien(p[0], p[1]));
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Still playing
        if (ingame) {

            drawObjects(g);

        } else {

            drawGameOver(g); //End
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {
    	
    	//Spaceship Available
        if (spaceship.isVisible()) {
            g.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(),
                    this);
        }

        List<Missile> ms = spaceship.getMissiles();
        //Draw missile
        for (Missile missile : ms) {
            if (missile.isVisible()) {
                g.drawImage(missile.getImage(), missile.getX(), 
                        missile.getY(), this);
            }
        }
        
        //Draw alien
        for (Alien alien : aliens) {
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }
        }
        
        //Write after count the alien
        g.setColor(Color.WHITE);
        g.drawString("Aliens left: " + aliens.size(), 5, 15);
    }

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }
    
    //Game Movement
    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        //updateShip();
        updateMissiles();
        updateAliens();

        checkCollisions();

        repaint();
    }
    
    //Check Game status
    private void inGame() {

        if (!ingame) {
            timer.stop();
        }
    }
    
//    //Method for update missile spaceship
//    private void updateShip() {
//
//        if (spaceship.isVisible()) {
//
//            spaceship.move();
//        }
//    }
    
    //Method for update missile position
    private void updateMissiles() {

        List<Missile> ms = spaceship.getMissiles();

        for (int i = 0; i < ms.size(); i++) {

            Missile m = ms.get(i);

            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }
    
    //Method for update alien position
    private void updateAliens() {

        if (aliens.isEmpty()) {

            ingame = false;
            return;
        }

        for (int i = 0; i < aliens.size(); i++) {

            Alien a = aliens.get(i);
            
            if (a.isVisible()) {
                a.move();
            } else {
                aliens.remove(i);
            }
        }
    }
    
    //Method to check collisions
    public void checkCollisions() {
    	
    	//Get the limits of spaceship image
        Rectangle r3 = spaceship.getBounds();

        for (Alien alien : aliens) {
            
        	//Get the limits of alien image
            Rectangle r2 = alien.getBounds();
            
            //Game status>>end if collision detected
            if (r3.intersects(r2)) {
                
                spaceship.setVisible(false);
                alien.setVisible(false);
                ingame = false;
            }
        }

        List<Missile> ms = spaceship.getMissiles();

        for (Missile m : ms) {

            Rectangle r1 = m.getBounds();

            for (Alien alien : aliens) {

                Rectangle r2 = alien.getBounds();
                
                //Collision between alien & missile
                if (r1.intersects(r2)) {
                    
                    m.setVisible(false);
                    alien.setVisible(false);
                }
            }
        }
    }

    private class TAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e){ spaceship.mousePressed(e);}
    }

    private class MAdapter extends MouseAdapter{
        @Override
        public void mouseMoved(MouseEvent e) { spaceship.move(e);}
    }
}