package fightGame.states;
import java.awt.Graphics;

import fightGame.display.Display;
import fightGame.entities.creatures.Enemy;
import fightGame.entities.healthbar.EnemyHealthbar;
import fightGame.graphics.Assets;



public class GameState extends State {
	 
	private Enemy enemy;
	private EnemyHealthbar enemyHealthbar;
	
			public GameState(){
		 enemy= new Enemy(Display.getWindowWidth()-200, 500);
		 enemyHealthbar= new EnemyHealthbar(Display.getWindowWidth()-400, Display.getWindowHeigth()-50);
	}
	
	@Override
	public void tick() {
		enemy.tick();
		enemyHealthbar.tick();
	}

	@Override
	public void render(Graphics g) {


		g.drawImage(Assets.landscape, 0, 0, Display.getWindowWidth(), Display.getWindowHeigth(), null);
		enemy.render(g);
		enemyHealthbar.render(g);
		

	}

}