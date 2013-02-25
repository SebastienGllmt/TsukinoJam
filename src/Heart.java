import jixel.entity.JixelEntity;


public class Heart extends JixelEntity{

	private int time;
	public Heart(String imgPath, String animPath, String name, int width, int height, int x, int y, double speed, int time) {
		super(imgPath, animPath, name, width, height, x, y, speed);
		this.time = time;
	}
	
	private int countDelay=0;

	@Override
	public void update() {
		countDelay++;

		if (countDelay % 10 == 0) {
			countDelay = 0;
			time--;
			if(time == 0){
				Launcher.gameScreen.getEntityManager().remove(this);
			}
		}
	}

}
