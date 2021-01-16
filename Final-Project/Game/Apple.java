import java.awt.Color;

public class Apple extends Character {
	
	private boolean visible;
	
	public Apple() {
		super(new Color(51, 153, 255), new Color(51, 153, 255));
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
