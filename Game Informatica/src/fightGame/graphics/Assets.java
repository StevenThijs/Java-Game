package fightGame.graphics;

import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage enemy, test, landscape;
	
	public static void init() {
		enemy= ImageLoader.loadImage("/textures/hmmm.gif");
		test= ImageLoader.loadImage("/textures/snakeBasic.png");
		landscape= ImageLoader.loadImage("/textures/landscape.jpg");
	}
}
