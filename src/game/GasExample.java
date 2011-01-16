package game;

import gui.Game;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JOptionPane;

import level.Room;

public class GasExample implements KeyListener
{
	private Room room;
	private Random ran = new Random();
	public static boolean pixelPerfect = false; 
	
	public GasExample(boolean pixelPerfect, int number)
	{
		room = new Room(800, 800, 1);
		
		GasExample.pixelPerfect = pixelPerfect;
		
		for(int i = 0; i < number; i++)
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
		int option = JOptionPane.showConfirmDialog(null, "Do you want Pixel Perfect?", "Pixel Perfect?", JOptionPane.YES_NO_OPTION);
		boolean pp = false;
		
		if(option == JOptionPane.YES_OPTION)
		{
			pp = true;
		}
		
		String s = JOptionPane.showInputDialog(null, "Number of Particles?");
		int number = 10;
		try
		{
			number = Integer.parseInt(s);
		}
		catch(Exception e)
		{
			number = 10;
		}
		
		new GasExample(pp, number);
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
