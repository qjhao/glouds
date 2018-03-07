package sin.tetris.bean;

import sin.tetris.config.Config;

public abstract class TetrisBox extends Box {

	protected Box[] boxs = new Box[4];
	
	public TetrisBox(int x, int y, int width, int height) {
		super(x, y, width, height, null);
	}

	@Override
	public void move(Direct direct) {
		if (canMove(direct))
			for(Box box : boxs) {
				box.move(direct);
			}
	}
	
	public boolean canMove(Direct direct) {
		switch (direct) {
		case LEFT:
			if(this.x >= Config.UNIT_WIDTH)
				return true;
			break;
		case RIGHT:
			if(this.x <= Config.WIDTH - Config.UNIT_WIDTH)
				return true;
			break;
		case DOWN:
			if(this.y <= Config.UNIT_HEIGHT - Config.HEIGHT)
				return true;
		}
		return false;
	}

}
