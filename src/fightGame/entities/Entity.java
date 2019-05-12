package fightGame.entities;

import java.awt.Graphics;

import fightGame.Handler;

public abstract class Entity {

	public float x, y;
	protected Handler handler;
	
	public Entity(Handler handler, float x, float y){
		this.handler = handler;

	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}