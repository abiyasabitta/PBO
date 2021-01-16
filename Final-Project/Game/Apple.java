import java.awt.Color;

public class Apple extends Character {
	
	private boolean visible;
	
	public Apple() {
		super(Color.RED, Color.RED);
	}

	public Apple(Color color){
		super(color, color);
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
}
