package id.ac.its.vyra109;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private int RAND_POS;
    private final int DELAY = 140;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean inGame;

    private Timer timer;
    private int input1;
    
    private int countFood;
    private int food;
    
    Snake snake;
    Dog dog;
    Cat cat;

    public Board() {
        
        initBoard();
    }
    
    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.white);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        
        initGame();
    }
    
    private void chooseCharacter() {
		// Opsi karakter
		String[] options1 = {"Snake", "Dog", "Cat"} ;
		
		// JOptionPane untuk memilih karakter
		int input1 = JOptionPane.showOptionDialog(null, 
				"Choose Character", 
				"'Snake' Game", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]) ;
		
		// Seleksi pilihan karakter
		if (input1 == 0) {
			this.input1 = input1;
			snake = new Snake(dots) ;
		}
		else if (input1 == 1) {
			this.input1 = input1;
			dog = new Dog(dots);
		}
		else if (input1 == 2) {
			this.input1 = input1;
			cat = new Cat(dots) ;
		}
		else // Jika tidak ada input exit saja
			System.exit(0) ;
	}
    
    public void chooseDifficulty() {
		// Opsi tingkat kesulitan
		String[] options2 = {"Easy", "Medium", "Hard"} ;
		
		// JOptionPane untuk memilih kesuiltan
		int input2 = JOptionPane.showOptionDialog(null, 
				"Choose Difficulty", 
				"'Snake' Game", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]) ;
		
		// Seleksi pilihan untuk masing - masing kesulitan dibedakan kecepatan karakter dan jumlah food
		if (input1 == 0) {
			if(input2 == 0) {
				snake.setSpeed(1);
				RAND_POS = 20 ;
			}
			else if(input2 == 1) {
				snake.setSpeed(3);
				RAND_POS = 25 ;
			}
			else if(input2 == 2) {
				snake.setSpeed(5);
				RAND_POS = 30 ;
			}
		}
		else if (input1 == 1) {
			if(input2 == 0) {
				dog.setSpeed(1);
				RAND_POS = 20 ;
			}
			else if(input2 == 1) {
				dog.setSpeed(3);
				RAND_POS = 25 ;
			}
			else if(input2 == 2) {
				dog.setSpeed(5);
				RAND_POS = 30 ;
			}
		}
		else if (input1 == 2) {
			if(input2 == 0) {
				cat.setSpeed(1);
				RAND_POS = 20 ;
			}
			else if(input2 == 1) {
				cat.setSpeed(3);
				RAND_POS = 25 ;
			}
			else if(input2 == 2) {
				cat.setSpeed(5);
				RAND_POS = 30 ;
			}
		}
		else // Jika tidak ada input exit saja
			System.exit(0) ;
//		// Simpan jumlah alien
		this.countFood = RAND_POS;
//		
		// buat lokasi apple secara random
		locateApple();
	}
   

    private void initGame() {
    	
    	inGame = true;

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
        
        chooseCharacter();
        chooseDifficulty();
        
        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        
        if (inGame) {

        	doDrawing(g);

        } else {

            gameOver(g); //End
        }

        Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g) {
 
        	if(input1 == 0) {
        		g.drawImage(snake.getfood(), apple_x, apple_y, this);

                 for (int z = 0; z < dots; z++) {
                     if (z == 0) {
                    	 g.drawImage(snake.gethead(), x[z], y[z], this);
                     } else {
                    	 g.drawImage(snake.getbody(), x[z], y[z], this);
                     }
                 }
    		}
    		else if(input1 == 1) {
    			g.drawImage(dog.getfood(), apple_x, apple_y, this);

                for (int z = 0; z < dots; z++) {
                    if (z == 0) {
                   	 	g.drawImage(dog.gethead(), x[z], y[z], this);
                    } else {
                   	 	g.drawImage(dog.getbody(), x[z], y[z], this);
                    }
                }
    		}
    		else if(input1 == 2) {
    			g.drawImage(cat.getfood(), apple_x, apple_y, this);

                for (int z = 0; z < dots; z++) {
                    if (z == 0) {
                   	 	g.drawImage(cat.gethead(), x[z], y[z], this);
                    } else {
                    	g.drawImage(cat.getbody(), x[z], y[z], this);
                    }
                }
    		}
        	
        	
            g.setColor(Color.WHITE);
            g.drawString("Food left: " + countFood, 5, 15);
    }

    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }
    
    private void checkChar() {
    	if(input1 == 0) {
			snake.move();
		}
		else if(input1 == 1) {
			dog.move();
		}
		else if(input1 == 2) {
			cat.move();
		}
    }

    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
            countFood--;
            locateApple();
        }
    }


    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {

        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkChar();
            checkApple();
            checkCollision();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if(input1 == 0) {
    			//snake
            	snake.keyPressed(e);
    		}
    		else if(input1 == 1) {
    			//dog
    			dog.keyPressed(e);
    		}
    		else if(input1 == 2) {
    			//cat
    			cat.keyPressed(e);
    		}

        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            if(input1 == 0) {
    			//snake
            	snake.keyReleased(e);
    		}
    		else if(input1 == 1) {
    			//dog
    			dog.keyReleased(e);
    		}
    		else if(input1 == 2) {
    			//cat
    			cat.keyReleased(e);
    		}

        }
    }
}
