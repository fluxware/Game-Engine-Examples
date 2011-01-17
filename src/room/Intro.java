package room;

import level.Room;
import sprites.Boss;
import sprites.Sprite;
import util.ImageUtil;

public class Intro extends Room 
{
	public Intro()
	{
		super(600, 800, 2);
		
		this.addSprite(new Sprite(ImageUtil.getBufferedImage("/resources/background.png"), 0, 0, 0));
		this.addSprite(new Sprite(ImageUtil.getBufferedImage("/resources/stage/space.png"), 160, 350, 1));
		this.addSprite(new Sprite(ImageUtil.getBufferedImage("/resources/stage/state1.png"), 210, 300, 1));
	}
}
