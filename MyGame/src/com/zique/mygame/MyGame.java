package com.zique.mygame;

import com.badlogic.gdx.Game;

public class MyGame extends Game{

	public GameScreen game_screen;
	
	@Override
	public void create() {
		Assets.load();
		game_screen = new GameScreen(this);
		
		setScreen(game_screen);
	}

}
