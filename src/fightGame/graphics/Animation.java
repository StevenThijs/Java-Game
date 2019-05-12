package fightGame.graphics;

import java.awt.image.BufferedImage;

public class Animation {
	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	private boolean loop;
	
	public Animation(int speed, BufferedImage[] frames, boolean loop) {
		this.speed= speed;
		this.frames= frames;
		this.loop= loop;
		index= 0;
		timer= 0;
		lastTime= System.currentTimeMillis();
	}
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer>speed) {
			timer=0;
			if (index+1 >= frames.length && loop== false)
				return;
			index++;
			if(index >= frames.length && loop== true) 
				index=0;
			

		} 
	}
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
	
	public void setCurrentFrame(int i) {
		index= i;
	}
}
