import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	//

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		//In the Menu State
		if(Game.State == Game.STATE.MENU)
		{
			
			//Play Button
			if(mouseX >= Game.WIDTH + 300 && mouseX <= Game.WIDTH + 500)
			{
				if(mouseY >= 400 && mouseY <= 450)
				{
					// Pressed play button
					 Game.State = Game.STATE.GAME;
				}
			}
			
		}
		
		// Quit Button
		 if(mouseX>= Game.WIDTH + 300 && mouseX <= Game.WIDTH + 500)
		 {
			 if(mouseY >= 500 && mouseY <= 550)
			 {
				 // Pressed quit button
				 System.exit(1);
			 }	
		 }
		 
		 
		 if(Game.State == Game.STATE.GameOver)
		 {
			 Game.State = Game.STATE.MENU;
		 }
	 }
		
	
	
	
	
	
	

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
