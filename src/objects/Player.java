package objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;

	static public boolean ai1 = false;
	static public boolean ai2 = false;

//	static public boolean aiTraining = false;
//	static public int aiTrainingTimer = 0;
//	static public boolean printOne = false;

	public Player(int left, GamePanel gp, KeyHandler keyH) {
		this.left = left;
		this.gp = gp;
		this.keyH = keyH;
		setDefaultValues();
	}

	public void setDefaultValues() {
		if (left == 0) {
			x = 100;
			y = 100;
		} else {
			x = 350;
			y = 100;
		}
		action = "neutral";
	}

	public void pickC(String name) {

		this.name = name;

		switch (name) {
		case "Otto":
			maxHp = 450;
			hp = maxHp;
			speed = 6;
			atkCR = 0;
			atkC = 0;
			characterNum = 0;
			jabDmg = 20;
			crossDmg = 30;
			uppercutDmg = 55;
			kickDmg = 40;
			break;
		case "Axel":
			maxHp = 600;
			hp = maxHp;
			speed = 5;
			atkCR = 0;
			atkC = 0;
			characterNum = 1;
			jabDmg = 15;
			crossDmg = 20;
			uppercutDmg = 35;
			kickDmg = 60;
			break;
		}
	}

	public void loadImage(String picture, int list, int left, int spriteType, int spritenum) {
		String filePath = "";
		try {
			switch (list) {
			case 0:
				filePath = "Otto";
				break;
			case 1:
				filePath = "Axel";
				break;
			}
			imageList[list][left][spriteType][spritenum] = ImageIO
					.read(getClass().getResourceAsStream("/" + filePath + "/" + picture + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void getPlayerImageOL() {

		loadImage("OttoNeutral_L_1", 0, 0, 0, 3);
		loadImage("OttoNeutral_L_2", 0, 0, 0, 2);
		loadImage("OttoNeutral_L_3", 0, 0, 0, 1);
		loadImage("OttoNeutral_L_2", 0, 0, 0, 0);

		loadImage("OttoGå_L_1", 0, 0, 1, 4);
		loadImage("OttoGå_L_2", 0, 0, 1, 3);
		loadImage("OttoGå_L_3", 0, 0, 1, 2);
		loadImage("OttoGå_L_4", 0, 0, 1, 1);
		loadImage("OttoGå_L_5", 0, 0, 1, 0);

		loadImage("OttoGå_L_5", 0, 0, 2, 4);
		loadImage("OttoGå_L_4", 0, 0, 2, 3);
		loadImage("OttoGå_L_3", 0, 0, 2, 2);
		loadImage("OttoGå_L_2", 0, 0, 2, 1);
		loadImage("OttoGå_L_1", 0, 0, 2, 0);

		loadImage("OttoJab_L_1", 0, 0, 3, 7);
		loadImage("OttoJab_L_2", 0, 0, 3, 6);
		loadImage("OttoJab_L_3", 0, 0, 3, 5);
		loadImage("OttoJab_L_4", 0, 0, 3, 4);
		loadImage("OttoJab_L_4", 0, 0, 3, 3);
		loadImage("OttoJab_L_3", 0, 0, 3, 2);
		loadImage("OttoJab_L_2", 0, 0, 3, 1);
		loadImage("OttoJab_L_1", 0, 0, 3, 0);

		loadImage("OttoCross_L_1", 0, 0, 4, 7);
		loadImage("OttoCross_L_2", 0, 0, 4, 6);
		loadImage("OttoCross_L_3", 0, 0, 4, 5);
		loadImage("OttoCross_L_4", 0, 0, 4, 4);
		loadImage("OttoCross_L_4", 0, 0, 4, 3);
		loadImage("OttoCross_L_3", 0, 0, 4, 2);
		loadImage("OttoCross_L_2", 0, 0, 4, 1);
		loadImage("OttoCross_L_1", 0, 0, 4, 0);

		loadImage("OttoSpark_L_1", 0, 0, 5, 11);
		loadImage("OttoSpark_L_2", 0, 0, 5, 10);
		loadImage("OttoSpark_L_3", 0, 0, 5, 9);
		loadImage("OttoSpark_L_4", 0, 0, 5, 8);
		loadImage("OttoSpark_L_5", 0, 0, 5, 7);
		loadImage("OttoSpark_L_6", 0, 0, 5, 6);
		loadImage("OttoSpark_L_6", 0, 0, 5, 5);
		loadImage("OttoSpark_L_5", 0, 0, 5, 4);
		loadImage("OttoSpark_L_4", 0, 0, 5, 3);
		loadImage("OttoSpark_L_3", 0, 0, 5, 2);
		loadImage("OttoSpark_L_2", 0, 0, 5, 1);
		loadImage("OttoSpark_L_1", 0, 0, 5, 0);

		loadImage("OttoUppercut_L_1", 0, 0, 6, 9);
		loadImage("OttoUppercut_L_2", 0, 0, 6, 8);
		loadImage("OttoUppercut_L_3", 0, 0, 6, 7);
		loadImage("OttoUppercut_L_4", 0, 0, 6, 6);
		loadImage("OttoUppercut_L_5", 0, 0, 6, 5);
		loadImage("OttoUppercut_L_5", 0, 0, 6, 4);
		loadImage("OttoUppercut_L_4", 0, 0, 6, 3);
		loadImage("OttoUppercut_L_3", 0, 0, 6, 2);
		loadImage("OttoUppercut_L_2", 0, 0, 6, 1);
		loadImage("OttoUppercut_L_1", 0, 0, 6, 0);

		loadImage("OttoDuck_L_1", 0, 0, 7, 9);
		loadImage("OttoDuck_L_2", 0, 0, 7, 8);
		loadImage("OttoDuck_L_3", 0, 0, 7, 7);
		loadImage("OttoDuck_L_4", 0, 0, 7, 6);
		loadImage("OttoDuck_L_5", 0, 0, 7, 5);
		loadImage("OttoDuck_L_5", 0, 0, 7, 4);
		loadImage("OttoDuck_L_4", 0, 0, 7, 3);
		loadImage("OttoDuck_L_3", 0, 0, 7, 2);
		loadImage("OttoDuck_L_2", 0, 0, 7, 1);
		loadImage("OttoDuck_L_1", 0, 0, 7, 0);

		loadImage("OttoBlock_L_1", 0, 0, 8, 6);
		loadImage("OttoBlock_L_2", 0, 0, 8, 5);
		loadImage("OttoBlock_L_2", 0, 0, 8, 4);
		loadImage("OttoBlock_L_2", 0, 0, 8, 3);
		loadImage("OttoBlock_L_2", 0, 0, 8, 2);
		loadImage("OttoBlock_L_1", 0, 0, 8, 1);
		loadImage("OttoBlock_L_1", 0, 0, 8, 0);

	}

	public void getPlayerImageOR() {

		loadImage("OttoNeutral_R_1", 0, 1, 0, 3);
		loadImage("OttoNeutral_R_2", 0, 1, 0, 2);
		loadImage("OttoNeutral_R_3", 0, 1, 0, 1);
		loadImage("OttoNeutral_R_2", 0, 1, 0, 0);

		loadImage("OttoGå_R_1", 0, 1, 1, 4);
		loadImage("OttoGå_R_2", 0, 1, 1, 3);
		loadImage("OttoGå_R_3", 0, 1, 1, 2);
		loadImage("OttoGå_R_4", 0, 1, 1, 1);
		loadImage("OttoGå_R_5", 0, 1, 1, 0);

		loadImage("OttoGå_R_5", 0, 1, 2, 4);
		loadImage("OttoGå_R_4", 0, 1, 2, 3);
		loadImage("OttoGå_R_3", 0, 1, 2, 2);
		loadImage("OttoGå_R_2", 0, 1, 2, 1);
		loadImage("OttoGå_R_1", 0, 1, 2, 0);

		loadImage("OttoJab_R_1", 0, 1, 3, 7);
		loadImage("OttoJab_R_2", 0, 1, 3, 6);
		loadImage("OttoJab_R_3", 0, 1, 3, 5);
		loadImage("OttoJab_R_4", 0, 1, 3, 4);
		loadImage("OttoJab_R_4", 0, 1, 3, 3);
		loadImage("OttoJab_R_3", 0, 1, 3, 2);
		loadImage("OttoJab_R_2", 0, 1, 3, 1);
		loadImage("OttoJab_R_1", 0, 1, 3, 0);

		loadImage("OttoCross_R_1", 0, 1, 4, 7);
		loadImage("OttoCross_R_2", 0, 1, 4, 6);
		loadImage("OttoCross_R_3", 0, 1, 4, 5);
		loadImage("OttoCross_R_4", 0, 1, 4, 4);
		loadImage("OttoCross_R_4", 0, 1, 4, 3);
		loadImage("OttoCross_R_3", 0, 1, 4, 2);
		loadImage("OttoCross_R_2", 0, 1, 4, 1);
		loadImage("OttoCross_R_1", 0, 1, 4, 0);

		loadImage("OttoSpark_R_1", 0, 1, 5, 11);
		loadImage("OttoSpark_R_2", 0, 1, 5, 10);
		loadImage("OttoSpark_R_3", 0, 1, 5, 9);
		loadImage("OttoSpark_R_4", 0, 1, 5, 8);
		loadImage("OttoSpark_R_5", 0, 1, 5, 7);
		loadImage("OttoSpark_R_6", 0, 1, 5, 6);
		loadImage("OttoSpark_R_6", 0, 1, 5, 5);
		loadImage("OttoSpark_R_5", 0, 1, 5, 4);
		loadImage("OttoSpark_R_4", 0, 1, 5, 3);
		loadImage("OttoSpark_R_3", 0, 1, 5, 2);
		loadImage("OttoSpark_R_2", 0, 1, 5, 1);
		loadImage("OttoSpark_R_1", 0, 1, 5, 0);

		loadImage("OttoUppercut_R_1", 0, 1, 6, 9);
		loadImage("OttoUppercut_R_2", 0, 1, 6, 8);
		loadImage("OttoUppercut_R_3", 0, 1, 6, 7);
		loadImage("OttoUppercut_R_4", 0, 1, 6, 6);
		loadImage("OttoUppercut_R_5", 0, 1, 6, 5);
		loadImage("OttoUppercut_R_5", 0, 1, 6, 4);
		loadImage("OttoUppercut_R_4", 0, 1, 6, 3);
		loadImage("OttoUppercut_R_3", 0, 1, 6, 2);
		loadImage("OttoUppercut_R_2", 0, 1, 6, 1);
		loadImage("OttoUppercut_R_1", 0, 1, 6, 0);

		loadImage("OttoDuck_R_1", 0, 1, 7, 9);
		loadImage("OttoDuck_R_2", 0, 1, 7, 8);
		loadImage("OttoDuck_R_3", 0, 1, 7, 7);
		loadImage("OttoDuck_R_4", 0, 1, 7, 6);
		loadImage("OttoDuck_R_5", 0, 1, 7, 5);
		loadImage("OttoDuck_R_5", 0, 1, 7, 4);
		loadImage("OttoDuck_R_4", 0, 1, 7, 3);
		loadImage("OttoDuck_R_3", 0, 1, 7, 2);
		loadImage("OttoDuck_R_2", 0, 1, 7, 1);
		loadImage("OttoDuck_R_1", 0, 1, 7, 0);

		loadImage("OttoBlock_R_1", 0, 1, 8, 6);
		loadImage("OttoBlock_R_2", 0, 1, 8, 5);
		loadImage("OttoBlock_R_2", 0, 1, 8, 4);
		loadImage("OttoBlock_R_2", 0, 1, 8, 3);
		loadImage("OttoBlock_R_2", 0, 1, 8, 2);
		loadImage("OttoBlock_R_1", 0, 1, 8, 1);
		loadImage("OttoBlock_R_1", 0, 1, 8, 0);

	}

	public void getPlayerImageAL() {

		loadImage("AxelNeutral_L_1", 1, 0, 0, 3);
		loadImage("AxelNeutral_L_2", 1, 0, 0, 2);
		loadImage("AxelNeutral_L_3", 1, 0, 0, 1);
		loadImage("AxelNeutral_L_2", 1, 0, 0, 0);

		loadImage("AxelGå_L_1", 1, 0, 1, 5);
		loadImage("AxelGå_L_2", 1, 0, 1, 4);
		loadImage("AxelGå_L_3", 1, 0, 1, 3);
		loadImage("AxelGå_L_4", 1, 0, 1, 2);
		loadImage("AxelGå_L_5", 1, 0, 1, 1);
		loadImage("AxelGå_L_6", 1, 0, 1, 0);

		loadImage("AxelGå_L_6", 1, 0, 2, 5);
		loadImage("AxelGå_L_5", 1, 0, 2, 4);
		loadImage("AxelGå_L_4", 1, 0, 2, 3);
		loadImage("AxelGå_L_3", 1, 0, 2, 2);
		loadImage("AxelGå_L_2", 1, 0, 2, 1);
		loadImage("AxelGå_L_1", 1, 0, 2, 0);

		loadImage("AxelJab_L_1", 1, 0, 3, 7);
		loadImage("AxelJab_L_2", 1, 0, 3, 6);
		loadImage("AxelJab_L_3", 1, 0, 3, 5);
		loadImage("AxelJab_L_4", 1, 0, 3, 4);
		loadImage("AxelJab_L_4", 1, 0, 3, 3);
		loadImage("AxelJab_L_3", 1, 0, 3, 2);
		loadImage("AxelJab_L_2", 1, 0, 3, 1);
		loadImage("AxelJab_L_1", 1, 0, 3, 0);

		loadImage("AxelCross_L_1", 1, 0, 4, 7);
		loadImage("AxelCross_L_2", 1, 0, 4, 6);
		loadImage("AxelCross_L_3", 1, 0, 4, 5);
		loadImage("AxelCross_L_4", 1, 0, 4, 4);
		loadImage("AxelCross_L_4", 1, 0, 4, 3);
		loadImage("AxelCross_L_3", 1, 0, 4, 2);
		loadImage("AxelCross_L_2", 1, 0, 4, 1);
		loadImage("AxelCross_L_1", 1, 0, 4, 0);

		loadImage("AxelSpark_L_1", 1, 0, 5, 11);
		loadImage("AxelSpark_L_2", 1, 0, 5, 10);
		loadImage("AxelSpark_L_3", 1, 0, 5, 9);
		loadImage("AxelSpark_L_4", 1, 0, 5, 8);
		loadImage("AxelSpark_L_5", 1, 0, 5, 7);
		loadImage("AxelSpark_L_6", 1, 0, 5, 6);
		loadImage("AxelSpark_L_6", 1, 0, 5, 5);
		loadImage("AxelSpark_L_5", 1, 0, 5, 4);
		loadImage("AxelSpark_L_4", 1, 0, 5, 3);
		loadImage("AxelSpark_L_3", 1, 0, 5, 2);
		loadImage("AxelSpark_L_2", 1, 0, 5, 1);
		loadImage("AxelSpark_L_1", 1, 0, 5, 0);

		loadImage("AxelUppercut_L_1", 1, 0, 6, 9);
		loadImage("AxelUppercut_L_2", 1, 0, 6, 8);
		loadImage("AxelUppercut_L_3", 1, 0, 6, 7);
		loadImage("AxelUppercut_L_4", 1, 0, 6, 6);
		loadImage("AxelUppercut_L_5", 1, 0, 6, 5);
		loadImage("AxelUppercut_L_5", 1, 0, 6, 4);
		loadImage("AxelUppercut_L_4", 1, 0, 6, 3);
		loadImage("AxelUppercut_L_3", 1, 0, 6, 2);
		loadImage("AxelUppercut_L_2", 1, 0, 6, 1);
		loadImage("AxelUppercut_L_1", 1, 0, 6, 0);

		loadImage("AxelDuck_L_1", 1, 0, 7, 9);
		loadImage("AxelDuck_L_2", 1, 0, 7, 8);
		loadImage("AxelDuck_L_3", 1, 0, 7, 7);
		loadImage("AxelDuck_L_4", 1, 0, 7, 6);
		loadImage("AxelDuck_L_5", 1, 0, 7, 5);
		loadImage("AxelDuck_L_5", 1, 0, 7, 4);
		loadImage("AxelDuck_L_4", 1, 0, 7, 3);
		loadImage("AxelDuck_L_3", 1, 0, 7, 2);
		loadImage("AxelDuck_L_2", 1, 0, 7, 1);
		loadImage("AxelDuck_L_1", 1, 0, 7, 0);

		loadImage("AxelBlock_L_1", 1, 0, 8, 6);
		loadImage("AxelBlock_L_2", 1, 0, 8, 5);
		loadImage("AxelBlock_L_3", 1, 0, 8, 4);
		loadImage("AxelBlock_L_3", 1, 0, 8, 3);
		loadImage("AxelBlock_L_3", 1, 0, 8, 2);
		loadImage("AxelBlock_L_2", 1, 0, 8, 1);
		loadImage("AxelBlock_L_1", 1, 0, 8, 0);

	}

	public void getPlayerImageAR() {

		loadImage("AxelNeutral_R_1", 1, 1, 0, 3);
		loadImage("AxelNeutral_R_2", 1, 1, 0, 2);
		loadImage("AxelNeutral_R_3", 1, 1, 0, 1);
		loadImage("AxelNeutral_R_2", 1, 1, 0, 0);

		loadImage("AxelGå_R_1", 1, 1, 1, 5);
		loadImage("AxelGå_R_2", 1, 1, 1, 4);
		loadImage("AxelGå_R_3", 1, 1, 1, 3);
		loadImage("AxelGå_R_4", 1, 1, 1, 2);
		loadImage("AxelGå_R_5", 1, 1, 1, 1);
		loadImage("AxelGå_R_6", 1, 1, 1, 0);

		loadImage("AxelGå_R_6", 1, 1, 2, 5);
		loadImage("AxelGå_R_5", 1, 1, 2, 4);
		loadImage("AxelGå_R_4", 1, 1, 2, 3);
		loadImage("AxelGå_R_3", 1, 1, 2, 2);
		loadImage("AxelGå_R_2", 1, 1, 2, 1);
		loadImage("AxelGå_R_1", 1, 1, 2, 0);

		loadImage("AxelJab_R_1", 1, 1, 3, 7);
		loadImage("AxelJab_R_2", 1, 1, 3, 6);
		loadImage("AxelJab_R_3", 1, 1, 3, 5);
		loadImage("AxelJab_R_4", 1, 1, 3, 4);
		loadImage("AxelJab_R_4", 1, 1, 3, 3);
		loadImage("AxelJab_R_3", 1, 1, 3, 2);
		loadImage("AxelJab_R_2", 1, 1, 3, 1);
		loadImage("AxelJab_R_1", 1, 1, 3, 0);

		loadImage("AxelCross_R_1", 1, 1, 4, 7);
		loadImage("AxelCross_R_2", 1, 1, 4, 6);
		loadImage("AxelCross_R_3", 1, 1, 4, 5);
		loadImage("AxelCross_R_4", 1, 1, 4, 4);
		loadImage("AxelCross_R_4", 1, 1, 4, 3);
		loadImage("AxelCross_R_3", 1, 1, 4, 2);
		loadImage("AxelCross_R_2", 1, 1, 4, 1);
		loadImage("AxelCross_R_1", 1, 1, 4, 0);

		loadImage("AxelSpark_R_1", 1, 1, 5, 11);
		loadImage("AxelSpark_R_2", 1, 1, 5, 10);
		loadImage("AxelSpark_R_3", 1, 1, 5, 9);
		loadImage("AxelSpark_R_4", 1, 1, 5, 8);
		loadImage("AxelSpark_R_5", 1, 1, 5, 7);
		loadImage("AxelSpark_R_6", 1, 1, 5, 6);
		loadImage("AxelSpark_R_6", 1, 1, 5, 5);
		loadImage("AxelSpark_R_5", 1, 1, 5, 4);
		loadImage("AxelSpark_R_4", 1, 1, 5, 3);
		loadImage("AxelSpark_R_3", 1, 1, 5, 2);
		loadImage("AxelSpark_R_2", 1, 1, 5, 1);
		loadImage("AxelSpark_R_1", 1, 1, 5, 0);

		loadImage("AxelUppercut_R_1", 1, 1, 6, 9);
		loadImage("AxelUppercut_R_2", 1, 1, 6, 8);
		loadImage("AxelUppercut_R_3", 1, 1, 6, 7);
		loadImage("AxelUppercut_R_4", 1, 1, 6, 6);
		loadImage("AxelUppercut_R_5", 1, 1, 6, 5);
		loadImage("AxelUppercut_R_5", 1, 1, 6, 4);
		loadImage("AxelUppercut_R_4", 1, 1, 6, 3);
		loadImage("AxelUppercut_R_3", 1, 1, 6, 2);
		loadImage("AxelUppercut_R_2", 1, 1, 6, 1);
		loadImage("AxelUppercut_R_1", 1, 1, 6, 0);

		loadImage("AxelDuck_R_1", 1, 1, 7, 9);
		loadImage("AxelDuck_R_2", 1, 1, 7, 8);
		loadImage("AxelDuck_R_3", 1, 1, 7, 7);
		loadImage("AxelDuck_R_4", 1, 1, 7, 6);
		loadImage("AxelDuck_R_5", 1, 1, 7, 5);
		loadImage("AxelDuck_R_5", 1, 1, 7, 4);
		loadImage("AxelDuck_R_4", 1, 1, 7, 3);
		loadImage("AxelDuck_R_3", 1, 1, 7, 2);
		loadImage("AxelDuck_R_2", 1, 1, 7, 1);
		loadImage("AxelDuck_R_1", 1, 1, 7, 0);

		loadImage("AxelBlock_R_1", 1, 1, 8, 6);
		loadImage("AxelBlock_R_2", 1, 1, 8, 5);
		loadImage("AxelBlock_R_3", 1, 1, 8, 4);
		loadImage("AxelBlock_R_3", 1, 1, 8, 3);
		loadImage("AxelBlock_R_3", 1, 1, 8, 2);
		loadImage("AxelBlock_R_2", 1, 1, 8, 1);
		loadImage("AxelBlock_R_1", 1, 1, 8, 0);

	}

	public void spriteC() {

		spriteCounter++;

		if (spriteCounter > 7 && spriteNum > 0) {
			spriteNum--;
			spriteCounter = 0;
		} else if (spriteNum <= 0) {
			actionC = true;
			dmgC = true;
			neutral();
		}
	}

	public void update() {
		spriteC();

//		if (aiTraining == false) {
			if (left == 0 && ai1 == false) {

				if (actionC == true) {

					if (keyH.leftPressedL == true) {
						walkBack();
					}
					if (keyH.rightPressedL == true) {
						walkForward();
					}
					if (keyH.duckL == true) {
						duck();
					}
					if (keyH.blockL == true) {
						block();
					}
					if (atkC <= 0) {
						if (keyH.jabL == true) {
							jab();
						}
						if (keyH.crossL == true) {
							cross();
						}
						if (keyH.kickPressedL == true) {
							kick();
						}
						if (keyH.uppercutL == true) {
							uppercut();
						}
					}
				}
			} else if (left == 1 && ai2 == false) {

				if (actionC == true) {
					if (keyH.leftPressedR == true) {
						walkForward();
					}
					if (keyH.rightPressedR == true) {
						walkBack();
					}
					if (keyH.duckR == true) {
						duck();
					}
					if (keyH.blockR == true) {
						block();
					}
					if (atkC <= 0) {
						if (keyH.jabR == true) {
							jab();
						}
						if (keyH.crossR == true) {
							cross();
						}
						if (keyH.kickPressedR == true) {
							kick();
						}
						if (keyH.uppercutR == true) {
							uppercut();
						}
					}
				}

			}

			if (ai1 == true) {
				gp.ai1.update();
			}
			if (ai2 == true) {
				gp.ai2.update();
			}
		  /*} else if (aiTraining == true) {
			if (left == 0) {
				gp.ai1.update();
			} else if (left == 1) {
				gp.ai2.update();
			}
		}*/

		if (keyH.escapePressed == true) {
			gp.menu.menu = true;
			gp.menu.title.replayIntro();
		}

//		if (aiTraining == true) {
//			
//			aiTrainingTimer++;
//			
//			if (keyH.enterPressed == true) {
//				aiTraining = false;
//				gp.menu.menu = true;
//				gp.menu.title.replayIntro();
//			}
//		}
//
//		if (keyH.threePressed == true && printOne == false) {
//			gp.ai1.printBridge();
//			printOne = true;
//		}
//		if (keyH.fourPressed == true && printOne == false) {
//			gp.ai2.printBridge();
//			printOne = true;
//		}

		if (atkC > 0) {
			atkC--;
		}
		
		
	}

	public void draw(Graphics2D g2) {

		BufferedImage image = null;

		image = imageList[characterNum][left][spriteType][spriteNum];

		g2.drawImage(image, x, y, 450, 450, null);
	}

	// actions

	public void walkForwardControl() {
		switch (gp.player1.name) {
		case "Otto":
			switch (gp.player2.name) {
			case "Otto":
				if (left == 0 && x < 575) {
					x += speed;
				} else if (left == 1 && x > 0) {
					x -= speed;
				}
				break;
			case "Axel":
				if (left == 0 && x < 575) {
					x += speed;
				} else if (left == 1 && x > -100) {
					x -= speed;
				}
				break;
			}
			break;
		case "Axel":
			switch (gp.player2.name) {
			case "Otto":
				if (left == 0 && x < 675) {
					x += speed;
				} else if (left == 1 && x > 0) {
					x -= speed;
				}
				break;
			case "Axel":
				if (left == 0 && x < 675) {
					x += speed;
				} else if (left == 1 && x > -100) {
					x -= speed;
				}
				break;
			}
			break;
		}
	}

	public void neutral() {

		action = "neutral";
		spriteNum = 3;
		spriteType = 0;
		spriteMax = 10;

	}

	public void walkForward() {

		if (actionC == true) {
			action = "walkForward";
			spriteType = 1;
		}

		if (action == "walkForward") {
			if (gp.player1.name == "Otto" && gp.player2.name == "Otto" && gp.player2.x - gp.player1.x > -100) {
				walkForwardControl();
			} else if (gp.player1.name == "Axel" && gp.player2.name == "Axel" && gp.player2.x - gp.player1.x > 75) {
				walkForwardControl();
			} else if (gp.player1.x < gp.player2.x) {
				walkForwardControl();
			}
		}

	}

	public void walkBack() {

		if (actionC == true) {
			action = "walkBack";
			spriteType = 2;
		}

		if (action == "walkBack") {

			switch (gp.player1.name) {
			case "Otto":
				switch (gp.player2.name) {
				case "Otto":
					if (action == "walkBack") {
						if (left == 0 && x > 0) {
							x -= speed;
						} else if (left == 1 && x < 575) {
							x += speed;
						}
					}
					break;
				case "Axel":
					if (action == "walkBack") {
						if (left == 0 && x > 0) {
							x -= speed;
						} else if (left == 1 && x < 675) {
							x += speed;
						}
					}
					break;
				}
				break;
			case "Axel":
				switch (gp.player2.name) {
				case "Otto":
					if (action == "walkBack") {
						if (left == 0 && x > -100) {
							x -= speed;
						} else if (left == 1 && x < 575) {
							x += speed;
						}
					}
					break;
				case "Axel":
					if (action == "walkBack") {
						if (left == 0 && x > -100) {
							x -= speed;
						} else if (left == 1 && x < 675) {
							x += speed;
						}
					}
					break;
				}
				break;
			}
		}
	}

	public void jab() {

		action = "jab";
		spriteNum = 7;
		spriteType = 3;
		if (atkCR < 75) {
			atkC = 75 - atkCR;
		} else {
			atkC = 0;
		}
		atkCMax = atkC;
		actionC = false;
	}

	public void cross() {

		action = "cross";
		spriteNum = 7;
		spriteType = 4;
		if (atkCR < 100) {
			atkC = 100 - atkCR;
		} else {
			atkC = 0;
		}
		atkCMax = atkC;
		actionC = false;
	}

	public void kick() {

		action = "kick";
		spriteNum = 11;
		spriteType = 5;
		if (atkCR < 275) {
			atkC = 275 - atkCR;
		} else {
			atkC = 0;
		}
		atkCMax = atkC;
		actionC = false;
	}

	public void uppercut() {

		action = "uppercut";
		spriteNum = 9;
		spriteType = 6;
		if (atkCR < 250) {
			atkC = 250 - atkCR;
		} else {
			atkC = 0;
		}
		atkCMax = atkC;
		actionC = false;
	}

	public void duck() {

		action = "duck";
		spriteNum = 9;
		spriteType = 7;
		actionC = false;
	}

	public void block() {

		action = "block";
		spriteNum = 6;
		spriteType = 8;
		actionC = false;
	}
}