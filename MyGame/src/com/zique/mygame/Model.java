package com.zique.mygame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Model {
	private static final int    FRAME_COLS = 4;     // #1
    private static final int    FRAME_ROWS = 1;     // #2

    Animation           walkAnimation;      // #3
    Texture             walkSheet;      // #4
    TextureRegion[]         walkFrames;     // #5
    TextureRegion           currentFrame;       // #7
    
    private float stateTime;
    
    
    
    Model(){
    	//walkSheet = new Texture(Gdx.files.internal("animation_sheet.png")); // #9
    	walkSheet = Assets.texture_test_fish;
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS);              // #10
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation(0.15f, walkFrames);      // #11
        //stateTime = 0f;                         // #13
    }
    
    public void draw_frame(SpriteBatch spriteBatch, float stateTime, int x, int y){
    	currentFrame = walkAnimation.getKeyFrame(stateTime, true);  // #16
        spriteBatch.draw(currentFrame, x, y);             // #17
    }
    
    public void draw_frame(SpriteBatch spriteBatch, int x, int y){
    	currentFrame = walkAnimation.getKeyFrame(this.stateTime, true);  // #16
        spriteBatch.draw(currentFrame, x, y);             // #17
    }

	public float getStateTime() {
		return stateTime;
	}

	public void setStateTime(float delta) {
		this.stateTime += delta;
	}
}
