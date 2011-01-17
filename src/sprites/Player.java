package sprites;

import util.ImageUtil;
import util.Timer;

public class Player extends Sprite 
{
	private int health = 10;
	private int xSpeed = 0;

	private boolean right = true;
	
	private Timer time = new Timer(50);

	public Player()
	{
		super(ImageUtil.getBufferedImage("/resources/player_ship.png"), 284, 700, 1);
	}

	public void update(long frame, long total)
	{
		int test = this.getX() + xSpeed;
		
		if((right && test < 568) || (!right && test > 0))
		{
			this.setX(test);
		}
		else
		{
			xSpeed = 0;
		}

		if(time.hasRung())
		{
			if(xSpeed > 0)
			{
				xSpeed -= 1;
				right = true;
			}
			else if(xSpeed < 0)
			{
				xSpeed += 1f;
				right = false;
			}
		}
	}

	public void moveLeft()
	{
		xSpeed -= 5;
	}

	public void moveRight()
	{
		xSpeed += 5;
	}
	
	public void removeHealth()
	{
		health--;
	}
	
	public boolean isDead()
	{
		return health <= 0;
	}
}
