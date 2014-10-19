package com.zique.mygame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class World{
	//public Fish[] players;
	public Group fishes;
	public Group backgoround_stage;
	public Group active_elements_stage;
	public Group skills;
	BitmapFont font = new BitmapFont();
	public TextureRegion[][] static_texture_region;
	private Texture static_stage_textures;
	
	World(){
		backgoround_stage = new Group();
		fishes = new Group();
		this.static_stage_textures = Assets.texture_static_stage;
		
		Fish temp = new Fish(this, "Oleg");
		temp.setBounds(100, 100, 42, 39);
		fishes.addActor(temp);
		
		Fish temp2 = new Fish(this, "PPP");
		temp2.current_health = 30;
		temp2.setBounds(700, 300, 42, 39);
		fishes.addActor(temp2);
		
		skills = new Group();
		
		//static_texture_region[0] = new TextureRegion(static_stage_textures, 0, 0, 50, 50);
		//static_texture_region[1] = new TextureRegion(static_stage_textures, 50, 0, 50, 50);
		//static_texture_region[2] = new TextureRegion(static_stage_textures, 100, 0, 50, 50);
		//static_texture_region[3] = new TextureRegion(static_stage_textures, 150, 0, 50, 50);
		//static_texture_region[4] = new TextureRegion(static_stage_textures, 200, 0, 50, 50);
		//static_texture_region[5] = new TextureRegion(static_stage_textures, 250, 0, 50, 50);
		this.static_texture_region = TextureRegion.split(Assets.texture_static_stage, Assets.texture_static_stage.getWidth()/6, Assets.texture_static_stage.getHeight()/1);
		
		//System.out.println(this.static_texture_region[length]);
		
		this.load_background_stage();
	}
	
	private class StaticBackgroundElement extends Actor{
		private int texture_index = 1;
		
		public StaticBackgroundElement(int texture_index) {
			this.texture_index = texture_index;
		}
		
		@Override
		public void draw(SpriteBatch batch, float parentAlpha){
			batch.draw(static_texture_region[0][this.texture_index], this.getX(), this.getY());
		}
	}

	
	public void load_background_stage(){
		int ti = 0;
		for(int i=0;i!=WorldView.background_static_map.length;i++)
			for(int j=0;j!=WorldView.background_static_map[i].length();j++){
			
				switch(WorldView.background_static_map[i].charAt(j)){
				case 'h':
					ti = 0;
					break;
				case '~':
					ti = 2;
					break;
				case '.':
					ti = 1;
					break;
				case 's':
					ti = 4;
					break;
				case 'p':
					ti = 5;
					break;
				case 'g':
					ti = 3;
					break;
				}
				StaticBackgroundElement sbe = new StaticBackgroundElement(ti);
				sbe.setPosition(j*50, 540-i*50);
				this.backgoround_stage.addActor(sbe);
			}
	}
}
