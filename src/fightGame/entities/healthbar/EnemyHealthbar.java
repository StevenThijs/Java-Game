package fightGame.entities.healthbar;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import fightGame.Handler;
import fightGame.entities.Entity;
import fightGame.entities.creatures.Enemy;
import fightGame.states.GameState;
import fightGame.states.MenuState;

public class EnemyHealthbar extends Entity {
	
		public static float x, y;
	
	public EnemyHealthbar(Handler handler, float x, float y) {
		super(handler, x, y);
		this.x=x;
		this.y=y;
	}
	
	public void tick(){
		 
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, (int) (Enemy.health/200), 10);
		g.drawRect((int) x, (int) y, (int) ((600+100*MenuState.getDifficulty())/300), 10);
	}
 
}