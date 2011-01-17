package game;

import gui.Game;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import level.Room;
import room.Intro;
import room.Stage1;
import sprites.Player;
import sprites.Enemy;
import sprites.Player;
import sprites.PlayerBullet;
import sprites.Sprite;
import util.ImageUtil;

public class SpaceInvaders implements KeyListener
{
	private Room room;
	
	private Player player = new Player();
	
	private Game game;
	
	private boolean intro = true;
	
	public SpaceInvaders()
	{	
		//This is what will create our Game window.
		//We give it our room and tell it that it isn't fullscreen.
		//Also, we set our window size to (600, 800) and give it the title of "Protect the Gray"
		Game g = new Game(new Intro(), false, new Dimension(600, 800), "Protect the Gray.");
		game = g;
		
		//Here we tell our game to listen to key Strokes.
		game.addKeyListener(this);
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
		//If the player presses space, create a new PlayerBullet.
		if(intro && e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			Stage1 s1 = new Stage1(player);
			game.setRoom(s1);
			game.addKeyListener(s1);
			intro = false;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
