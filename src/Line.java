import java.awt.Color;
import java.awt.Graphics;

public class Line
{
   int x1;
   int y1;

   int x2;
   int y2;

   double xv;
   double yv;


   public Line(int x1, int y1, int x2, int y2)
   {
      this.x1 = x1;
      this.y1 = y1;

      this.x2 = x2;
      this.y2 = y2;

      // Precaculate Vector v

      double mag = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));

      xv = (x1 - x2) / mag;

      yv = (y1 - y2) / mag;
   }


   public void draw(Graphics g)
   {  
	  g.setColor(Color.green);	
      g.drawLine(x1, y1, x2, y2);
   }


   public double distanceTo(int x, int y)
   {
      return (x - x1) * yv   -   (y - y1) * xv;
   }

}
