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

public class EnemyDefencebar extends Entity {
	
		public static float x, y;
	
	public EnemyDefencebar(Handler handler, float x, float y) {
		super(handler, x, y);
		this.x=x;
		this.y=y;
	}
	
	public void tick(){
		 
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color (98, 244, 155));
		g.fillRect((int) x, (int) y, (int) (Enemy.defence/10), 10);
		g.drawRect((int) x, (int) y, 300, 10);
	}
 
}