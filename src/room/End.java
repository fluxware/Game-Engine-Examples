package room;

import game.SpaceInvaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import level.Room;
import sprites.Boss;
import sprites.Player;
import sprites.PlayerBullet;
import sprites.Sprite;
import util.ImageUtil;

public class End extends Room
{
	private Player player;
	
	public End(Player player, LinkedList<Sprite> list, SpaceInvaders s)
	{
		super(600, 800, 3);
		
		this.addSprite(new Sprite(ImageUtil.getBufferedImage("/resources/background.png"), 0, 0, 0));
		
		for(Sprite sp: list)
		{
			this.addSprite(sp);
		}
		
		this.addSprite(new Boss(this));
		this.player = player;
	}
	
	public void keyPressed(KeyEvent e)
	{
		//If the player presses the Left arrow, move the Player character 10px to the left.
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			player.moveLeft();
		}
		
		//If the player presses the right arrow, move the Player character 10px to the right.
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			player.moveRight();
		}
		
		//If the player presses space, create a new PlayerBullet.
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			this.addSprite(new PlayerBullet(player.getX(), this));
		}
	}
}
