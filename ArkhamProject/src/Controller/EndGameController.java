package Controller;

import View.EndGameView;

public class EndGameController {
	
	@SuppressWarnings("unused")
	private EndGameView vistaFinJuego;

	public EndGameController(int option){
		vistaFinJuego = new EndGameView(option);
		initEndGameController();
	}
	
	public void initEndGameController(){
		
	}
	
}
