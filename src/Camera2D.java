
public class Camera2D {

	static double x;
	static double y;
	
	//static allows me to access the program anywhere in the program I want
	public static void moveUpBy(int dy) 
	{
		y -= dy;
	}
	
	public static void moveDownBy(int dy)
	{
		y += dy;
	}
	public static void moveLeftBy(int dy)
	{
		x -= dy;
	}
	public static void moveRightBy(int dy)
	{
		x += dy;
	}
}
