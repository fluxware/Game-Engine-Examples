package game;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import level.Room;
import sprites.Sprite;
import util.ImageUtil;
import collision.Collision;

public class Particle extends Sprite 
{
	private Room room;
	
	private static Random ran = new Random();
	
	private int xd = 5;
	private int yd = 5;
	
	public Particle(int x, int y, Room r)
	{
		super(Particle.getBI(), x, y, 1);
		
		this.room = r;
	}
	
	private static BufferedImage getBI()
	{
		Random r = new Random();
		
		return ImageUtil.getBufferedImage("/resources/bullets/" + r.nextInt(361) + ".png");
	}
	
	public void update(long frame, long total)
	{
		super.update(frame, total);
		
		LinkedList<Sprite> c = Collision.hasCollided(this, room.getSprites(), false);
		
		if(c.isEmpty() == false)
		{
			randomDirection();
		}
		
		if(this.getX() < 0 || this.getX() > room.getWidth() || this.getY() < 0 || this.getY() >= this.getWidth())
		{
			randomDirection();
		}
		
		this.setX(this.getX() + xd);
		this.setY(this.getY() + yd);
	}
	
	private void randomDirection()
	{
		xd = ran.nextInt(41) - 20;
		yd = ran.nextInt(41) - 20;
	}
}
