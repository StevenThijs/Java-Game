package fightGame.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage enemy, test, landscape;
	public static BufferedImage[] testAnimatie;
	
	public static void init() {
		enemy= ImageLoader.loadImage("/textures/enemy.png");
		test= ImageLoader.loadImage("/textures/hmmm.gif");
		
		landscape= ImageLoader.loadImage("/textures/landscape.jpg");
		
		testAnimatie= new BufferedImage[30];
		for (int i=0; i < 30; i++) {
			System.out.println(i);
			testAnimatie[i]= ImageLoader.loadImage("/TestAnimatie/hmmm.0.png");
		}
		
		
	}
}

