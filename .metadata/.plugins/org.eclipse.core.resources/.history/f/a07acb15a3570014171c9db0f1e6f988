package com.zique.mygame;

import javax.sound.midi.Sequence;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

public class Fish extends Actor{
	
	public int current_health;
	public int max_health;
	public Fish target = null;
	public int level;
	public String name;
	private Model model;
	private boolean self;
	private World world;
	
	public void setSelf(boolean self){
		this.self = self;
	}
	
	Fish(World world, String name){
		model = new Model();
		
		this.name=name;
		
		this.current_health = 80;
		this.max_health = 100;
		this.level = 1;
		this.world = world;
	}
	
	@Override
	public void act(float delta){
		this.model.setStateTime(delta);
		super.act(delta);
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha){
		//model.draw_frame(batch, (int)this.getX()+Gdx.graphics.getWidth()/2, (int)this.getY()+Gdx.graphics.getHeight()/2);//, Gdx.graphics.getHeight()/2); // fix!
		model.draw_frame(batch, (int)this.getX(), (int)this.getY());//, Gdx.graphics.getHeight()/2); // fix!
		world.font.draw(batch, this.name, this.getX(), this.getY()+55);
	}
	
	@Override
	public Actor hit (float x, float y, boolean touchable) {
		if(touchable)return null;
        return super.hit(x, y, touchable);
	}
	
	public void flip_fish()
	{
		for(int i=0;i!=this.model.walkFrames.length;i++)
			this.model.walkFrames[i].flip(true, false);
	}

}