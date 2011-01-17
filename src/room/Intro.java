package room;

import game.SpaceInvaders;

import java.awt.event.KeyEvent;

import level.Room;
import sprites.Player;
import sprites.Sprite;
import util.ImageUtil;

public class Intro extends Room 
{
	private SpaceInvaders s;
	private Player player;
	
	public Intro(SpaceInvaders s, Player player)
	{
		super(600, 800, 2);
		
		this.addSprite(new Sprite(ImageUtil.getBufferedImage("/resources/background.png"), 0, 0, 0));
		this.addSprite(new Sprite(ImageUtil.getBufferedImage("/resources/stage/space.png"), 160, 350, 1));
		this.addSprite(new Sprite(ImageUtil.getBufferedImage("/resources/stage/state1.png"), 210, 300, 1));
		
		this.s = s;
		this.player = player;
	}
	
	public void keyPressed(KeyEvent e)
	{	
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			Stage1 s1 = new Stage1(player, s);
			s.setRoom(s1);
		}
	}
}
