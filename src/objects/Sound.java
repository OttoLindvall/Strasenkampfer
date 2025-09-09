package objects;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	Clip clip;
	URL soundURL[] = new URL[20];

	public void addSound(String fileName, int soundNum) {
		String filePath = "Sound";
		soundURL[soundNum] = getClass().getResource("/" + filePath + "/" + fileName + ".wav");
	}

	public Sound() {
		addSound("AAA", 0);
		addSound("AOCH", 1);
		addSound("OOF", 2);
		addSound("music",10);
		addSound("SFI", 3);
	}

	public void setFile(int soundNum) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[soundNum]);
			clip = AudioSystem.getClip();
			clip.open(ais);

		} catch (Exception e) {
		}
	}

	public void play() {
		clip.start();
	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void playSound(int soundNum2) {
		setFile(soundNum2);
		play();
	}
	public void playMusic(int musicNum) {
		setFile(musicNum);
		play();
		loop();
	}
}