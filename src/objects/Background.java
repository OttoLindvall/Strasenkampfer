package objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {

	public BufferedImage background;
	public Background(String image1) {
		
		String filePath = "Background";
		try {
			background = ImageIO.read(getClass().getResourceAsStream("/" + filePath + "/" + image1 + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
	
	public void draw(Graphics2D g2) {
		
		g2.drawImage(background, 0, 0, 1000, 600, null);
		
	}
}
