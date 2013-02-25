import java.awt.Color;
import java.awt.event.KeyEvent;

import jixel.entity.JixelEntity;
import jixel.gui.JixelCamera;
import jixel.stage.JixelGame;

public class Launcher extends JixelGame {
	public static final int WIDTH = 320, HEIGHT = 240, TILESIZE = 16;
	public static final int TILEX = (WIDTH) / TILESIZE, TILEY = (HEIGHT) / TILESIZE;

	public Launcher(String title, int width, int height, int tileSizeLog2, int fps) {
		super(title, width, height, tileSizeLog2, fps);
	}

	public static void main(String[] args) {
		new Launcher("Snake Girls", WIDTH, HEIGHT, 4, 40);
	}

	@Override
	public void update() {
	}

	private JixelEntity girl;
	private JixelEntity card;
	public static JixelCamera gameScreen;

	@Override
	public void onLoad() {
		getKeyInput().addKey("Up", KeyEvent.VK_UP);
		getKeyInput().addKey("Down", KeyEvent.VK_DOWN);
		getKeyInput().addKey("Left", KeyEvent.VK_LEFT);
		getKeyInput().addKey("Right", KeyEvent.VK_RIGHT);
		getScreen().setBackground(new Color(255, 150, 150));
		girl = new Girl("res/girl.png", null, "Girl", TILESIZE, TILESIZE, 8 * TILESIZE, 8 * TILESIZE, TILESIZE);
		card = new Card("res/card.png", null, "Card", TILESIZE, TILESIZE, (int) randX(), (int) randY(), 0);

		gameScreen = new GameScreen(0, 0, WIDTH, HEIGHT);
		gameScreen.getEntityManager().add(girl);
		gameScreen.getEntityManager().add(card);
		getScreen().addCamera(gameScreen);
	}

	public static double randX() {
		return ((int) (Math.random() * Launcher.TILEX)) * Launcher.TILESIZE;
	}

	public static double randY() {
		return ((int) (Math.random() * Launcher.TILEY)) * Launcher.TILESIZE;
	}

	@Override
	public void closeOperation() {
	}

}
