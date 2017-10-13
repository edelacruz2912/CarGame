import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Police {

	int x;
	int y;
	int policeSpeedX;
	int policeSpeedY;
	Rect collisionRect;
	Image image;
	
	public Police(int x, int y)
	{
		this.x = x;
		this.y = y;
				
		collisionRect = new Rect(x + 43, y + 13  ,59,123);
		image = Toolkit.getDefaultToolkit().getImage("Police.png");
			
	}
	
	public void movePoliceRight()
	{
		this.x = x + policeSpeedX;
		collisionRect.moveRightBy(policeSpeedX);
	}
	
	public void movePoliceLeft()
	{
		this.x = x - policeSpeedX;
		collisionRect.moveLeftBy(policeSpeedX);
	}
	
	public void movePoliceUp()
	{
		this.y = y - policeSpeedY;
		collisionRect.moveUpBy(policeSpeedY);
	}
	
	public void movePoliceDown()
	{
		this.y = y + policeSpeedY;
		collisionRect.moveDownBy(policeSpeedY);
	}
	
	public int getX()
	{
		return this.x;
		
	}
	
	public int getY()
	{
		return this.y;
		
	}

	
	
	//setting the speed to the fields in the top
	//by using setters.
	
	public void setPoliceSpeedX(int speed)
	{
		this.policeSpeedX = speed;
	}
	
	public void setPoliceSpeedY(int speed)
	{
		this.policeSpeedY = speed;
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(image, x, y, 150, 150, null);
		//collisionRect.draw(g);
	}
	
}
