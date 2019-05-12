package fightGame;

import fightGame.input.MouseManager;

public class Handler {
	
	private Game game;
	
	public Handler(Game game){
		this.game = game;
	}
	
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}