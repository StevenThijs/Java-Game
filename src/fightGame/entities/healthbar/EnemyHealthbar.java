package fightGame.entities.healthbar;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


import fightGame.entities.Entity;
import fightGame.entities.creatures.Enemy;

public class EnemyHealthbar extends Entity {
	

	public EnemyHealthbar(float x, float y) {
		super(x, y);
		
	}
	
	public void tick(){
		 
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, Enemy.health, 10);
		
	}
 
}