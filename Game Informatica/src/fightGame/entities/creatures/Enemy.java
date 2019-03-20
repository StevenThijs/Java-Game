package fightGame.entities.creatures;

import java.awt.Graphics;

import fightGame.graphics.Animation;
import fightGame.graphics.Assets;


public class Enemy extends Creature {
	
	private Animation Thonk;

	public Enemy(float x, float y) {
		super(x, y);
		
		Thonk= new Animation(100/6, Assets.testAnimatie);
		
	}
	

	@Override
	public void tick() {
		Thonk.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Thonk.getCurrentFrame(), (int) x, (int) y, 100, 100, null);
		g.drawImage(Assets.enemy, 400, 400, 300, 300, null);
		
		
		
	}

}
