package fightGame.graphics;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import fightGame.sound.Sound;

public class Assets {
	public static Font pixel20, sword30;
	public static BufferedImage test, landscape, menuBackground, player, loss, win, BattleBackground;
	public static BufferedImage[] defaultSnakeDoctor, defaultMachineKing, defaultEnemy, defaultAssassin, // Default sprites
	Barrier, GigaDrill, Punch, BloodLust, Emperor, SageStone, WindFortune, Spit, Stab, // Attack Buttons
	snakeAttack, healingSnakeDoctor, stabbingAssassin, punchingMachineKing, SageStoneAttack,attackingEnemy, // Attack Animations
	Start, Retry, Attack, Easy, Medium, Hard;
	
	public static void init() {
		
		// Fonts
		pixel20= FontLoader.loadFont("res/fonts/slkscr.ttf", 20);
		sword30= FontLoader.loadFont("res/fonts/Barbarian.ttf", 60);
		
		// Creatures, backgrounds
		player= ImageLoader.loadImage("/Creatures/player.gif");
		menuBackground= ImageLoader.loadImage("/Backgrounds/Menu Background.jpg");
		test= ImageLoader.loadImage("/textures/hmmm.gif");
		BattleBackground= ImageLoader.loadImage("/Backgrounds/BattleBackground.png");
		loss= ImageLoader.loadImage("/Backgrounds/Losing Screen.png");
		win= ImageLoader.loadImage("/Backgrounds/Victory Screen.png");
		
		
		// Buttons
		Start= new BufferedImage[2];
		Start[0]= ImageLoader.loadImage("/Buttons/Default/Default Start.png");
		Start[1]= ImageLoader.loadImage("/Buttons/Hover/Hover Start.png");
		
		Retry= new BufferedImage[2];
		Retry[0]= ImageLoader.loadImage("/Buttons/Default/Default Retry.png");
		Retry[1]= ImageLoader.loadImage("/Buttons/Hover/Hover Retry.png");

		Easy= new BufferedImage[2];
		Easy[0]= ImageLoader.loadImage("/Buttons/Menu Difficulty/Default Easy (2).png");
		Easy[1]= ImageLoader.loadImage("/Buttons/Menu Difficulty/Hover Easy (2).png");

		Medium= new BufferedImage[2];
		Medium[0]= ImageLoader.loadImage("/Buttons/Menu Difficulty/Default Medium (2).png");
		Medium[1]= ImageLoader.loadImage("/Buttons/Menu Difficulty/Hover Medium (2).png");
		
		Hard= new BufferedImage[2];
		Hard[0]= ImageLoader.loadImage("/Buttons/Menu Difficulty/Default Hard (2).png");
		Hard[1]= ImageLoader.loadImage("/Buttons/Menu Difficulty/Hover Hard (2).png");
		
		// Basic Attacks
		Spit= new BufferedImage[2];
		Spit[0]= ImageLoader.loadImage("/Buttons/Default/Default Spit.png");
		Spit[1]= ImageLoader.loadImage("/Buttons/Hover/Hover Spit.png");
		
		Punch= new BufferedImage[2];
		Punch[0]= ImageLoader.loadImage("/Buttons/Default/Default Punch.png");
		Punch[1]= ImageLoader.loadImage("/Buttons/Hover/Hover Punch.png");
		
		Stab= new BufferedImage[2];
		Stab[0]= ImageLoader.loadImage("/Buttons/Default/Default Stab.png");
		Stab[1]= ImageLoader.loadImage("/Buttons/Hover/Hover Stab.png");
		
		// Charge attacks
		WindFortune= new BufferedImage[3];
		WindFortune[0]= ImageLoader.loadImage("/Buttons/Default/Default Wind Fortune.png");
		WindFortune[1]= ImageLoader.loadImage("/Buttons/Hover/Hover Wind Fortune.png");
		WindFortune[2]= ImageLoader.loadImage("/Buttons/Disabled/Disabled Wind Fortune.png");
		
		Attack= new BufferedImage[3];
		Attack[0]= ImageLoader.loadImage("/Buttons/Default/Default Attack.png");
		Attack[1]= ImageLoader.loadImage("/Buttons/Hover/Hover Attack.png");
		Attack[2]= ImageLoader.loadImage("/Buttons/Disabled/Disabled Attack.png");
		
		Barrier= new BufferedImage[3];
		Barrier[0]= ImageLoader.loadImage("/Buttons/Default/Default Barrier.png");
		Barrier[1]= ImageLoader.loadImage("/Buttons/Hover/Hover Barrier.png");
		Barrier[2]= ImageLoader.loadImage("/Buttons/Disabled/Disabled Barrier.png");
		
		GigaDrill= new BufferedImage[3];
		GigaDrill[0]= ImageLoader.loadImage("/Buttons/Default/Default Giga Drill.png");
		GigaDrill[1]= ImageLoader.loadImage("/Buttons/Hover/Hover Giga Drill.png");
		GigaDrill[2]= ImageLoader.loadImage("/Buttons/Disabled/Disabled Giga Drill.png");
		
		BloodLust= new BufferedImage[3];
		BloodLust[0]= ImageLoader.loadImage("/Buttons/Default/Default Blood Lust.png");
		BloodLust[1]= ImageLoader.loadImage("/Buttons/Hover/Hover Blood Lust.png");
		BloodLust[2]= ImageLoader.loadImage("/Buttons/Default/Default Blood Lust.png");
		
		Emperor= new BufferedImage[3];
		Emperor[0]= ImageLoader.loadImage("/Buttons/Default/Default Emperor.png");
		Emperor[1]= ImageLoader.loadImage("/Buttons/Hover/Hover Emperor.png");
		Emperor[2]= ImageLoader.loadImage("/Buttons/Default/Default Emperor.png");
		
		SageStone= new BufferedImage[3];
		SageStone[0]= ImageLoader.loadImage("/Buttons/Default/Default Sage Stone.png");
		SageStone[1]= ImageLoader.loadImage("/Buttons/Hover/Hover Sage Stone.png");
		SageStone[2]= ImageLoader.loadImage("/Buttons/Disabled/Disabled Sage Stone.png");
		
		// Animations
		
		defaultSnakeDoctor= new BufferedImage[5];
		for (int i=1; i < 6; i++) {
			defaultSnakeDoctor[i-1]= ImageLoader.loadImage(
					"/Animations/Snake Doctor/Default Snake Doctor "+i+".png");
		}
		
		
		snakeAttack= new BufferedImage[20];
		for (int i=1; i < 21; i++) {
			snakeAttack[i-1]= ImageLoader.loadImage(
					"/Animations/Snake Attack/Snake Attack "+i+".png");
		}
		
		healingSnakeDoctor= new BufferedImage[6];
		for (int i=1; i < 7; i++) {
			healingSnakeDoctor[i-1]= ImageLoader.loadImage(
					"/Animations/Healing Snake Doctor/Healing Snake Doctor "+i+".png");
		}
				
		defaultMachineKing= new BufferedImage[12];
		for (int i=1; i < 13; i++) {
			defaultMachineKing[i-1]= ImageLoader.loadImage(
					"/Animations/Machine King/Machine King "+i+".png");
		}
		
		defaultEnemy= new BufferedImage[10];
		for (int i=1; i < 11; i++) {
			defaultEnemy[i-1]= ImageLoader.loadImage(
					"/Animations/Enemy/Enemy "+i+".png");
		}
		
		attackingEnemy= new BufferedImage[10];
		for (int i=1; i < 11; i++) {
			attackingEnemy[i-1]= ImageLoader.loadImage(
					"/Animations/Enemy/Enemy "+i+".png");
		}
		defaultAssassin= new BufferedImage[9];
		for (int i=1; i < 10; i++) {
			defaultAssassin[i-1]= ImageLoader.loadImage(
					"/Animations/Default Assassin/Assassin "+i+".png");
		}
		
		stabbingAssassin= new BufferedImage[44];
		for (int i=1; i < 45; i++) {
			stabbingAssassin[i-1]= ImageLoader.loadImage(
					"/Animations/Stabbing Assassin/Stab "+i+".png");
		}
		
		punchingMachineKing= new BufferedImage[27];
		for (int i=1; i < 28; i++) {
			punchingMachineKing[i-1]= ImageLoader.loadImage(
					"/Animations/Punching MachineKing/Punch "+i+".png");
		}
		
		SageStoneAttack= new BufferedImage[29];
		for (int i=1; i < 30; i++) {
			SageStoneAttack[i-1]= ImageLoader.loadImage(
					"/Animations/Sage Stone/Sage Stone "+i+".png");
		}
	}
}

