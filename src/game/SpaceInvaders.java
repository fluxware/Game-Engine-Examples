package game;

import gui.Game;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import level.Room;
import sprites.Enemy;
import sprites.Player;
import sprites.PlayerBullet;
import sprites.Sprite;
import util.ImageUtil;

public class SpaceInvaders implements KeyListener
{
	private Room room;
	
	private Player player = new Player();
	
	public SpaceInvaders()
	{
		//Create a new Room that is 600px wide, 800px tall, with 3 layers.
		room = new Room(600, 800, 3);
		
		//Create a new background Sprite. This is our "start-field" that we will see at all times.
		Sprite background = new Sprite(ImageUtil.getBufferedImage("/resources/background.png"), 0, 0, 0);
		
		room.addSprite(background); //Add it to the room.
		
		//Now we add the Player.
		room.addSprite(player);
		
		for(int i = 0; i < 12; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				room.addSprite(new Enemy(i * 50, j * 64));
			}
		}
		
		//This is what will create our Game window.
		//We give it our room and tell it that it isn't fullscreen.
		//Also, we set our window size to (600, 800) and give it the title of "Protect the Gray"
		Game g = new Game(room, false, new Dimension(600, 800), "Protect the Gray.");
		
		//Here we tell our game to listen to key Strokes.
		g.addKeyListener(this);
	}
	
	public static void main(String args[])
	{
		new SpaceInvaders();
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
			room.addSprite(new PlayerBullet(player.getX(), room));
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
