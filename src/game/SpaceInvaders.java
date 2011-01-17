package game;

import gui.Game;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import level.Room;
import room.Intro;
import room.Stage1;
import sprites.Player;

public class SpaceInvaders
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
		Game g = new Game(new Intro(this, player), false, new Dimension(600, 800), "Protect the Gray.");
		game = g;
	}
	
	public static void main(String args[])
	{
		new SpaceInvaders();
	}
	
	
	
	public void setRoom(Room r)
	{
		game.removeKeyListener(game.getRoom());
		game.setRoom(r);
		game.addKeyListener(r);
	}
}
