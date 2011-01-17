package sprites;

import java.awt.image.BufferedImage;
import java.util.Random;

import level.Room;
import util.ImageUtil;
import util.Timer;

public class Enemy extends Sprite
{
	private static Random r = new Random();
	
	private boolean right = true;
	
	private Room room;
	private Timer time;
	
	public Enemy(int x, int y, Room r)
	{
		super(Enemy.getImage(), x, y, 1);
		
		room = r;
		
		time = new Timer(this.r.nextInt(2000) + 3000);
	}
	
	public void update(long frame, long total)
	{
		super.update(frame, total);
		
		if(right)
		{
			this.setX(this.getX() + 2);
			
			if(this.getX() >= 600 - this.getWidth())
			{
				this.setY(this.getY() + 32);
				
				right = !right;
			}
		}
		else
		{
			this.setX(this.getX() - 2);
			
			if(this.getX() <= 0)
			{
				this.setY(this.getY() + 32);
				
				right = !right;
			}
		}
		
		if(time.hasRung())
		{
			room.addSprite(new EnemyBullet(this.getX() + (this.getWidth() << 2), this.getY() + (this.getHeight() << 2), room));
			time = new Timer(r.nextInt(5000) + 3000);
		}
	}
	
	public static BufferedImage getImage()
	{
		return ImageUtil.getBufferedImage("/resources/enemies/" + (r.nextInt(15) + 1) + ".png");
	}
}
