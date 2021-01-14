package ac.id.its.FinalProject.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;
    static final int UNIT_SIZE = 50;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static final int DELAY = 175;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    static boolean gameOn = false;
    int speed=1;

    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame(){
	 chooseDifficulty();
	    
        newApple1();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public void pause() {
        GamePanel.gameOn = true;
        timer.stop();
    }

    public void resume() {
        GamePanel.gameOn = false;
        timer.start();
    }
    
    private void chooseDifficulty() {
		// Opsi difficulty
		String[] options1 = {"Easy", "Medium", "Hard"} ;
		
		// JOptionPane untuk memilih level
		int input2 = JOptionPane.showOptionDialog(null, 
				"Choose Difficulty", 
				"'Snake' Game", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]) ;
		
		// Seleksi pilihan level
		if (input2 == 0) {
			this.speed = 1;
		}
		else if (input2 == 1) {
			this.speed = 2;
		}
		else if (input2 == 2) {
			this.speed = 3;
        }
		else // Jika tidak ada input exit saja
			System.exit(0) ;
	}

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        draw(graphics);
    }

    public void draw(Graphics graphics) {
        if (running) {
            graphics.setColor(Color.RED);
            graphics.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    graphics.setColor(Color.green);
                    graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    graphics.setColor(new Color(45, 180, 0));
                    graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(graphics.getFont());
            graphics.drawString("Score :" + applesEaten,
                    (SCREEN_HEIGHT - metrics.stringWidth("Score :" + applesEaten)) / 2,
                    graphics.getFont().getSize());
            }
        else{
		getHighScore(applesEaten);
		gameOver(graphics);
        }
    }

    public void newApple1(){
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void newApple2(){
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void move() {
	for(int n = 0; n < speed; n++){
		for (int i = bodyParts; i > 0; i--) {
            	x[i] = x[i - 1];
            	y[i] = y[i - 1];
        	}
		
		switch (direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
                	break;
            	case 'R':
                	x[0] = x[0] + UNIT_SIZE;
                	break;
            	case 'L':
                	x[0] = x[0] - UNIT_SIZE;
                	break;
        	}
	}
    }

        public void checkApple(){
            for(int n = 0; n < speed; n++) {
        	if((x[n] == appleX) && (y[n] == appleY)){
			bodyParts++;
			applesEaten++;
                    	newApple1();
                    	newApple2();
		}
	    }
        }

        public void checkCollision(){
            //kepala nyentuh badan
            for(int i = bodyParts; i>0; i--){
                if((x[0] == x[i]) && (y[0] == y[i])){
                    running = false;
                }
            }

            //kepala nyentuh kiri
            if(x[0] < 0){
                running = false;
            }

            //kepala nyentuh kanan
            if(x[0] > SCREEN_WIDTH){
                running = false;
            }

            //kepala nyentuh atas
            if(y[0] < 0){
                running = false;
            }

            //kepala nyentuh bawah
            if(y[0] > SCREEN_HEIGHT){
                running = false;
            }

            if(!running){
                timer.stop();
            }
        }
	
	public void getHighScore(int score) {
    		if(score > highScore) {
    			highScore = score;
    		}
    	}

        public void gameOver(Graphics graphics){
	    //Score
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Ink Free",Font.BOLD, 40));
            FontMetrics metrics1 = getFontMetrics(graphics.getFont());
            graphics.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2 - 150, graphics.getFont().getSize());
            graphics.drawString("Highscore: "+highScore, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+highScore))/2 + 100, graphics.getFont().getSize());
            //Game Over text
            graphics.setColor(Color.red);
            graphics.setFont( new Font("Ink Free",Font.BOLD, 75));
            FontMetrics metrics2 = getFontMetrics(graphics.getFont());
            graphics.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
        }

        @Override
    public void actionPerformed(ActionEvent e){
        if(running){
            move();
            checkApple();
            checkCollision();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if(GamePanel.gameOn) {
                        resume();
                    } else {
                        pause();
                    }
                    break;
            }
        }
    }
}
