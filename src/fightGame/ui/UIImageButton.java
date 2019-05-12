package fightGame.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

	private BufferedImage[] images;
	private ClickListener clicker;
	private boolean disabled;
	private int width, height;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		this.width= width;
		this.height= height;

	}

	@Override
	public void tick() {}
		
	@Override
	public void render(Graphics g) {
		if(hovering)
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		else
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}