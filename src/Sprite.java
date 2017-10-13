import java.awt.Graphics;

public class Sprite {
	// w for width
	// h height

	int x;
	int y;
	int w;
	int h;
	Animation[] animation;
	// Rect rect;

	public static final int UP = 0;
	public static final int DN = 1;
	public static final int LT = 2;
	public static final int RT = 3;

	int action = DN;

	boolean moving = false;

	public Sprite(int x, int y, int w, int h, String fileName, int count, int duration, String[] action) {

		this.x = y;
		this.y = y;
		this.w = w;
		this.h = h;
		// image = Toolkit.getDefaultToolkit().getImage(fileName);
		animation = new Animation[action.length];
		// rect = new Rect(x + 10 ,y,130,70);
		for (int i = 0; i < animation.length; i++) {
			// animation[i] = new
			// Animation(fileName+"_"+action[i]+"_",count,duration);
			animation[i] = new Animation(fileName, count, duration);
		}
	}

	// what does this do
	public boolean contains(int mx, int my) {
		return ((mx < x + w) && (mx > x) && (my > y) && (my < y + h));
	}
	
	
	public boolean hasCollidedWith(Rect r) {
		return ((r.x <= x + w) && (r.x + r.w >= x) && (r.y + r.h >= y) && (r.y <= y + h));
	}

	public void moveBy(int dx, int dy) {
		x += dx;
		y += dy;
		// rect.moveBy((int)dx,(int) dy);
	}

	public void moveLeftBy(int dx) {
		x -= dx;
		// System.out.println("left" + dx);
		action = LT;
		moving = true;
		// rect.moveLeftBy(dx);
	}

	public void moveRightBy(int dx) {
		x += dx;
		// System.out.println("RIGHT" + dx);
		action = RT;
		moving = true;
		// rect.moveRightBy(dx);
	}

	public void moveUpBy(int dy) {
		y -= dy;
		action = UP;
		moving = true;
		// rect.moveUpBy(dy);
	}

	public void moveDownBy(int dy) {
		y += dy;
		action = DN;
		moving = true;
		// rect.moveDownBy(dy);
	}

	public int getX() {

		return this.x;
	}

	public int getY() {

		return this.y;
	}

	public void draw(Graphics g) {
		if (moving) {
			g.drawImage(animation[action].nextImage(), x, y, null);
			// rect.draw(g);
		}

		else {
			g.drawImage(animation[action].staticImage(), x, y, null);
			// rect.draw(g);
		}

		moving = false;
		// g.drawRect(x, y, w, h);
	}
}
