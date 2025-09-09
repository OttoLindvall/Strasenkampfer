package objects;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Face {
	
	public BufferedImage ottoFace,axelFace;

	public Face(String spriteName1, String spriteName2) {
		String filePath = "Face";
		try {
			ottoFace = ImageIO.read(getClass().getResourceAsStream("/" + filePath + "/" + spriteName1 + ".png"));
			axelFace = ImageIO.read(getClass().getResourceAsStream("/" + filePath + "/" + spriteName2 + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
