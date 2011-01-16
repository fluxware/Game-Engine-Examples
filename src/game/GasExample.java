package game;

import gui.Game;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import level.Room;

public class GasExample implements KeyListener
{
	private Room room;
	private Random ran = new Random();

	
	public GasExample()
	{
		room = new Room(800, 800, 1);
		
		for(int i = 0; i < 10; i++)
		{
			room.addSprite(new Particle(ran.nextInt(room.getWidth()), ran.nextInt(room.getHeight()), room));
		}
		
		Game g = new Game(room, false, new Dimension(800, 800), "Gas Test");
		g.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			System.exit(0);
		}
	}
	
	public static void main(String args[])
	{
		new GasExample();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
