package sprites;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import level.Room;
import util.ImageUtil;
import util.Timer;
import collision.Collision;

public class Boss extends AnimatedSprite
{
	private Random ran = new Random();
	
	private boolean moveDown = true;

	private Room r;

	private int health = 2000;
	
	private Timer time = new Timer(75);

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
				for(Sprite s : col)
				{
					if(s instanceof PlayerBullet)
					{
						r.removeSprite(s);
						health--;
						isDead();
					}
				}
			}
		}
		
		if(time.hasRung())
		{
			r.addSprite(new EnemyBullet(this.getX() + 70, this.getY() + 60, ran.nextInt(6)-3, ran.nextInt(5) + 1, r));
		}
	}

	public void isDead()
	{
		if(health <=0)
			System.exit(0);
	}
}
