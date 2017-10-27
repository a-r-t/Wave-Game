package mainGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * TO BE IMPLEMENTED - adds health to the player when they move over it
 * @author Brandon Loehle
 * 5/30/16
 *
 */

// implements health increase via Putin
public class PickupHealth extends Pickup{
	
	private Handler handler;

	public PickupHealth(ID id, Handler handler) {
		super(Game.WIDTH*Math.random(), Game.HEIGHT*Math.random(), id);
		this.handler = handler;
		this.handler = handler;
		velX = Math.random()*10;
		velY = Math.random()*10;
		img = getImage("images/PutinImage.png");
	}


	public void tick() {
		
		this.x += velX;
		this.y += velY;
		
		if (this.x <= 0 || this.x >= Game.WIDTH - 70){
			velX *= -1;
		}
		if (this.y<= 0 || this.y >= Game.HEIGHT - 90){
			velY *= -1;
		}
		
	}
	
	public Image getImage(String path) {
		Image image = null;
		try {
			URL imageURL = Game.class.getResource(path);
			image = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return image;
	}


	public void render(Graphics g) {
		g.drawImage(img, (int) this.x, (int) this.y, 70, 90, null);
		
	}


	public Rectangle getBounds() {
		return new Rectangle((int) this.x, (int) this.y, 70, 90);
	}

}
