import jixel.entity.JixelCollidable;
import jixel.entity.JixelEntity;
import jixel.stage.JixelGame;


public class Card extends JixelEntity implements JixelCollidable{

	public Card(String imgPath, String animPath, String name, int width, int height, int x, int y, double speed) {
		super(imgPath, animPath, name, width, height, x, y, speed);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void isColliding(JixelEntity e) {
		
	}

	@Override
	public void onHit(JixelEntity e) {
		if(e instanceof Girl){
			setX(Launcher.randX());
			double y = getY();
			double newY;
			do{
				newY = Launcher.randY();
			}while(y == newY);
			setY(newY);
		}
	}

	@Override
	public void onSeparation(JixelEntity e) {
		
	}

	@Override
	public int compareTo(JixelEntity e){
		int result = super.compareTo(e);
		if(result == 0 && e instanceof Heart){
			return -1;
		}
		return result;
	}
}
