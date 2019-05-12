package fightGame.entities.creatures;

import fightGame.Handler;
import fightGame.entities.Entity;

public abstract class Creature extends Entity {
	
	public static float health;

	public Creature(Handler handler, float x, float y) {
		super(handler, x, y);
		this.x=x;
		this.y=y;
	}
	
}
