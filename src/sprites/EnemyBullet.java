package sprites;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import level.Room;
import util.ImageUtil;
import collision.Collision;

public class EnemyBullet extends Sprite 
{
	private static Random ran = new Random();
	
	private Room room;
	
	private int xDir = 0;
	private int yDir = 5;
	
	public EnemyBullet(int x, int y, Room r)
	{
		super(img(), x, y, 1);
		
		room = r; 
	}
	
	public EnemyBullet(int x, int y, int xSpeed, int ySpeed, Room r)
	{
		super(img(), x, y, 1);
		
		xDir = xSpeed;
		yDir = ySpeed;
		
		room = r;
	}
	
	public void update(long frame, long total)
	{
		super.update(frame, total);
		
		this.setX(this.getX() + xDir);
		this.setY(this.getY() + yDir);
		
		if(this.getX() < -10 || this.getX() > 810 || this.getY() > 810)
		{
			room.removeSprite(this);
		}
		
		LinkedList<Sprite> col = Collision.hasCollided(this, room.getSprites(), false);
		
		for(Sprite s : col)
		{
			if(s instanceof Player)
			{
				room.removeSprite(this);
				Player p = (Player)s;
				p.removeHealth();
				
				if(p.isDead())
				{
					System.exit(0);
				}
			}
		}
	}
	
	private static BufferedImage img()
	{
		return ImageUtil.getBufferedImage("/resources/bullets/" + ran.nextInt(361) + ".png");
	}
}
