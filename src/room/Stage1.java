package room;

import game.SpaceInvaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import level.Room;
import sprites.Enemy;
import sprites.Player;
import sprites.PlayerBullet;
import sprites.Sprite;
import util.ImageUtil;

public class Stage1 extends Room implements KeyListener
{
	private Player player;
	
	private int totalBaddies = 0;
	
	private SpaceInvaders s;
	
	public Stage1(Player player, SpaceInvaders s)
	{
		super(600, 800, 3);
		
		this.player = player;
		this.s = s;
		
		Sprite background = new Sprite(ImageUtil.getBufferedImage("/resources/background.png"), 0, 0, 0);

		this.addSprite(background); //Add it to the room.

		//Now we add the Player.
		this.addSprite(player);

		for(int i = 0; i < 12; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				this.addSprite(new Enemy(i * 50, j * 64));
				totalBaddies++;
			}
		}
	}
	
	public void roomClear()
	{
		if(totalBaddies <= 0)
		{
			s.setRoom(new End(this.getSprites(), s));
		}
	}
	
	public void removeBaddie()
	{
		totalBaddies--;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 * 
	 * This is where we put our logic for what happens whenever the player
	 * presses a key. Game is listening for keystrokes, and whenever it
	 * "hears" a key, it calls this method.
	 */
	public void keyPressed(KeyEvent e)
	{	
		//If the player presses the Left arrow, move the Player character 10px to the left.
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			player.setX(player.getX() - 10);
		}
		
		//If the player presses the right arrow, move the Player character 10px to the right.
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			player.setX(player.getX() + 10);
		}
		
		//If the player presses space, create a new PlayerBullet.
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			this.addSprite(new PlayerBullet(player.getX(), this));
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
