package objects;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

	public int left;

	public int hp;
	public int maxHp;

	public int jabDmg;
	public int crossDmg;
	public int uppercutDmg;
	public int kickDmg;

	public int SMdmg;
	public int SMdmgC;

	public int atkC;
	public int atkCR;
	public int atkCMax;

	public String name;

	public int speed;

	public int x;
	public int y;
	
	public boolean dmgC = true;

	public String action = "neutral";

	public int spriteCounter;
	public int spriteNum;
	public int spriteType;
	public int characterNum;
	public int spriteMax;

	public boolean actionC;

	public BufferedImage[][][][] imageList = new BufferedImage[3][2][10][40];

	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
}
