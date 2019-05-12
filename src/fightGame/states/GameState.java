package fightGame.states;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import fightGame.Handler;
import fightGame.display.Display;
import fightGame.entities.*;
import fightGame.entities.creatures.Assassin;
import fightGame.entities.creatures.Enemy;
import fightGame.entities.creatures.MachineKing;
import fightGame.entities.creatures.SnakeDoctor;
import fightGame.entities.healthbar.EnemyHealthbar;
import fightGame.entities.healthbar.PlayerHealthbar;
import fightGame.graphics.Assets;
import fightGame.graphics.Text;
import fightGame.sound.Sound;
import fightGame.ui.ClickListener;
import fightGame.ui.UIChargeButton;
import fightGame.ui.UIImageButton;
import fightGame.ui.UIManager;



public class GameState extends State {
	
	public static UIImageButton spitAttack, Punch, Stab;
	public static UIChargeButton snakeAttack, healButton, GigaDrill, Barrier, SageStone;
	private static UIManager uiManager;

	public static int myTurn=0,  iconSize=100, difficulty, BASIC_DAMAGE, SageBoost=1;
	
	public GameState(Handler handler){
		super(handler);
		
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		
		healButton= new UIChargeButton(300, handler.getHeight()-80, iconSize, iconSize, Assets.WindFortune, 1, new ClickListener() {
			@Override
			public void onClick() {
				if (SnakeDoctor.wait>0)
					return;
				Sound.playSound("Glug glug.wav");
				SnakeDoctor.displayingDamage= 20;
				SnakeDoctor.damageTaken= (int) (250-SnakeDoctor.health/2);
				SnakeDoctor.health+= 250-SnakeDoctor.health/2;
				SnakeDoctor.healingSnakeDoctor.setCurrentFrame(0);
				SnakeDoctor.State= "healing";
				SnakeDoctor.wait= 50;
				Cool();
				myTurn++;
				}
		});
		
		uiManager.addObject(healButton);
		
		spitAttack= new UIImageButton(600, handler.getHeight()-80, iconSize, iconSize, Assets.Spit, new ClickListener() {
			@Override
			public void onClick() {
				if (SnakeDoctor.wait>0)
					return;
				Sound.playSound("SnakeAttack.wav");
				Enemy.damageGiven= -(int)(1.5*BASIC_DAMAGE);
				Enemy.displayingDamage= 20;
				Enemy.health+= Enemy.damageGiven;
				SnakeDoctor.snakeAttack.setCurrentFrame(0);
				SnakeDoctor.State= "attacking";
				SnakeDoctor.wait= 30;
				Cool();
				myTurn++;
			}
		});
		uiManager.addObject(spitAttack);
		
		GigaDrill= new UIChargeButton(500, handler.getHeight()-80, iconSize, iconSize, Assets.GigaDrill, 1, new ClickListener() {
			@Override
			public void onClick() {
				if (SnakeDoctor.wait>0 || Enemy.defence<1)
					return;
				Sound.playSound("ShieldAttack.wav");
				Enemy.damageGiven= -500;
				Enemy.displayingDefenceDamage= 20;
				Enemy.health-= 3000;
				Enemy.defence+= Enemy.damageGiven;
				// SnakeDoctor.State= "attacking";
				SnakeDoctor.wait= 30;
				Cool();
				myTurn++;
			}
		});
		uiManager.addObject(GigaDrill);
		
		
		Barrier= new UIChargeButton(400, handler.getHeight()-80, iconSize, iconSize, Assets.Barrier, 3, new ClickListener() {
			@Override
			public void onClick() {
				if (SnakeDoctor.wait>0)
						return;
				SnakeDoctor.damageTaken= (int) (150-SnakeDoctor.defence/2);
				SnakeDoctor.displayingDefenceDamage=10;
				SnakeDoctor.defence+= 150-SnakeDoctor.defence/2;
				SnakeDoctor.wait= 10;
				myTurn++;
				Cool();
			}
		});
		uiManager.addObject(Barrier);
		
		Punch= new UIImageButton(700, handler.getHeight()-80, iconSize, iconSize, Assets.Punch, new ClickListener() {
			@Override
			public void onClick() {
				if (SnakeDoctor.wait>0)
						return;

				Sound.playSound("Punch.wav");
				Enemy.damageGiven= -(int)(BASIC_DAMAGE*2);
				Enemy.displayingDamage= 20;
				Enemy.health+= Enemy.damageGiven;
				MachineKing.punchingMachineKing.setCurrentFrame(0);
				MachineKing.State="attacking";
				MachineKing.wait= 30;
				SnakeDoctor.wait= 30;
				myTurn++;
				Cool();
			}
		});
		uiManager.addObject(Punch);
		
		Stab= new UIImageButton(800, handler.getHeight()-80, iconSize, iconSize, Assets.Stab, new ClickListener() {
			@Override
			public void onClick() {
				if (SnakeDoctor.wait>0)
						return;
				Sound.playSound("Punch.wav");
				Enemy.damageGiven= -(int)(BASIC_DAMAGE*3);
				Enemy.displayingDamage= 20;
				Enemy.health+= Enemy.damageGiven;
				Assassin.stabbingAssassin.setCurrentFrame(0);
				Assassin.State= "attacking";
				Assassin.wait= 50;
				SnakeDoctor.wait= 50;
				myTurn++;
				Cool();
			}
		});
		uiManager.addObject(Stab);
		
		SageStone= new UIChargeButton(200, handler.getHeight()-80, iconSize, iconSize, Assets.SageStone, 2, new ClickListener() {
			@Override
			public void onClick() {
				if (SnakeDoctor.wait>0)
						return;
				Sound.playSound("Punch.wav");
				
				Enemy.damageGiven= -250;
				Enemy.displayingDefenceDamage= 20;
				Enemy.defence+= Enemy.damageGiven;
				
				SnakeDoctor.displayingDamage= 20;
				SnakeDoctor.damageTaken= (int) ((500-SnakeDoctor.health)/3);
				SnakeDoctor.health+= (500-SnakeDoctor.health)/3;
				
				SageBoost=SageBoost*2;
				Assassin.sageStoneAttack.setCurrentFrame(0);
				Assassin.State= "SageStoneAttack";
				
				Assassin.wait= 50;
				SnakeDoctor.wait= 50;
				myTurn++;
				Cool();
				System.out.println(SageBoost);
			}
		});
		uiManager.addObject(SageStone);
		};
	
