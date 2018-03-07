package sin.tetris.bean;

import java.awt.Image;

import sin.tetris.config.Config;

public abstract class Box {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	private Image image;

	public Box(int x, int y, int width, int height, Image image) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static enum Direct {
		LEFT, RIGHT, DOWN
	}
	
	public abstract void rotate();

	public void move(Direct direct) {
		switch (direct) {
		case LEFT:
			this.x -= Config.UNIT_WIDTH;
			break;
		case RIGHT:
			this.x += Config.UNIT_WIDTH;
			break;
		case DOWN:
			this.y += Config.UNIT_HEIGHT;
		}
	}
}
