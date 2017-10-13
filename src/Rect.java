import java.awt.Color;
import java.awt.Graphics;

public class Rect {
	   double  x;
	   double y;
	   int w;
	   int h;


	   public Rect(double x2, double y2, int w, int h)
	   {
	      this.x = x2;
	      this.y = y2;

	      this.w = w;
	      this.h = h;
	   }

	   public boolean contains(double mx, double my)
	   {
	      return ((mx < x+w) && (mx > x) && (my > y) && (my < y+h));
	   }

	   public boolean hasCollidedWith(Rect r)
	   {
	      return ((r.x <= x+w) && (r.x+r.w >= x) && (r.y+r.h >= y) && (r.y <= y+h));
	   }
	   
	   public double getX()
	   {
		   return this.x;
	   }
	   
	   public double getY()
	   {
		   return this.y;
	   }



	   public void  moveBy(double dx, double dy)
	   {
	      x += dx;
	      y += dy;
	   }

	   public void moveLeftBy(double dx)
	   {
	      x -= dx;
	   }

	   public void moveRightBy(double dx)
	   {
	      x += dx;
	   }

	   public void moveUpBy(double dy)
	   {
	      y -= dy;
	   }

	   public void moveDownBy(double dy)
	   {
	      y += dy;
	   }

	   public void draw(Graphics g)
	   {	
		   g.setColor(Color.green);
		   g.drawRect((int)x,(int) y, w, h);
		   
	   }

}