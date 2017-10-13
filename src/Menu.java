import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Menu {

		
	Image title;
	
	// Creating rectangles for the buttons
	public Rectangle playButton = new Rectangle(Game.WIDTH + 300, 400, 200, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH + 300, 500, 200, 50);
	
	
	public Menu()
	{
		title = Toolkit.getDefaultToolkit().getImage("CrazyDriver.png");
	}
	
	public void draw(Graphics g)
	{
		if(Game.State == Game.STATE.MENU)
		{
			
		
		g.drawImage(title, Game.WIDTH + 75, 50, 640, 200, null);
		
		
		// Public abstract class that displays graphics
		Graphics2D g2d = (Graphics2D) g;
		
		
		//Drawing Letters and Displaying the buttons to the screen
		Font fnt1 = new Font("Arial", Font.BOLD, 30);
		g.setColor(Color.black);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x + 70, playButton.y + 35);
		g2d.draw(playButton);
		g.drawString("Quit", quitButton.x + 70, quitButton.y + 35);
		g2d.draw(quitButton);
		}
		
	}
	
}
			
	
			
		
	
	
	
	

