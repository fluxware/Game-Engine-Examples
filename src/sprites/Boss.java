package sprites;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import level.Room;
import util.ImageUtil;
import collision.Collision;

public class Boss extends AnimatedSprite
{
	private boolean moveDown = true;

	private Room r;

	private int health = 10000;

	public Boss(Room r)
	{
		super(Boss.img(), 239, 1, 1, 20);

		this.r = r;
	}

	public static BufferedImage[] img()
	{
		BufferedImage[] rv = new BufferedImage[360];

		for(int i = 0; i < 360; i++)
		{
			rv[i] = ImageUtil.getBufferedImage("/resources/boss/" + i + ".png");
		}

		return rv;
	}

	public void update(long frame, long total)
	{
		if(moveDown)
		{
			this.setY(this.getY() + 1);

			if(this.getY() >= 200)
			{
				moveDown = false;
			}
		}
		else
		{
			LinkedList<Sprite> col = Collision.hasCollided(this, r.getSprites(), false);

			if(col.isEmpty() == false)
			{
				health--;
			}
		}
	}

	public boolean isDead()
	{
		return health <= 0;
	}
}
