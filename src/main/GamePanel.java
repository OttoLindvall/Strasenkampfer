package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import ai.NeuralNetwork;
import objects.Background;
import objects.Player;
import objects.Sound;

public class GamePanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int FPS = 60;

	int soundW;
	boolean startMusic = true;

	KeyHandler keyH = new KeyHandler();

	public Thread gameThread;

	public Player player1 = new Player(0, this, keyH);
	public Player player2 = new Player(1, this, keyH);
	public Sound sound = new Sound();
	public UI ui = new UI(this);
	public Menu menu = new Menu(this, keyH);
	public Background background1 = new Background("testBg3");
	public NeuralNetwork ai1 = new NeuralNetwork(0, this, keyH);
	public NeuralNetwork ai2 = new NeuralNetwork(1, this, keyH);

	public GamePanel() {
		this.setPreferredSize(new Dimension(1000, 600));
		this.setBackground(new Color(0, 0, 0));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);

	}

	public void startGameThread() {

		gameThread = new Thread(this);
		gameThread.start();
	}

	public void setupGame() {
		player1.pickC("");
		player2.pickC("");
	}

	@Override
	public void run() {

//		if (Player.aiTraining == true) {
//			FPS = 1000000;
//		}

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while (gameThread != null) {

			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;

			lastTime = currentTime;

			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}
		}
	}

	public void update() {
		if (menu.menu == false) {
			if (startMusic == true) {
				sound.playMusic(10);
				startMusic = false;
			}
			player1.update();
			player2.update();
			attackS();
		} else if (menu.menu == true) {
			menu.update();
		}
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		background1.draw(g2);

		if (menu.menu == false) {
//			if (Player.aiTraining == false) {
			player1.draw(g2);
			player2.draw(g2);
//			}
			ui.draw(g2);
		} else if (menu.menu == true) {
//			if (Player.aiTraining == false) {
			menu.draw(g2);
//			}
		}

		g2.dispose();
	}

	public void attackS() {

		soundW = (int) (Math.random() * 3);

		if (player1.dmgC == true) {
			switch (player1.action) {
			case "jab":
				if (Math.abs(player1.x - player2.x) < 155) {
					if (player2.action != "block" && player1.spriteNum == 4) {
						player2.hp -= player1.jabDmg;
						player1.dmgC = false;
						player2.atkCR -= 5;
						sound.playSound(soundW);
					} else if (player2.action == "block") {
						player2.atkCR += 5;
						player1.dmgC = false;
					}
				}
				break;
			case "cross":
				if (Math.abs(player1.x - player2.x) < 155) {
					if (player2.action != "block" && player1.spriteNum == 4) {
						player2.hp -= player1.crossDmg;
						player1.dmgC = false;
						player2.atkCR -= 5;
						sound.playSound(soundW);
					} else if (player2.action == "block") {
						player2.atkCR += 5;
						player1.dmgC = false;
					}
				}
				break;
			case "uppercut":
				if (Math.abs(player1.x - player2.x) < 125) {
					if (player2.action != "duck" && player1.spriteNum == 5) {
						player2.hp -= player1.uppercutDmg;
						player1.dmgC = false;
						player2.atkCR -= 5;
						sound.playSound(soundW);
					} else if (player2.action == "duck") {
						player2.atkCR += 5;
						player1.dmgC = false;
					}
				}
				break;
			case "kick":
				if (Math.abs(player1.x - player2.x) < 125) {
					if (player2.action != "duck" && player1.spriteNum == 6) {
						player2.hp -= player1.kickDmg;
						player1.dmgC = false;
						player2.atkCR -= 5;
						sound.playSound(soundW);
					} else if (player2.action == "duck") {
						player2.atkCR += 5;
						player1.dmgC = false;
					}
				}
				if (player1.spriteNum == 6 && player2.x + 200 < 650) {
					player2.x += 200;
//					player2.atkC += 150;
				} else if (player1.spriteNum == 6 && player2.x + 200 > 650) {
					player2.x = 625;
				}
				break;
			}
		}

		if (player2.dmgC == true) {
			switch (player2.action) {
			case "jab":
				if (Math.abs(player1.x - player2.x) < 155) {
					if (player1.action != "block" && player2.spriteNum == 4) {
						player1.hp -= player2.jabDmg;
						player2.dmgC = false;
						player1.atkCR -= 5;
						sound.playSound(soundW);
					} else if (player1.action == "block") {
						player1.atkCR += 5;
						player2.dmgC = false;
					}

				}
				break;
			case "cross":
				if (Math.abs(player1.x - player2.x) < 155) {
					if (player1.action != "block" && player2.spriteNum == 4) {
						player1.hp -= player2.crossDmg;
						player2.dmgC = false;
						player1.atkCR -= 5;
						sound.playSound(soundW);
					} else if (player1.action == "block") {
						player1.atkCR += 5;
						player2.dmgC = false;
					}

				}
				break;
			case "uppercut":
				if (Math.abs(player1.x - player2.x) < 125) {
					if (player1.action != "duck" && player2.spriteNum == 5) {
						player1.hp -= player2.uppercutDmg;
						player2.dmgC = false;
						player1.atkCR -= 5;
						sound.playSound(soundW);
					} else if (player1.action == "duck") {
						player1.atkCR += 5;
						player2.dmgC = false;
					}
				}
				break;
			case "kick":
				if (Math.abs(player1.x - player2.x) < 125) {
					if (player1.action != "duck" && player2.spriteNum == 6) {
						player1.hp -= player2.kickDmg;
						player2.dmgC = false;
						player1.atkCR -= 5;
						sound.playSound(soundW);
					} else if (player1.action == "duck") {
						player1.atkCR += 5;
						player2.dmgC = false;
					}
					if (player2.spriteNum == 6 && player1.x - 200 > 0) {
						player1.x -= 200;
//						player1.atkC += 150;
					} else if (player2.spriteNum == 6 && player1.x - 200 <= 0) {
						player1.x = 0;
					}
				}
				break;
			}
		}
	}
}