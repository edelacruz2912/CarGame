import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;



public class Game extends Applet implements Runnable, KeyListener {
	
	/* QUESTION 
	 *Game.WIDTH how to acces stuff inside of a class like that 
	 * 
	 * 
	 * 
	 * */
	
	//------------------------------------------------------------------------------
	/*
	 * The Runnable interface should be implemented by any class whose instances
	 * are intended to be executed by a thread. The class must define a method
	 * of no arguments called run.
	 * 
	 */
	
	///-------------------------------------------------------------------------///
	
	
	//MovingBackground
	
	ImageLayer road;
	
	//MenuBackground
	
	ImageLayer backGroundMenu;
	
	//TrafficGenerator
	
	Traffic traffic ;
	
	//Player
	
	Player player;
	
	//State of the Game
	public enum STATE
	{
		MENU,
		GAME,
		GameOver
		
	}; 
	
	// Main State (first one that appears)
	public static STATE State = STATE.MENU;
	
	
	//MENU
	Menu menu;
	
	
	
	/* DOUBLE BUFFERING */
	Image offScreen;
	Graphics offScreen_g;

	// Declaring our key codes as booleans
	boolean leftPressed = false;
	boolean rightPressed = false;
	boolean upPressed = false;
	boolean downPressed = false;
	boolean xPressed = false;

	// Declaring a Threat

	Thread t;

	/*
	 * The init() method is the first method called in an Applet or JApplet.
	 * When an applet is loaded by the Java plugin of a browser or by an applet
	 * viewer, it will first call the Applet.init method.Any initializations
	 * that are required to use the applet should be executed here.
	 * 
	 */

	public void init() {
		
		//Setting Applet Size
		this.setSize(800, 740);
		
		//Double Buffering(SOLVING FLICKERING)
		offScreen = createImage(1000, 800);
		offScreen_g = offScreen.getGraphics();
		
		
		
		//MENU
		
		menu = new Menu();
		
		//BackGround Menu
		
		backGroundMenu = new ImageLayer("menuBacground.jpg",getX() - 20,getY(),10,600);
		
		//Road Background
		road = new ImageLayer("biggerHighway.png",getX() - 20,getY(),10,600);
		
		
		//Player Initialization
		///why it gets created in the wrong place
		
		player = new Player(Game.WIDTH / 2, 600);
		traffic = new Traffic(player);
		
		
		//Traffic Generator
		
		
		
		
				
		
		
		addKeyListener(this);
		this.addMouseListener(new MouseInput());

		requestFocus();
		t = new Thread(this);
		t.start();

	}

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		
		while (true) 
		{
			
			/*
			 * The repaint() method is used to cause paint() to be invoked by
			 * the AWT painting thread.
			 */
			SpriteMovement();
			repaint();
			tryAndCatch();
			
			

		}

		}

	

	// try and catch
	public void tryAndCatch() {
		try 
		{
			Thread.sleep(15);
		} catch (Exception x) 
		{
		}
		;
	}
	
	public void SpriteMovement()
	{
		
		if(State == STATE.GAME)
		{	
			
			//Generates traffic
			traffic.trafficGenerator();
			traffic.policeGenerator();
			//it moves down traffic
			traffic.comingTrafic();
			
			Camera2D.moveDownBy(35);
		
			// When key are pressed this happens
			if(leftPressed) 
			{
				player.playerMoveLeft(5);
			}
			    
			if(rightPressed) 
			{
				player.playerMoveRight(5);
			}   
			
			if(upPressed)
			{
				player.playerMoveUp(3);
			}
				
			if(downPressed) 
			{
				player.playerMoveDown(3);
			}
	}
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		

		if(State == STATE.GAME)
		{
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT )
		{
	    	leftPressed = true;
	    	
		}	
	
		if(e.getKeyCode()==KeyEvent.VK_RIGHT )
		{
			rightPressed = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP ) 
		{
			upPressed = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN ) 
		{
			downPressed = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_X)
		{
			xPressed = true;
		}
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(State == STATE.GAME)
		{
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT )
		{
	    	leftPressed = false;
		}	
	
		if(e.getKeyCode()==KeyEvent.VK_RIGHT )
		{
			rightPressed = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP ) 
		{
			upPressed = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN ) 
		{
			downPressed = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_X)
		{
			xPressed = false;
		}
		
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void update(Graphics g) {
		offScreen_g.clearRect(0, 0, 1000, 800);

		paint(offScreen_g);

		g.drawImage(offScreen, 0, 0, 1000, 800, this);
	}

	/*
	 * Invoked immediately after the start() method, and also any time the
	 * applet needs to repaint itself in the browser. The paint() method is
	 * actually inherited from the java.awt.
	 */

	public void paint(Graphics g) {
		
		if(State == STATE.MENU)	
		{
			
			//backGroundMenu.draw(g);
			menu.draw(g);
		}
		else if (State == STATE.GAME)
		{
		 //Road BackGround
		 road.draw(g);
		 
		 //TrafficDrawing
		
		//traffic.comingPolice();
		 traffic.draw(g);
		 
		 //Drawing the Player
		 
		 player.draw(g);
		 
		}
		
		else if (State == STATE.GameOver)
		{	
			setBackground(Color.black);
			
			Font fnt1 = new Font("Arial", Font.BOLD, 70);
			Font fnt2 = new Font("Arial", Font.BOLD, 30);
			g.setColor(Color.black);
			g.setFont(fnt1);
			
			g.drawString("GAME OVER",200, 100);
			g.setFont(fnt2);

			g.drawString("Try Again", 330,  635);
			g.drawRect(Game.WIDTH + 300, 600, 200, 50);
			System.out.print("Game OVER");
			
			
		}
		 
		 
		 
	}
	
	
	
	
	
	
	
	
	
}
