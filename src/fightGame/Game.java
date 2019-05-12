package fightGame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import fightGame.display.Display;
import fightGame.entities.creatures.Enemy;
import fightGame.entities.healthbar.EnemyHealthbar;
import fightGame.graphics.Assets;
import fightGame.graphics.ImageLoader;
import fightGame.graphics.Text;
import fightGame.input.MouseManager;
import fightGame.states.GameState;
import fightGame.states.LosingScreen;
import fightGame.states.MenuState;
import fightGame.states.State;
import fightGame.states.VictoryScreen;


public class Game implements Runnable {

	// Frame setup
	public Display display;
	public int width, height;
	public String title;
	
	// Maakt de thread
	private boolean running = false;
	private Thread thread;
	
	//Input
	private MouseManager mouseManager;
	
	// Graphics
	private BufferStrategy bs;
	private Graphics g;
	
	//Handler
	private Handler handler;
	
	//States
	public State gameState;
	public State menuState;
	public State victoryScreen;
	public State losingScreen;
	
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		mouseManager = new MouseManager();
	}
	
	private void init(){
		
		display = new Display(title, width, height);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);

		
		handler = new Handler(this);
		
		
		Assets.init();
		gameState = new GameState(handler);
		menuState= new MenuState(handler);
		victoryScreen= new VictoryScreen(handler);
		losingScreen= new LosingScreen(handler);
		State.setState(menuState);


		
	}
	
	private void tick(){
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		
		//Rendering
		if(State.getState() != null) 
			State.getState().render(g);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}