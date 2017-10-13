import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ImageLayer {
	
	Image image;
	double x;
	double y;
	double z;
	int w;
	
	
	public ImageLayer(String filename, double x, double y, double z, int w)
	{
		image = Toolkit.getDefaultToolkit().getImage(filename);
		this.x = x;
		this.y = y; 
		this.w =w;
		this.z =z;
	}
	
	
	public void draw(Graphics g)
	{
		
		for(int i = 0; i< 100; i++)
		{	//w changes depending on my photo size
			g.drawImage(image, (int) (x - Camera2D.x / z) , (int) ( y + Camera2D.y / z) - w * i, null); 
		}
		
		
	}
	
	
}


