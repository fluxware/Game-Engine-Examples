package sprites;

import util.ImageUtil;

public class Player extends Sprite 
{
	public Player()
	{
		super(ImageUtil.getBufferedImage("/resources/player_ship.png"), 284, 700, 1);
	}
}
