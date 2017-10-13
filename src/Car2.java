import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Car2 {

	double x;
	double y;
	double carSpeedX;
	double carSpeedY;
	Rect collisionRect;
	Image carImage1;
	

	public Car2(double x, double y)
	{
		this.x = x;
		this.y = y;
		
		//----COLLITION DETECTION		
		collisionRect = new Rect(x , y,100,100);
		
		carImage1 = Toolkit.getDefaultToolkit().getImage("whiteCar.png");
	}
	
	
	public void moveleft()
	{
		this.x = x - carSpeedX;
		collisionRect.moveLeftBy(carSpeedX);
	}
	
	public void moveRight()
	{
		this.x = x + carSpeedX;
		collisionRect.moveLeftBy(carSpeedX);
	}
	
	public void moveUp()
	{
		this.y = y - carSpeedY;
		collisionRect.moveLeftBy(carSpeedY);
	}
	public void moveDown()
	{
		this.y = y + carSpeedY;
		collisionRect.moveLeftBy(carSpeedY);
	}
	
	
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public void setVehicule1X(double carSpeedX)
	{
		this.carSpeedX = carSpeedX;
	}
	
	public void setVehicule1Y(double carSpeedY)
	{
		this.carSpeedY = carSpeedY;
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(carImage1, (int) x, (int) y, 10, 10, null);
		collisionRect.draw(g);
	}
	
}
