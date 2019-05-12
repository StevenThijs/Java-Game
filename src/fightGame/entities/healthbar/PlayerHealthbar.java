package fightGame.entities.healthbar;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import fightGame.Handler;
import fightGame.entities.Entity;
import fightGame.entities.creatures.Enemy;
import fightGame.entities.creatures.SnakeDoctor;

public class PlayerHealthbar extends Entity {
	
	public static float x, y;
	
	public PlayerHealthbar(Handler handler, float x, float y) {
		super(handler, x, y);
		this.x= x;
		this.y= y;
	}
	
	public void tick(){
		 
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, (int) (SnakeDoctor.health/1.5), 10);
		g.drawRect((int) x, (int) y, (int) (500/1.5), 10);
		//if (Enemy.class )
	}
 
}