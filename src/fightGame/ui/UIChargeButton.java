package fightGame.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fightGame.entities.creatures.SnakeDoctor;
import fightGame.states.GameState;
import fightGame.states.MenuState;

public class UIChargeButton extends UIObject {
	
	public int coolDown, width, height, coolDownTime;
	private BufferedImage[] images;
	private ClickListener clicker;
	private boolean disabled, keepDisabled= false;
	
	public UIChargeButton(float x, float y, int width, int height, BufferedImage[] images, int coolDownTime, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		this.width= width;
		this.height= height;
		this.coolDownTime= coolDownTime;
	}
	
	@Override
	public void tick() {
		if (keepDisabled== true) {
			return; 
			}
		if (coolDown>0)
			disabled= true;
		else if (true)
			disabled= false;
		
	}
		
	@Override
	public void render(Graphics g) {
		if (disabled)
			g.drawImage(images[2], (int) x, (int) y, width, height, null);
		else if(hovering)
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		else
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		if (coolDown<1) {
		clicker.onClick();
		coolDown+=coolDownTime+MenuState.difficulty;
		}
		
	}
	
	public void Cool() {
		if (coolDown>0)
		coolDown--;
	}

	public void setDisabled(boolean b) {
		disabled= b;
		keepDisabled=b;
	};
		
	}

