 package fightGame.states;

import java.awt.Color;
import java.awt.Graphics;

import fightGame.Handler;
import fightGame.entities.creatures.*;
import fightGame.entities.healthbar.*;
import fightGame.graphics.*;
import fightGame.sound.Sound;
import fightGame.ui.*;


public class MenuState extends State {

	public static UIManager uiManager;
	public static UIImageButton Start;
	public static UIDifficultyButton Easy, Medium, Hard;
	public static Enemy enemy;
	public static SnakeDoctor SnakeDoctor;
	public static Assassin Assassin;
	public static PlayerHealthbar playerHealthbar;
	public static EnemyHealthbar enemyHealthbar; 
	public static EnemyDefencebar enemyDefencebar;
	public static PlayerDefencebar playerDefencebar;
	public static MachineKing MachineKing;
	public static int difficulty=2, iconSize= 20;
	public static boolean creatureExists= false;
	
	public static UIManager getUiManager() {
		return uiManager;
	}

	public void setUiManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}

	public MenuState(Handler handler) {
		
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		
		Easy= new UIDifficultyButton(handler.getWidth()/2-80, handler.getHeight()/2-40, iconSize*8, iconSize*3, Assets.Easy, new ClickListener() {
			@Override
			public void onClick() {
				Easy.enabled= true;
				Medium.enabled= false;
				Hard.enabled= false;
				difficulty= 1;
			}
		});
		uiManager.addObject(Easy);
		
		Medium= new UIDifficultyButton(handler.getWidth()/2-80, handler.getHeight()/2+30, iconSize*8, iconSize*3, Assets.Medium, new ClickListener() {
			@Override
			public void onClick() {
				Medium.enabled= true;
				Easy.enabled= false;
				Hard.enabled= false;
				difficulty= 2;
			}
		});
		uiManager.addObject(Medium);
		Medium.enabled= true;
		
		Hard= new UIDifficultyButton(handler.getWidth()/2-80, handler.getHeight()/2+100, iconSize*8, iconSize*3, Assets.Hard, new ClickListener() {
			@Override
			public void onClick() {
				Hard.enabled= true;
				Easy.enabled= false;
				Medium.enabled= false;
				difficulty= 3;
			}
		});
		uiManager.addObject(Hard);
		
		Start= new UIImageButton(handler.getWidth()/2-50, handler.getHeight()/2-250, 100, 100, Assets.Start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(GameState.getUiManager());
				State.setState(handler.getGame().gameState);
				GameState.BASIC_DAMAGE= -(int)((Enemy.defence-3000)*(Enemy.defence-3000)/(2000*MenuState.difficulty)+100);
				if (difficulty==1) 
					Sound.playSound("Easy Music.wav");
				
				if (difficulty==2) 
					Sound.playSound("Medium Music.wav");
				
				if (difficulty==3) 
					Sound.playSound("Hard Music.wav");
				
				// ememy dingetjes
				enemy= new Enemy(handler, handler.getWidth()-512, handler.getHeight()-735, 512, 512, 80000+10000*difficulty, 3000);
				enemyHealthbar= new EnemyHealthbar(handler, (int) (handler.getWidth()-600), handler.getHeight()-170);
				enemyDefencebar= new EnemyDefencebar(handler, (int) (handler.getWidth()-600), handler.getHeight()-181);
				
				// player dingetjes
				SnakeDoctor= new SnakeDoctor(handler, 150, 265, 500, 300);
				MachineKing= new MachineKing(handler, 250, 195);
				Assassin= new Assassin(handler, -10, 270);
				playerHealthbar= new PlayerHealthbar(handler, 100, handler.getHeight()-170);
				playerDefencebar = new PlayerDefencebar(handler, 100, handler.getHeight()-181);
				creatureExists= true;
			}
		});
		uiManager.addObject(Start);
	
	
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.menuBackground, 0, 0, handler.getWidth(), handler.getHeight(), null);
		Text.drawString(g, "Choose a difficulty", handler.getWidth()/2, handler.getHeight()/2-100, true, Color.red, Assets.sword30);
		uiManager.render(g);
		
	}

	public static SnakeDoctor getPlayer() {
		return SnakeDoctor;
	}

	public static Enemy getEnemy() {
		return enemy;
	}

	public static void setEnemy(Enemy enemy) {
		MenuState.enemy = enemy;
	}

	public static EnemyHealthbar getEnemyHealthbar() {
		return enemyHealthbar;
	}

	public static void setEnemyHealthbar(EnemyHealthbar enemyHealthbar) {
		MenuState.enemyHealthbar = enemyHealthbar;
	}

	public static int getDifficulty() {
		return difficulty;
	}

	public static void setDifficulty(int difficulty) {
		MenuState.difficulty = difficulty;
	}

	public static void setPlayer(SnakeDoctor player) {
		MenuState.SnakeDoctor = player;
	}

	public static PlayerHealthbar getPlayerHealthbar() {
		return playerHealthbar;
	}

	public static void setPlayerHealthbar(PlayerHealthbar playerHealthbar) {
		MenuState.playerHealthbar = playerHealthbar;
	}
	
}