package sprites;

import java.util.LinkedList;

import level.Room;
import util.ImageUtil;
import collision.Collision;

public class PlayerBullet extends Sprite  
{
	private Room r;
	
	public PlayerBullet(int x, Room r)
	{
		super(ImageUtil.getBufferedImage("/resources/bullets/bullet.png"), x, 695, 1);
		
		this.r = r;
	}
	
	public void update(long frame, long total)
	{
		super.update(frame, total);
		
		this.setY(this.getY() - 5);
		
		LinkedList<Sprite> list = Collision.hasCollided(this, r.getSprites(), false);

		for(Sprite s : list)
		{
			if(s instanceof Enemy)
			{
				r.removeSprite(this);
				r.removeSprite(s);
			}
		}
		
		if(this.getY() < 20)
		{
			r.removeSprite(this);
		}
	}
}
