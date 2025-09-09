package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import objects.Face;
import objects.Player;
import objects.Title;

public class Menu {

	GamePanel gp;
	KeyHandler keyH;

	public Face face = new Face("Otto_Ansikte", "Axel_Ansikte");
	public Title title = new Title("title");
	public boolean[] loadImageOnce = { true, true, true, true };
	public boolean menu = true;
	public boolean menuE = false;
	int playerNum1 = 1;
	int playerNum2 = 1;
	int wait = 0;

	Font arial_75 = new Font("Arial", Font.PLAIN, 75);
	Font arial_30 = new Font("Arial", Font.PLAIN, 30);

	public Menu(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
	}

	public void draw(Graphics2D g2) {

		g2.setColor(new Color(20, 20, 20));

		g2.fillRect(90, 200, 210, 50);
		g2.fillRect(700, 200, 215, 50);

		g2.fillRect(815, 380, 100, 100);
		g2.fillRect(700, 380, 100, 100);
		g2.fillRect(700, 265, 100, 100);
		g2.fillRect(815, 265, 100, 100);
		g2.fillRect(90, 380, 100, 100);
		g2.fillRect(205, 380, 100, 100);
		g2.fillRect(90, 265, 100, 100);
		g2.fillRect(205, 265, 100, 100);

		g2.drawImage(face.ottoFace, 95, 270, 90, 90, null);
		g2.drawImage(face.axelFace, 210, 270, 90, 90, null);

		g2.drawImage(face.ottoFace, 705, 270, 90, 90, null);
		g2.drawImage(face.axelFace, 820, 270, 90, 90, null);

		g2.setColor(new Color(130, 0, 0));

		switch (playerNum1) {
		case 1:
			g2.drawRect(90, 265, 100, 100);
			break;
		case 2:
			g2.drawRect(205, 265, 100, 100);
			break;
		case 3:
			g2.drawRect(90, 380, 100, 100);
			break;
		case 4:
			g2.drawRect(205, 380, 100, 100);
			break;
		}

		switch (playerNum2) {
		case 1:
			g2.drawRect(700, 265, 100, 100);
			break;
		case 2:
			g2.drawRect(815, 265, 100, 100);
			break;
		case 3:
			g2.drawRect(700, 380, 100, 100);
			break;
		case 4:
			g2.drawRect(815, 380, 100, 100);
			break;
		}

		g2.drawRect(90, 200, 210, 50);
		g2.drawRect(700, 200, 215, 50);

		g2.setFont(arial_30);
		if (Player.ai1 == false) {
			g2.drawString("PLAYER ONE", 100, 235);
		} else if (Player.ai1 == true) {
			g2.drawString("AI", 185, 235);
		}

		if (Player.ai2 == false) {
			g2.drawString("PLAYER TWO", 710, 235);
		} else if (Player.ai2 == true) {
			g2.drawString("AI", 795, 235);
		}

		g2.drawImage(title.titel, 250 - title.xpos * 4, 90 - title.ypos, 500 + title.xpos * 8, 50 + title.ypos, null);

		if (wait == 1) {
			g2.setColor(new Color(20, 20, 20));
			g2.fillRect(0, 0, 1000, 600);

			g2.setColor(new Color(70, 70, 70));
			g2.setFont(arial_30);
			g2.drawString("LOADING", 440, 300);
		}

	}

	public void update() {

//		if (Player.aiTraining == true) {
//
//			menuE = true;
//
//			playerNum1 = (int) (Math.random() * 2) + 1;
//			playerNum2 = (int) (Math.random() * 2) + 1;
//
//			switch (playerNum1) {
//			case 1:
//				gp.player1.pickC("Otto");
//				break;
//			case 2:
//				gp.player1.pickC("Axel");
//				break;
//			case 3:
//				gp.player1.pickC("Otto");
//				break;
//			case 4:
//				gp.player1.pickC("Axel");
//				break;
//			}
//
//			switch (playerNum2) {
//			case 1:
//				gp.player2.pickC("Otto");
//				break;
//			case 2:
//				gp.player2.pickC("Axel");
//				break;
//			case 3:
//				gp.player2.pickC("Otto");
//				break;
//			case 4:
//				gp.player2.pickC("Axel");
//				break;
//			}
//
//		}

//		if (Player.aiTraining == false) {
		title.sizeChange();

		if (keyH.gPressed == true) {
			title.replayIntro();
		}

		if (keyH.onePressed == true) {
			Player.ai1 = !Player.ai1;
			keyH.onePressed = false;
		}
		if (keyH.twoPressed == true) {
			Player.ai2 = !Player.ai2;
			keyH.twoPressed = false;
		}

		if (keyH.leftPressedL == true) {
			playerNum1--;
			keyH.leftPressedL = false;
		}
		if (keyH.rightPressedL == true) {
			playerNum1++;
			keyH.rightPressedL = false;
		}
		if (keyH.leftPressedR == true) {
			playerNum2--;
			keyH.leftPressedR = false;
		}
		if (keyH.rightPressedR == true) {
			playerNum2++;
			keyH.rightPressedR = false;
		}

		if (playerNum2 > 4) {
			playerNum2 = 1;
		}

		if (playerNum2 < 1) {
			playerNum2 = 4;
		}

		if (playerNum1 > 4) {
			playerNum1 = 1;
		}

		if (playerNum1 < 1) {
			playerNum1 = 4;
		}

//		}

		if (keyH.enterPressed == true) {

			switch (playerNum1) {
			case 1:
				gp.player1.pickC("Otto");
				break;
			case 2:
				gp.player1.pickC("Axel");
				break;
			case 3:
				gp.player1.pickC("Otto");
				break;
			case 4:
				gp.player1.pickC("Axel");
				break;
			}

			switch (playerNum2) {
			case 1:
				gp.player2.pickC("Otto");
				break;
			case 2:
				gp.player2.pickC("Axel");
				break;
			case 3:
				gp.player2.pickC("Otto");
				break;
			case 4:
				gp.player2.pickC("Axel");
				break;
			}

			menuE = true;
		}

		if (menuE == true) {
			wait++;

			if (wait == 2) {
//				if (Player.aiTraining == false) {
				switch (gp.player1.name) {
				case "Otto":
					if (loadImageOnce[0] == true)
						gp.player1.getPlayerImageOL();
					loadImageOnce[0] = false;
					break;
				case "Axel":
					if (loadImageOnce[1] == true) {
						gp.player1.getPlayerImageAL();
						loadImageOnce[1] = false;
					}
					break;
				}

				switch (gp.player2.name) {
				case "Otto":
					if (loadImageOnce[2] == true) {
						gp.player2.getPlayerImageOR();
						loadImageOnce[2] = false;
					}
					break;
				case "Axel":
					if (loadImageOnce[3] == true) {
						gp.player2.getPlayerImageAR();
						loadImageOnce[3] = false;
					}
					break;

				}
//				}

				gp.player1.setDefaultValues();
				gp.player2.setDefaultValues();
				menu = false;
				menuE = false;
				wait = 0;
			}
		}

	}
}
