package com.zique.mygame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Background extends Group{
	
	private class BackgroundActor extends Actor{
		private Texture texture;
		
		BackgroundActor(){
			this.texture = Assets.temp_bg;
			System.out.println(this.texture);
		}
		
		@Override
		public void draw(SpriteBatch batch, float parentAlpha){
			batch.draw(this.texture,0,0);
		}
	};
	
	
	public Background(){
		this.addActor(new BackgroundActor());
	}
}