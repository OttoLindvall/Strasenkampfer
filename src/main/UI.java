package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import objects.Player;

public class UI {

	GamePanel gp;
	Font arial_40, arial_100;
	int length1, length2;
	int length3, length4;
	double temp1, temp2;
	double temp3, temp4;
	boolean soundPlay = true;

	public UI(GamePanel gp) {
		this.gp = gp;

		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_100 = new Font("Arial", Font.PLAIN, 100);
	}

	public void draw(Graphics2D g2) {

		g2.setFont(arial_40);
		if (gp.player1.hp > 0) {
			double hp1 = gp.player1.hp;
			temp1 = hp1 / gp.player1.maxHp;
			length1 = (int) (200 * temp1);
		} else if (gp.player1.hp <= 0) {
			g2.setColor(Color.RED);
			g2.setFont(arial_100);
			g2.drawString("K O", 400, 200);
//			if (Player.aiTraining == true) {
//				gp.ai1.win = false;
//				gp.ai2.win = true;
//				gp.ai1.newGameChange();
//				Player.aiTrainingTimer = 0;
//				gp.menu.menu = true;
//				gp.menu.menuE = false;
//			}
			if (soundPlay == true) {
				gp.sound.playSound(10);
				soundPlay = false;
			}
			length1 = 0;
		}

		if (gp.player2.hp > 0) {
			double hp2 = gp.player2.hp;
			temp2 = hp2 / gp.player2.maxHp;
			length2 = (int) (200 * temp2);
		} else if (gp.player2.hp <= 0) {
			g2.setColor(Color.RED);
			g2.setFont(arial_100);
			g2.drawString("K O", 400, 200);
//			if (Player.aiTraining == true) {
//				gp.ai2.win = false;
//				gp.ai1.win = true;
//				gp.ai1.newGameChange();
//				Player.aiTrainingTimer = 0;
//				gp.menu.menu = true;
//				gp.menu.menuE = false;
//			}
			if (soundPlay == true) {
				gp.sound.playSound(10);
				soundPlay = false;
			}
			length2 = 0;
		}

		if (gp.player1.atkC > 0) {
			double atkC1 = gp.player1.atkC;
			temp3 = atkC1 / gp.player1.atkCMax;
			length3 = (int) (200 * temp3);
		} else if (gp.player1.hp <= 0) {
			length3 = 0;
		}

		if (gp.player2.atkC > 0) {
			double atkC2 = gp.player2.atkC;
			temp4 = atkC2 / gp.player2.atkCMax;
			length4 = (int) (200 * temp4);
		} else if (gp.player2.hp <= 0) {
			length4 = 0;
		}

		g2.setColor(Color.DARK_GRAY);
		g2.fillRect(15, 15, 210, 30);
		g2.fillRect(1000 - 225, 15, 210, 30);

		g2.setColor(Color.BLACK);
		g2.drawRect(15, 15, 210, 30);
		g2.drawRect(1000 - 225, 15, 210, 30);

		g2.setColor(Color.RED);
		g2.fillRect(20, 20, length1, 20);
		g2.fillRect(1000 - 20 - length2, 20, length2, 20);

		g2.setColor(Color.BLACK);
		g2.drawRect(20, 20, 200, 20);
		g2.drawRect(1000 - 220, 20, 200, 20);

		g2.setColor(new Color(100, 200, 230));
		if (gp.player1.atkC > 0) {
			g2.fillRect(20, 50, length3, 10);
		}
		if (gp.player2.atkC > 0) {
			g2.fillRect(1000 - 20 - length4, 50, length4, 10);
		}

	}
}
