package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean leftPressedR, rightPressedR, kickPressedR, jabR, crossR, blockR, duckR, uppercutR, specialMoveR;
	public boolean leftPressedL, rightPressedL, kickPressedL, jabL, crossL, blockL, duckL, uppercutL, specialMoveL;

	public boolean enterPressed,escapePressed;
	public boolean gPressed;
	public boolean onePressed, twoPressed, threePressed, fourPressed;
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		// L
		if (code == KeyEvent.VK_A) {
			leftPressedL = true;
		}
		if (code == KeyEvent.VK_D) {
			rightPressedL = true;
		}
		if (code == KeyEvent.VK_S) {
			duckL = true;
		}
		if (code == KeyEvent.VK_W) {
			blockL = true;
		}
		if (code == KeyEvent.VK_E) {
			jabL = true;
		}
		if (code == KeyEvent.VK_Q) {
			crossL = true;
		}
		if (code == KeyEvent.VK_X) {
			uppercutL = true;
		}
		if (code == KeyEvent.VK_Z) {
			kickPressedL = true;
		}
		
		// R
		if (code == KeyEvent.VK_LEFT) {
			leftPressedR = true;
		}
		if (code == KeyEvent.VK_RIGHT) {
			rightPressedR = true;
		}
		if (code == KeyEvent.VK_DOWN) {
			duckR = true;
		}
		if (code == KeyEvent.VK_UP) {
			blockR = true;
		}
		if (code == KeyEvent.VK_P) {
			jabR = true;
		}
		if (code == KeyEvent.VK_O) {
			crossR = true;
		}
		if (code == KeyEvent.VK_I) {
			uppercutR = true;
		}
		if (code == KeyEvent.VK_U) {
			kickPressedR = true;
		}
				
		
		if (code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}
		if (code == KeyEvent.VK_ESCAPE) {
			escapePressed = true;
		}
		if (code == KeyEvent.VK_G) {
			gPressed = true;
		}
		if (code == KeyEvent.VK_1) {
			onePressed = true;
		}
		if (code == KeyEvent.VK_2) {
			twoPressed = true;
		}
		if (code == KeyEvent.VK_3) {
			threePressed = true;
		}
		if (code == KeyEvent.VK_4) {
			fourPressed = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		// L
		if (code == KeyEvent.VK_A) {
			leftPressedL = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressedL = false;
		}
		if (code == KeyEvent.VK_S) {
			duckL = false;
		}
		if (code == KeyEvent.VK_W) {
			blockL = false;
		}
		if (code == KeyEvent.VK_E) {
			jabL = false;
		}
		if (code == KeyEvent.VK_Q) {
			crossL = false;
		}
		if (code == KeyEvent.VK_X) {
			uppercutL = false;
		}
		if (code == KeyEvent.VK_Z) {
			kickPressedL = false;
		}
		
		// R
		if (code == KeyEvent.VK_LEFT) {
			leftPressedR = false;
		}
		if (code == KeyEvent.VK_RIGHT) {
			rightPressedR = false;
		}
		if (code == KeyEvent.VK_DOWN) {
			duckR = false;
		}
		if (code == KeyEvent.VK_UP) {
			blockR = false;
		}
		if (code == KeyEvent.VK_P) {
			jabR = false;
		}
		if (code == KeyEvent.VK_O) {
			crossR = false;
		}
		if (code == KeyEvent.VK_I) {
			uppercutR = false;
		}
		if (code == KeyEvent.VK_U) {
			kickPressedR = false;
		}
		
		
		if (code == KeyEvent.VK_ENTER) {
			enterPressed = false;
		}
		if (code == KeyEvent.VK_ESCAPE) {
			escapePressed = false;
		}
		if (code == KeyEvent.VK_G) {
			gPressed = false;
		}
		if (code == KeyEvent.VK_1) {
			onePressed = false;
		}
		if (code == KeyEvent.VK_2) {
			twoPressed = false;
		}
		if (code == KeyEvent.VK_3) {
			threePressed = false;
		}
		if (code == KeyEvent.VK_4) {
			fourPressed = false;
		}
	}
}
