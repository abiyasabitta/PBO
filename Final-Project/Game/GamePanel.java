import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 570;
    static final int SCREEN_HEIGHT = 570;
    static final int FRAME_WIDTH = 630;
    static final int FRAME_HEIGHT = 660;
    static final int UNIT_SIZE = 30;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static final int DELAY = 175;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten = 0; //initialize score
    int appleX;
    int appleY;
	int poisonAppleX;
	int poisonAppleY;
	boolean start = true;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    static boolean gameOn = false;
    private int highScore = 0; //initialize highScore
	
	int Hrange = SCREEN_HEIGHT - 60 + 1;
    int Wrange = SCREEN_WIDTH - 30 + 1;
    
    int right;
    int down;
	int speed = 1;
	int count;
	int input1;
    
    Snake snake;
    Centipede centipede;
    Worm worm;
    Apple poisonApple;
    Apple apple;
    
    //Saving Score Data
    private String saveDataPath;
    private String fileName = "SaveData";
    
    GamePanel(){
        initGamePanel();
    }
    
	public void initGamePanel(){
	try {
    		saveDataPath = GamePanel.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
//    		saveDataPath = System.getProperty("user.home") + "\\foldername";
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
        loadHighScore();
            
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
	}
	
    private void createSaveData(){
    	try {
    		File file = new File(saveDataPath, fileName);
    		
    		FileWriter output = new FileWriter(file);
    		BufferedWriter writer = new BufferedWriter(output);
    		writer.write(""+ 0);
    		
    		writer.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    private void loadHighScore(){
    	try {
    		File f = new File(saveDataPath, fileName);
    		if(!f.isFile()) {
    			createSaveData();
    		}
    		BufferedReader reader = new BufferedReader(new InputStreamReader (new FileInputStream(f)));
    		highScore = Integer.parseInt(reader.readLine());
    		reader.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    private void setHighScore(){
    	FileWriter output = null;
    	
    	try {
    		File f = new File(saveDataPath, fileName);
    		output = new FileWriter(f);
    		BufferedWriter writer = new BufferedWriter(output); 
    		
    		writer.write(""+ highScore);
    		
    		writer.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    private void chooseDifficulty() {
        // Opsi karakter
		String[] options1 = {"Easy", "Medium", "Hard"} ;
		
		// JOptionPane untuk memilih karakter
		int input2 = JOptionPane.showOptionDialog(null, 
				"Choose Difficulty", 
				"'Snake' Game", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]) ;
		
		// Seleksi pilihan karakter
		if (input2 == 0) {
			this.speed = 1;
			right = 540;
			down = 540;
		}
		else if (input2 == 1) {
			this.speed = 2;
			right = 540;
			down = 540;
		}
		else if (input2 == 2) {
			this.speed = 3;
			right = 570;
			down = 540;
        }
		else // Jika tidak ada input exit saja
			System.exit(0);
	}
	
	private void chooseCharacter() {
		// Opsi karakter
		String[] options1 = {"Snake", "Centipede", "Worm"} ;
		
		// JOptionPane untuk memilih karakter
		int input1 = JOptionPane.showOptionDialog(null, 
				"Choose Character", 
				"'Snake' Game", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]) ;
		
		// Seleksi pilihan karakter
		if (input1 == 0) {
			this.input1 = input1;
			snake = new Snake();
		}
		else if (input1 == 1) {
			this.input1 = input1;
			centipede = new Centipede();
		}
		else if (input1 == 2) {
			this.input1 = input1;
			worm = new Worm();
        }
		else // Jika tidak ada input exit saja
			System.exit(0) ;
	}

    public void startGame(){
	    if(start){
		running = false;
	    }
        else{
		x[0] = 30;
    	y[0] = 60;
		
	chooseDifficulty();
		chooseCharacter();
		count = 0;
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
	}
    }
    
    public void pause() {
        GamePanel.gameOn = true;
        timer.stop();
    }

    public void resume() {
        GamePanel.gameOn = false;
        timer.start();
    }
	
	public void reset(){
		start = true;
        applesEaten = 0;
        bodyParts = 6;
        direction = 'R';
        x[0] = 0;
        y[0] = 0;
        timer.restart();
        running = false;
        gameOn = false;
	initGamePanel();
	}		
	
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        draw(graphics);
    }

    public void draw(Graphics graphics) {
	Menu screen = new Menu(SCREEN_WIDTH, SCREEN_HEIGHT);
        if(start){
		screen.menugame(graphics);
	}
	else if (running) {
		//screen
        	graphics.setColor(new Color(102, 102, 102));
        	graphics.fillRect(30, 60, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		//apple
        	drawApple(graphics);

            	//character
            	drawCharacter(graphics);
		
		//score
            	drawScore(graphics);
            }
        else{
            screen.gameOver(graphics, applesEaten);
        }
    }

    public void newApple() {
    	apple = new Apple();
    	appleX = random.nextInt((int)(Wrange/UNIT_SIZE))*UNIT_SIZE + 30;
        appleY = random.nextInt((int)(Hrange/UNIT_SIZE))*UNIT_SIZE + 60;
        
	 //tidak spawn di body
        for(int i = bodyParts; i > 0 ; i--) {
        	if(appleX == x[i]) {
        		appleX = random.nextInt((int)(Wrange/UNIT_SIZE))*UNIT_SIZE + 30;
        	}
        	else if (appleY == y[i]) {
        		appleY = random.nextInt((int)(Hrange/UNIT_SIZE))*UNIT_SIZE + 60;
        	}
        }
        
        //rottenApple
        if(count == 3) {
        	poisonApple = new Apple(new Color(102, 0, 153));
        	poisonApple.setVisible(true);
        	poisonAppleX = random.nextInt((int)(Wrange/UNIT_SIZE))*UNIT_SIZE + 30;
            poisonAppleY = random.nextInt((int)(Hrange/UNIT_SIZE))*UNIT_SIZE + 60;
            
            //tidak spawn di body
            for(int i = bodyParts; i > 0 ; i--) {
            	if(poisonAppleX == x[i]) {
            		poisonAppleX = random.nextInt((int)(Wrange/UNIT_SIZE))*UNIT_SIZE + 30;
            	}
            	else if (poisonAppleY == y[i]) {
            		poisonAppleY = random.nextInt((int)(Hrange/UNIT_SIZE))*UNIT_SIZE + 60;
            	}
            }
            
            //tidak spawn di apple
            if(poisonAppleX == appleX) {
            	poisonAppleX = random.nextInt((int)(Wrange/UNIT_SIZE))*UNIT_SIZE + 30;
            }
            else if(poisonAppleY == appleY) {
            	poisonAppleY = random.nextInt((int)(Wrange/UNIT_SIZE))*UNIT_SIZE + 60;
            }
        }
        
    }

    public void move() {
	for(int n = 0; n < speed; n++) {
    		for (int i = bodyParts; i > 0; i--) {
                	x[i] = x[i - 1];
                	y[i] = y[i - 1];
            }
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

        public void checkApple(){
            for(int n = 0; n < speed; n++) {
        		if((x[n] == appleX) && (y[n] == appleY)){
                	bodyParts++;
                    applesEaten++;
                    count++;
                    newApple();
                }
        		else if((x[n] == poisonAppleX) && (y[n] == poisonAppleY)) {
            		applesEaten -= 2;
            		count = 0;
            		newApple();
        		}
        	}
            
            if(applesEaten >= highScore) {
        	    highScore = applesEaten;
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
            if(x[0] < 30){
                running = false;
            }
            //kepala nyentuh kanan
            if(x[0] > right + 30){
                running = false;
            }
            //kepala nyentuh atas
            if(y[0] < 60){
                running = false;
            }
            //kepala nyentuh bawah
            if(y[0] > down + 60){
                running = false;
            }
            if(!running){
                timer.stop();
            }
        }
    
        public void drawScore (Graphics graphics) {
    	setHighScore();
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("calibri",Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(graphics.getFont());
        graphics.drawString("Score: "+applesEaten, 
        		(SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2 - 200,
        		graphics.getFont().getSize());
        graphics.drawString("HighScore: "+highScore, 
        		(SCREEN_WIDTH - 250),
                graphics.getFont().getSize());
        }
	
	public void drawCharacter(Graphics graphics) {
        	if(input1 == 0) {
            	for (int i = 0; i < bodyParts; i++) {
            		if (i == 0) {
                        graphics.setColor(snake.getColorHead());
                        graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    } else {
                        graphics.setColor(snake.getColorBody());
                        graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
            }
            else if(input1 == 1) {
            	for (int i = 0; i < bodyParts; i++) {
                    if (i == 0) {
                        graphics.setColor(centipede.getColorHead());
                        graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    } else {
                        graphics.setColor(centipede.getColorBody());
                        graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
            }
            else if(input1 == 2) {
            	for (int i = 0; i < bodyParts; i++) {
                    if (i == 0) {
                        graphics.setColor(worm.getColorHead());
                        graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    } else {
                        graphics.setColor(worm.getColorBody());
                        graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
            }
        }
        
        public void drawApple(Graphics graphics) {
        	//apple
            graphics.setColor(apple.getColorHead());
            graphics.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
           
            //poisonApple
            if(count == 3) {
            	graphics.setColor(poisonApple.getColorBody());
            	if(poisonApple.isVisible()) {
                	graphics.fillOval(poisonAppleX, poisonAppleY, UNIT_SIZE, UNIT_SIZE);
                }
            }
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
                    if(running){
		    	if(GamePanel.gameOn) {
                        resume();
                    	} else {
                        pause();
                   	}
		    }
		    else{
		    	reset();
		    }
                    break;
		case KeyEvent.VK_ENTER:
                    if(start){
                        start = false;
                        startGame();
                    }
                    break;
            }
        }
    }
}
