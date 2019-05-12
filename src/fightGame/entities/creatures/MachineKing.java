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


public class MachineKing extends Creature {
	
	public static Animation defaultMachineKing, punchingMachineKing;
	public static Animation Block;
	public static String State;
	private Handler handler;
	public static int wait= 0;
	Graphics g;

	public MachineKing(Handler handler, float x, float y) {
		super(handler, x, y);
		this.x=x;
		this.y=y;
		State= "default";
		defaultMachineKing= new Animation(130, Assets.defaultMachineKing, true);
		punchingMachineKing= new Animation(40, Assets.punchingMachineKing, false);
	}
	

	@Override
	public void tick() {
		defaultMachineKing.tick();
		punchingMachineKing.tick();
		if (wait>0) {
			wait--;
		return;
		}
		State= "default";
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, 300, 300, null);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if (State=="attacking")
			return punchingMachineKing.getCurrentFrame();
		
		/*else if (State=="attacking")
			return snakeAttack.getCurrentFrame(); */
		else 	
			return defaultMachineKing.getCurrentFrame();
		
	}

}

