package fightGame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fightGame.Handler;
import fightGame.entities.healthbar.PlayerHealthbar;
import fightGame.graphics.Animation;
import fightGame.graphics.Assets;
import fightGame.graphics.Text;
import fightGame.sound.Sound;
import fightGame.states.GameState;
import fightGame.states.MenuState;
import fightGame.ui.UIChargeButton;


public class Assassin extends Creature {
	
	public static Animation defaultAssassin, stabbingAssassin, sageStoneAttack;
	public static String State;
	private Handler handler;	
	public static int wait= 0, xOffSet, yOffSet;
	Graphics g;

	public Assassin(Handler handler, float x, float y) {
		super(handler, x, y);
		this.x=x;
		this.y=y;
		State= "default";
		defaultAssassin= new Animation(150, Assets.defaultAssassin, true);
		stabbingAssassin= new Animation(30, Assets.stabbingAssassin, false);
		sageStoneAttack= new Animation(50, Assets.SageStoneAttack, false);
	}
	

	@Override
	public void tick() {
		defaultAssassin.tick();
		stabbingAssassin.tick();
		sageStoneAttack.tick();
		if (wait>0) {
			wait--;
		return;
		}
		State= "default";
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) x+getXOffSet(), (int) y+getYOffSet(), 230, 230, null);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if (State=="attacking")
			return stabbingAssassin.getCurrentFrame();
		
		else if (State=="SageStoneAttack")
			return sageStoneAttack.getCurrentFrame(); 
		
		else 	
			return defaultAssassin.getCurrentFrame();
		
	}
	
	private int getXOffSet() {
		if (State=="attacking" || State=="SageStoneAttack")
			return 38;
		return 0;
	}
	
	private int getYOffSet() {
		if (State=="attacking" || State=="SageStoneAttack")
			return 5;
		return 0;
	}

}

