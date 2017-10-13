import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Player extends Sprite {

	//Fields
	
	int x;
	int y;
	double speed;
	Image imagePlayer;
	Rect collisionRect;
	public static int score = 100;
	
	
	
	private static final String[] action = { "up", "dn", "lt", "rt", };

	public static final int UP = 0;
	public static final int DN = 1;
	public static final int LT = 2;
	public static final int RT = 3;
	
	
	//Constructor	
	public Player(int x, int y)
	{	super(x, y, 50, 80, "redCar.png", 5, 10, action);
		this.x = x;
		this.y = y;
		
		// width and height of box w 57 , h 130
		// x and y (x+35 , y-1)
		collisionRect = new Rect(super.getX() + 35, super.getY() - 1 ,57,130);
		System.out.print("collitionBox cordinate " +collisionRect.getX() + "," + collisionRect.getY() );
		System.out.println("playerCordinate" + super.getX() + ","+ super.getY());
	}
	
	public void playerMoveUp(int speed)
	{
		super.moveUpBy(speed);
		collisionRect.moveUpBy(speed);
		
	}
	
	public void playerMoveDown(int speed)
	{
		super.moveDownBy(speed);
		collisionRect.moveDownBy(speed);
	}
	
	public void playerMoveLeft(int speed)
	{
		super.moveLeftBy(speed);
		collisionRect.moveLeftBy(speed);
	}
	
	public void playerMoveRight(int speed)
	{
		super.moveRightBy(speed);
		collisionRect.moveRightBy(speed);
		
	}
	
	
	
	public int getX()
	{
		return super.getX();
	}
	   
	public int getY()
	{
		return super.getY();
	}
	

	
	public void draw(Graphics g)
	{
		super.draw(g);
		String s = "Health: " + score;
		Font fnt1 = new Font("Arial", Font.BOLD, 35);
		g.setFont(fnt1);
		g.setColor(Color.red);
		g.drawString(s, 30,50);
		
		
		//collisionRect.draw(g);
	}
}
