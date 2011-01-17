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
	
	private double xDir = 0;
	private double yDir = 5;
	
	private double curX = 0;
	private double curY = 0;
	
	public EnemyBullet(int x, int y, Room r)
	{
		super(img(), x, y, 1);
		
		curX = x;
		curY = y;
		
		room = r; 
	}
	
	public EnemyBullet(int x, int y, double xSpeed, double ySpeed, Room r)
	{
		super(img(), x, y, 1);
		
		xDir = xSpeed;
		yDir = ySpeed;
		
		curX = x;
		curY = y;
		
		room = r;
	}
	
	public void update(long frame, long total)
	{
		super.update(frame, total);
		
		curX += xDir;
		curY += yDir;
		
		this.setX((int)curX);
		this.setY((int)curY);
		
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
