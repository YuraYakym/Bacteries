package com.zique.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen{

	OrthographicCamera camera;
	SpriteBatch batch;
	Stage stage;
	int sw,sh;
	//Interface _interface;
	float stateTime;
	private Background background;
	
	
	public GameScreen(MyGame game) {
		sh = Gdx.graphics.getHeight();
		sw = Gdx.graphics.getWidth();
		//camera = new OrthographicCamera();
		//camera.setToOrtho(false ,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false, batch);
		//stage.setCamera(camera);
		
		background = new Background();

		stage.addActor(background);
		background.setVisible(true);
		
		stateTime = 0f;
		//Gdx.input.setInputProcessor(inputProcessor);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1); 
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); 
		//camera.update();
		stage.getCamera().update();
		stateTime += Gdx.graphics.getDeltaTime();
		
		stage.draw();
		stage.act(Gdx.graphics.getDeltaTime());
		
		//_interface.draw();
		
		
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
