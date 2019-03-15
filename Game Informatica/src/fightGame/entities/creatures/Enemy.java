package fightGame.entities.creatures;

import java.awt.Graphics;

import fightGame.graphics.Assets;


public class Enemy extends Creature {


	public Enemy(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.enemy, (int) x, (int) y, 100, 100, null);
	}

}
