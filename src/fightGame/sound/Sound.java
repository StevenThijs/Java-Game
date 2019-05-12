package fightGame.sound;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class Sound {
	public static synchronized void playSound(final String url) {
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		    
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		        		new File("res/Sounds/" + url));
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
		    }
		  }).start();
	}
	  

}