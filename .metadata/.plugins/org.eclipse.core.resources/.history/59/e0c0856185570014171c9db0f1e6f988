package com.zique.mygame;

import sun.java2d.loops.DrawRect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.sun.org.apache.xpath.internal.operations.Gte;

public class Interface extends Stage{
	
	private BitmapFont font;
	private TextureRegion[] button_texture;
	private World world;
	private ShapeRenderer shape;
	private SpriteBatch batch;
	private int sh,sw;
	
	private class Button extends Actor{
		public int id;
		public int type;
		
		Button(int type, int id){
			this.type = type;
			this.id = id;
		}
		
		@Override
		public void draw(SpriteBatch batch, float parentAlpha){
			batch.draw(button_texture[this.id], getX(), getY(), getWidth(), getHeight());
		}
		
		@Override
		public Actor hit(float x, float y, boolean touchable){
			return super.hit(x,y,touchable);
		}
	}
	
	private class MainInterface extends Group{
		private World world;
		public Group skills;
		
		MainInterface(World world){
			this.world = world;
			skills = new Group();
			
			Button bubble = new Button(0,0);
			bubble.setBounds(sw/2, 5, 25, 25);
			Button rush = new Button(0,1);
			rush.setBounds(sw/2+30, 5, 25, 25);
			
			skills.addActor(bubble);
			skills.addActor(rush);
			skills.setTouchable(Touchable.enabled);
			
			this.addActor(skills);
		}
		
		@Override
		public void draw(SpriteBatch batch, float parentAlpha){
			super.draw(batch,parentAlpha);
			
			batch.end();
			
			shape.begin(ShapeType.FilledRectangle);
				shape.setColor(0, 0, 0, 1);
				shape.filledRect(45, sh-20, 202, 17);
				
				shape.filledRect(10, 480, 70, 17);
				
				shape.setColor(1,0,0,0.75f);
				shape.filledRect(46, sh-19, this.world.player.fish.current_health*200/this.world.player.fish.max_health, 15);
				
				if(this.world.player.fish.target != null){
					shape.setColor(0,0,0,1f);
					shape.filledRect(sw/2, sh-20, 202, 17);
					shape.setColor(1,0,0,0.75f);
					shape.filledRect(sw/2, sh-19, this.world.player.fish.target.current_health*200/this.world.player.fish.target.max_health, 15);
				}
			shape.end();
			
			shape.begin(ShapeType.FilledCircle);
				shape.setColor(0,0,0,1);
				shape.filledCircle(30, sh-30, 20);
				if(this.world.player.fish.target != null){
					shape.filledCircle(sw/2+200, sh-30, 20);
				}
			shape.end();
			
			
			batch.begin();
			font.draw(batch, this.world.player.fish.current_health+"/"+this.world.player.fish.max_health, 100, 533);
			font.draw(batch, ""+this.world.player.fish.level, 25, sh-25);
			
			if(this.world.player.fish.target != null){
				font.draw(batch, this.world.player.fish.target.current_health+"/"+this.world.player.fish.target.max_health, sw/2+100, sh-5);
				font.draw(batch, ""+this.world.player.fish.target.level, sw/2+200, sh-25);
				font.draw(batch, ""+this.world.player.fish.target.name, sw/2+150, sh-35);
			}
			
			font.draw(batch, this.world.player.fish.name, 12, 495);
		}
	}
	
	Interface(SpriteBatch batch, World world){
		sh = Gdx.graphics.getHeight();
		sw = Gdx.graphics.getWidth();
		this.world = world;
		this.font = new BitmapFont();
		this.shape = new ShapeRenderer();
		this.batch = batch;
		this.addActor(new MainInterface(world));
		button_texture = new TextureRegion[2];
		button_texture[0] = new TextureRegion(Assets.texture_buttons);
		button_texture[1] = new TextureRegion(Assets.texture_buttons);
	}
	
	public void proceed_button(Actor button){
		Button but = (Button)button;
		switch(but.type){
		case 0:
			switch(but.id){
			case 0:
				this.world.player.fish.performSkill(0);
				break;
			case 1:
				this.world.player.fish.performSkill(1);
				break;
			}
		}
	}
	
}
