package sprites;

import java.awt.image.BufferedImage;
import java.util.Random;

import util.ImageUtil;

public class Enemy extends Sprite
{
	private static Random r = new Random();
	
	private boolean right = true;
	
	public Enemy(int x, int y)
	{
		super(Enemy.getImage(), x, y, 1);
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
	}
	
	public static BufferedImage getImage()
	{
		return ImageUtil.getBufferedImage("/resources/enemies/" + (r.nextInt(15) + 1) + ".png");
	}
}
