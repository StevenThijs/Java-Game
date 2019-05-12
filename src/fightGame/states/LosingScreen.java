package fightGame.states;

import java.awt.Graphics;

import fightGame.Handler;
import fightGame.entities.creatures.Enemy;
import fightGame.entities.creatures.SnakeDoctor;
import fightGame.graphics.Assets;
import fightGame.ui.ClickListener;
import fightGame.ui.UIImageButton;
import fightGame.ui.UIManager;

public class LosingScreen extends State {
	

	private static UIManager uiManager;


	public static UIManager getUiManager() {
		return uiManager;
	}

	public void setUiManager(UIManager uiManager) {
		LosingScreen.uiManager = uiManager;
	}

	public LosingScreen(Handler handler) {
		super(handler);
		this.handler= handler;
		uiManager = new UIManager(handler);
		
		uiManager.addObject(new UIImageButton(handler.getWidth()-250, handler.getHeight()-200, 100, 100, Assets.Retry, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(MenuState.getUiManager());
				State.setState(handler.getGame().menuState);
				GameState.Barrier.coolDown=0;
				GameState.GigaDrill.coolDown=0;
				GameState.healButton.coolDown=0;
				GameState.SageStone.coolDown=0;
				GameState.SageBoost=1;
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.loss, 0, 0, handler.getWidth(), handler.getHeight(), null);
		uiManager.render(g);
	}
	
	
}
