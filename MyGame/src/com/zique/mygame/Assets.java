package com.zique.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	
	public static Texture texture_static_stage;
	public static Texture texture_buttons;
	public static Sprite sprite_static_stage;
	public static Texture texture_test_fish;
	public static Sprite sprite_test_fish;
	public static Texture texture_skills;
	
	public static Animation[] animation_forwarding,animation_explosion;
	
	
	public static void load(){
		texture_static_stage = new Texture(Gdx.files.internal("static_stage_sprite.png"));
		texture_static_stage.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_static_stage = new Sprite(texture_static_stage);
		sprite_static_stage.flip(false, true);
		
		texture_buttons = new Texture(Gdx.files.internal("skills.png"));
		texture_buttons.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		texture_test_fish = new Texture(Gdx.files.internal("test_fish.png"));
		texture_test_fish.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_test_fish = new Sprite(texture_test_fish);
		sprite_test_fish.flip(false,true);
		
		texture_skills = new Texture(Gdx.files.internal("bubble.png"));
		TextureRegion[] bubbles = new TextureRegion[3];
		bubbles[0] = new TextureRegion(texture_skills, 2,2,17,17);
		bubbles[1] = new TextureRegion(texture_skills, 21,2,16,17);
		bubbles[2] = new TextureRegion(texture_skills, 40,2,16,17);
		
		animation_forwarding = new Animation[1];
		animation_forwarding[0] = new Animation(0.3f,bubbles);
	}
}
