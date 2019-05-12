package fightGame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fightGame.Handler;
import fightGame.entities.healthbar.EnemyHealthbar;
import fightGame.entities.healthbar.PlayerHealthbar;
import fightGame.graphics.Animation;
import fightGame.graphics.Assets;
import fightGame.graphics.Text;
import fightGame.sound.Sound;
import fightGame.states.GameState;
import fightGame.states.MenuState;
import fightGame.ui.UIChargeButton;


public class SnakeDoctor extends Creature {
	
	public Animation defaultSnakeDoctor;
	public static Animation snakeAttack, healingSnakeDoctor, spitAttack;
	public static float health, defence;
	public static String State;
	private Handler handler;
	public static int displayingDamage=0, displayingDefenceDamage, damageTaken, wait= 0;
	Graphics g;

	public SnakeDoctor(Handler handler, float x, float y, float health, float defence) {
		super(handler, x, y);
		SnakeDoctor.health= health;
		SnakeDoctor.defence= defence;
		this.x=x;
		this.y=y;
		State= "default";
		defaultSnakeDoctor= new Animation(200, Assets.defaultSnakeDoctor, true);
		spitAttack= new Animation(50, Assets.Spit, false);
		snakeAttack= new Animation(50, Assets.snakeAttack, false);
		healingSnakeDoctor= new Animation(200, Assets.healingSnakeDoctor, false);
	}
	

	@Override
	public void tick() {
		defaultSnakeDoctor.tick();
		snakeAttack.tick();
		healingSnakeDoctor.tick();
		spitAttack.tick();
		if (wait>0) {
			wait--;
		return;
		}
		State= "default";
		if (GameState.myTurn>0) {
			wait=10;
			Sound.playSound("Oof.wav");
			Enemy.State= "attacking";
			damageTaken= -(int)(Math.random()*8000*MenuState.difficulty/(defence+50));
			health+= damageTaken;
			defence= (int)(defence*0.95);
			displayingDamage= 15;		
			GameState.myTurn-=1;
			State= "default";
			MachineKing.State= "default";
			Assassin.State= "default";
			System.out.println(GameState.myTurn);
		}
			
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, 230, 230, null);
		if (displayingDamage>0) 
			Text.drawString(g, String.valueOf(damageTaken), 
			(int) (PlayerHealthbar.x+350), 
			(int) (PlayerHealthbar.y+10), 
			false, Color.red, Assets.pixel20);
		displayingDamage--;
		if (displayingDefenceDamage>0) 
			Text.drawString(g, String.valueOf(damageTaken), (int) (PlayerHealthbar.x-350), (int) (PlayerHealthbar.y), true, new Color (98, 244, 155), Assets.pixel20);
		displayingDefenceDamage--;
		Text.drawString(g, String.valueOf((int)(health)), (int) (PlayerHealthbar.x+100), (int) (PlayerHealthbar.y+30), false, Color.red, Assets.pixel20);
		Text.drawString(g, String.valueOf((int)(defence)), (int) (PlayerHealthbar.x+100), (int) (PlayerHealthbar.y-20), false, new Color (98, 244, 155), Assets.pixel20);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if (State=="healing")
			return healingSnakeDoctor.getCurrentFrame();
		
		else if (State=="attacking")
			return snakeAttack.getCurrentFrame();
		else 	
			return defaultSnakeDoctor.getCurrentFrame();
		
	}

}
