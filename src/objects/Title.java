package objects;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Title {

	public int xpos, ypos;

	int a = 1;
	int b = 0;
	static public boolean menubeg = true;

	public BufferedImage titel;

	public Title(String spriteName1) {
		String filePath = "Title";
		try {
			titel = ImageIO.read(getClass().getResourceAsStream("/" + filePath + "/" + spriteName1 + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		xpos = -300;
		ypos = -300;
	}

	public void sizeChange() {

		if (menubeg == false) {
			
			if (b == 2) {
			
				xpos += a;
				ypos += a;
				b = 0;
				
			
				if (xpos > 36) {
				a = a * -1;
				xpos = 36;
			}
			if (xpos < 0) {
				a = a * -1;
			}
			}
			b++;


		}else if (menubeg == true) {
			xpos += 2;
			ypos += 2;
			if (xpos > 36) {
				menubeg = false;
				a = 1;
			}

		}

	}
	public void replayIntro(){
		xpos = -300;
		ypos = -300;
		menubeg = true;
	}

}