		public static void Cool() {
			healButton.Cool();
			GigaDrill.Cool();
			Barrier.Cool();
			SageStone.Cool();
		}
		 
	@Override
	public void tick() {
		if (MenuState.creatureExists== false)
			return;
		MenuState.enemy.tick();
		MenuState.enemyHealthbar.tick();
		MenuState.enemyDefencebar.tick();
		MenuState.SnakeDoctor.tick();
		MenuState.playerHealthbar.tick();
		MenuState.MachineKing.tick();
		MenuState.Assassin.tick();
		MenuState.playerDefencebar.tick();
		BASIC_DAMAGE= (int)(SageBoost*(Enemy.defence-3000)*(Enemy.defence-3000)/(2000*MenuState.difficulty)+100);
		uiManager.tick();
		
		
		if(Enemy.health<1) {
			Sound.playSound("Applause.wav");
			State.setState(handler.getGame().victoryScreen);
			handler.getMouseManager().setUIManager(VictoryScreen.getUiManager());
			MenuState.creatureExists= false;
		}
		
		if(SnakeDoctor.health<1) { 
			Sound.playSound("Bruh Sound Effect 2.wav");
			State.setState(handler.getGame().losingScreen);
			handler.getMouseManager().setUIManager(LosingScreen.getUiManager());
			MenuState.creatureExists= false;
		}
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(Assets.BattleBackground, 0, 0, handler.getWidth(), handler.getHeight(), null);
		MenuState.enemy.render(g);
		MenuState.enemyHealthbar.render(g);
		MenuState.enemyDefencebar.render(g);
		MenuState.SnakeDoctor.render(g);
		MenuState.playerHealthbar.render(g);
		MenuState.MachineKing.render(g);
		MenuState.Assassin.render(g);
		MenuState.playerDefencebar.render(g);
		uiManager.render(g);
		

	}


	public static UIManager getUiManager() {
		return uiManager;
	}


	public void setUiManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	
}