package com.zique.mygame;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Skill extends Actor{
	
	private Fish performer,target;
	private int id;
	private Animation animation_forwarding;
	private float delta=0f;
	
	Skill(Fish performer, Fish target, int id){
		this.performer = performer;
		this.target = target;
		this.id = id;
		
		this.animation_forwarding = Assets.animation_forwarding[id];
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha){
		TextureRegion frame = this.animation_forwarding.getKeyFrame(this.delta, true);
		batch.draw(frame, getX(), getY());
	}
	
	@Override
	public void act(float delta){
		this.delta += delta;
		super.act(delta);
		if(this.getActions().size==0){
			this.target.current_health-=5;
			this.remove();
		}
	}
}