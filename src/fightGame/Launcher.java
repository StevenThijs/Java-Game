package fightGame;
import fightGame.display.Display;

public class Launcher {

	private static int windowWidth= Display.getWindowWidth();
	private static int windowHeight= Display.getWindowHeigth();
	public static void main(String[] args){
		Game game = new Game("Nibbas in de hood!", windowWidth, windowHeight);
		game.start();
	}
	
}