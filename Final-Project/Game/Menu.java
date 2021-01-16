

import java.awt.*;

public class Menu extends GamePanel {
    private static final long serialVersion =1L;
    GamePanel gp =new GamePanel();
    private int WIDTH;
    private int HEIGHT;

    public Menu(int LEBAR, int PANJANG){
        super();
        this.setWIDTH(LEBAR);
        this.setHEIGHT(PANJANG);
    }

    public void menugame(Graphics g){
        if(!gp.running) {
            g.setColor(Color.RED);
            g.setFont(new Font("Courier", Font.BOLD, 50));
            FontMetrics metric =getFontMetrics(g.getFont());
            g.drawString("HUNGRY CREATURES", (getWIDTH()-metric.stringWidth("HUNGRY CREATURES"))/2, getHEIGHT()/2);

            g.setFont(new Font("Courier", Font.PLAIN, 30));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Press Enter To Play", (getWIDTH()-metrics.stringWidth("Press Enter To Play"))/2, getHEIGHT()/2 - 200);
        }
    }

    public void gameOver(Graphics graphics, int apple){
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Courier",Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(graphics.getFont());
        graphics.drawString("Score: "+apple, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+apple))/2, graphics.getFont().getSize());
        //Game Over text
        graphics.setColor(Color.red);
        graphics.setFont( new Font("Courier",Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(graphics.getFont());
        graphics.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
        //Play Again text
        graphics.setFont( new Font("Courier",Font.ITALIC, 40));
        FontMetrics metrics3 = getFontMetrics(graphics.getFont());
        graphics.drawString("Press Space to return to menu", (SCREEN_WIDTH - metrics3.stringWidth("Press Space to return to menu"))/2, (SCREEN_HEIGHT - 250)/2);
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
