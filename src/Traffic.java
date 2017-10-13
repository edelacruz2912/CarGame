import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Traffic {

	public LinkedList<Car1> car1 = new LinkedList<Car1>();
	public LinkedList<Police> policeArray = new LinkedList<Police>();

	Player player;
	

	/*
	 * ask alkimede about passing a class or object as parameter ask whether it
	 * means since you pass the object it can use all the method and fields of
	 * that passed class.
	 * 
	 */

	/*
	 * ASK ALKIMEDES FOR THE REASON WHY YOU HAVE TO PASS PLAYER AS A PAREMETER
	 * IN THE CONTRUCTOR
	 * 
	 * -----is it because since it was going to be use for the collition it has
	 * to be initialize in the game(main) and pass as a parementer to be used
	 * inside the traffic class
	 * 
	 */

	/*
	 * WHAT IS THE DIFFERENT BETWEEN CREATING THE COLLISION BOX INSIDE OF THE
	 * SPRITE AND INSIDE THE CAR1 class
	 * 
	 */

	public Traffic(Player player) {
		this.player = player;
	}

	/*
	 * Generates traffic when list is empty
	 * 
	 */

	public void trafficGenerator() {
		double cordinateX[] = { 135, 270, 400, 534 };
		int carAmount = new Random().nextInt(4) + 1;

		if (car1.isEmpty()) {
			for (int i = 0; i < 4; i++) {
				Car1 car = new Car1(cordinateX[i], -50);
				// car.setVehicule1SpeedY(randomY());
				car.setVehicule1SpeedY(randomY());
				addCar1ToList(car);

			}

		}

	}

	public void policeGenerator() {
		if (policeArray.isEmpty()) {
			for (int i = 0; i < 1; i++) {
				Police police = new Police((int)randomX(), 800);
				// car.setVehicule1SpeedY(randomY());
				police.setPoliceSpeedX(2);
				police.setPoliceSpeedY(2);
				addPoliceToList(police);

			}

		}

	}

	public double randomY() {
		return Math.random() * 2 + 1;
	}

	public double randomX() {
		return Math.random() * 400 + 100;
	}
	

	public void comingTrafic() {

		for (int i = 0; i < car1.size(); i++) { // System.out.println(car1.size());
			car1.get(i).moveDown();

			if (car1.get(i).getY() > 740) {
				removeCar1ToList(car1.get(i));

			}
		}

		

		// COLLITION TRAFFIC vs PLAYER
		for (int i = 0; i < car1.size(); i++) {
			try {
				for (int k = 0; k < policeArray.size(); k++)
					// System.out.print(policeArray.size());
					if (policeArray.get(k).collisionRect.hasCollidedWith(car1.get(i).collisionRect)) {
						removeCar1ToList(car1.get(i));
						removePoliceToList(policeArray.get(k));
					}

				if (car1.get(i).collisionRect.hasCollidedWith(player.collisionRect)) {
					removeCar1ToList(car1.get(i));
					Player.score = Player.score - 10;
					if(Player.score <= 0)
					{
						Game.State = Game.STATE.GameOver;
					}
				}
			} catch (IndexOutOfBoundsException e) {
				System.err.println("IndexOutOfBoundsException Caught.");
				continue;
			}

			{
			}
		}

		/*
		 * FOR POLICE
		 * 
		 */

		for (int i = 0; i < policeArray.size(); i++) { // System.out.println(car1.size());
			policeArray.get(i).movePoliceUp();
			/*
			 * ARIFICIAL INTELLIGENCE FOR THE police class
			 * 
			 */

			if (policeArray.get(i).getX() < player.getX()) {
				policeArray.get(i).movePoliceRight();
			}

			else if (policeArray.get(i).getX() > player.getX()) {
				policeArray.get(i).movePoliceLeft();
			}

			if (policeArray.get(i).getY() < 10) {

				removePoliceToList(policeArray.get(i));
			}

		}

		// COLLITION police vs PLAYER
		for (int i = 0; i < policeArray.size(); i++) {
			if (policeArray.get(i).collisionRect.hasCollidedWith(player.collisionRect)) {
				removePoliceToList(policeArray.get(i));
				player.score = Player.score - 10;
				if(Player.score <= 0)
				{
					Game.State = Game.STATE.GameOver;
				}
			}

		}

	}

	public void addPoliceToList(Police police) {
		policeArray.add(police);
	}

	public void removePoliceToList(Police police) {
		policeArray.remove(police);
	}

	public void addCar1ToList(Car1 car) {
		car1.add(car);
	}

	public void removeCar1ToList(Car1 car) {
		car1.remove(car);
	}

	public void draw(Graphics g) {
		for (int i = 0; i < car1.size(); i++) {
			car1.get(i).draw(g);
		}

		for (int i = 0; i < policeArray.size(); i++) {
			policeArray.get(i).draw(g);
		}
	}

}
