import jixel.entity.JixelCollidable;
import jixel.entity.JixelEntity;
import jixel.stage.JixelGame;

public class Girl extends JixelEntity implements JixelCollidable {

	public Girl(String imgPath, String animPath, String name, int width, int height, int x, int y, double speed) {
		super(imgPath, animPath, name, width, height, x, y, speed);

	}

	private int tailLength = 1;
	private boolean positive = true;
	private boolean yChange = false;
	private boolean oldChange=false;
	private int countDelay = 0;

	@Override
	public void update() {

		if (JixelGame.getKeyInput().isDown("Up")) {
			if (!oldChange) {
				positive = false;
				yChange = true;
			}
		} else if (JixelGame.getKeyInput().isDown("Down")) {
			if (!oldChange) {
				positive = true;
				yChange = true;
			}
		} else if (JixelGame.getKeyInput().isDown("Left")) {
			if (oldChange) {
				positive = false;
				yChange = false;
			}
		} else if (JixelGame.getKeyInput().isDown("Right")) {
			if (oldChange) {
				positive = true;
				yChange = false;
			}
		}
		countDelay++;

		if (countDelay % 10 == 0) {
			countDelay = 0;
			oldChange = yChange;
			int difference = (int) (positive ? getSpeed() : -1 * getSpeed());
			JixelEntity heart = new Heart("res/heart.png", null, "Heart", 16, 16, (int) getX(), (int) getY(), 0, tailLength);
			Launcher.gameScreen.getEntityManager().add(heart);
			if (yChange) {
				setY(getY() + difference);
			} else {
				setX(getX() + difference);
			}
		}
	}

	@Override
	public void setX(double x) {
		if (x >= 0 && x < JixelGame.getScreen().getWidth()) {
			super.setX(x);
		} else {
			JixelGame.closeGame();
		}
	}

	@Override
	public void setY(double y) {
		if (y >= 0 && y < JixelGame.getScreen().getHeight()) {
			super.setY(y);
		} else {
			JixelGame.closeGame();
		}
	}

	@Override
	public void isColliding(JixelEntity e) {

	}

	@Override
	public void onHit(JixelEntity e) {
		if (e instanceof Heart) {
			JixelGame.closeGame();
		} else if (e instanceof Card) {
			tailLength++;
		}
	}

	@Override
	public void onSeparation(JixelEntity e) {

	}

}
