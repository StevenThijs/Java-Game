package fightGame.states;
import java.awt.Graphics;

import fightGame.display.Display;
import fightGame.entities.creatures.Enemy;
import fightGame.graphics.Assets;



public class GameState extends State {
	 
	private Enemy enemy;
	
	public GameState(){
		 enemy= new Enemy(100, 500);
	}
	
	@Override
	public void tick() {
		enemy.tick();
	}

	@Override
	public void render(Graphics g) {


		g.drawImage(Assets.landscape, 0, 0, Display.getWindowWidth(), Display.getWindowHeigth(), null);
		enemy.render(g);

		

	}

}