package fightGame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import fightGame.Handler;
import fightGame.display.Display;
import fightGame.entities.Entity;
import fightGame.entities.healthbar.EnemyHealthbar;
import fightGame.entities.healthbar.PlayerHealthbar;
import fightGame.graphics.Animation;
import fightGame.graphics.Assets;
import fightGame.graphics.Text;
import fightGame.input.MouseManager;
import fightGame.sound.Sound;
import fightGame.states.GameState;
import fightGame.states.MenuState;
import fightGame.ui.UIChargeButton;
import fightGame.ui.UIManager;


public class Enemy extends Creature {
	
	private Animation Thonk;
	public static int wait= 0, damageGiven=0, displayingDamage, displayingDefenceDamage;
	public static float health, defence;
	private Handler handler;
	private int width, height;
	public static String State;
	protected static Rectangle bounds;
	public static Animation defaultEnemy, attackingEnemy;
	
	public Enemy(Handler handler, float x, float y, int width, int height, float health, float defence) {
		super(handler, x, y);
		this.x=x;
		this.y=y;
		this.width= width;
		this.height= height;
		State= "default";
		Enemy.health= health;
		Enemy.defence= defence;
		defaultEnemy= new Animation(200, Assets.defaultEnemy, true); 
		attackingEnemy= new Animation(200, Assets.attackingEnemy, true); 
		bounds = new Rectangle((int) x, (int) y, width, height);
	}
	

	@Override
	public void tick() {
		defaultEnemy.tick();
		attackingEnemy.tick();
		if (defence<1) {
			GameState.GigaDrill.setDisabled(true);
		}
		if (wait>0) {
			wait--;
		return;
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);
		if (displayingDefenceDamage>0) 
			Text.drawString(g, String.valueOf(damageGiven), (int) (EnemyHealthbar.x-80), (int) (EnemyHealthbar.y), true, new Color (98, 244, 155), Assets.pixel20);
		if (displayingDamage>0) 
			Text.drawString(g, String.valueOf(damageGiven), (int) (EnemyHealthbar.x-50), (int) (EnemyHealthbar.y+5), true, Color.red, Assets.pixel20);
		displayingDamage--;
		displayingDefenceDamage--;
		Text.drawString(g, String.valueOf((int)(health)), (int) (EnemyHealthbar.x+20), (int) (EnemyHealthbar.y+30), false, Color.red, Assets.pixel20);
		Text.drawString(g, String.valueOf((int)(defence)), (int) (EnemyHealthbar.x+20), (int) (EnemyHealthbar.y-20), false, new Color (98, 244, 155), Assets.pixel20);
		
	}
	
	public static float getHealth() {
		return health;
	}
	
	public static float getDefence() {
		return defence;
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if (State== "attacking")
			return attackingEnemy.getCurrentFrame();
		else			
			return defaultEnemy.getCurrentFrame();
		
	}

}
