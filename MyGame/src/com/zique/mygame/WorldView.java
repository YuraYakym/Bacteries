package com.zique.mygame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class WorldView {
	
	public static String[] background_static_map = {
		"sssssssssshhhhhhhhhhhhhhhhhhssssssssssssssssssssssssssssssss",
		"hsssssssssssssssssssssssssssssssssssssssssssssssssssssssssss",
		"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~",
		"............................................................",
		"............................................................",
		"............................................................",
		"............................................................",
		"............................................................",
		"............................................................",
		".......................gg...................................",
		"......p..............ggggggg................................",
		".....pp..ppp........gg.....ggg.gg...........................",
		"ggggggggggggggggggggggpppppggggggggggggggggggggggggggggggggg",
		"gggggggpppppppppppppppppppppgggggggggggggggggggggggppppppppp"};
	
	public static String[] active_elements_map = {
		"............................................................",
		"............................................................",
		"............................................................",
		"............................................................",
		"............................................................",
		"............................................................",
		"............................................................",
		"............................................................",
		"........s.......s...........................................",
		"............................................................",
		"............................................................",
		"............................................................",
		"............................................................",
		"............................................................"
	};
	
	public String[] map = {
			"sssssssshhsssssshhsssssssssssssssshhhhsssssssssssssssssshhhhssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss",
			"ssssssssssssssssshsssssssssssssssssssssssssssshhssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss",
			"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~gggg",
			"................................................................................................................................................",
			"................................................................................................................................................",
			"................................................................................................................................................",
			"................................................................................................................................................",
			"................................................................................................................................................",
			"................................................................................................................................................",
			"................................................................................................................................................",
			"................................................................................................................................................",
			".........................................................................ppppppp..................................................................",
			".....................................gg......................................pppppp.................................................................",
			".....................................gsg.........................................pp.......................p......................................",
			".................................~..gsg.........................................pp........................pp...................................",
			"...................g...............gggg.......................................pp.........................pppppp......................................",
			"..................ggg.............................pppppppppp.................pp......................ppppp..p..............................",
			"ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggssssssssssssssggggggggggggggggggggggg",
			"ggggggggggggggggggggggsssssssssssssssssggggggggggggggggggssssssssssssggggggggggggggggggggggggggggggggggggggssssssssssssssggggggggggggggggggggggg",
			"ggggggggggggggggggggggsssssssssssssssssggggggggggggggggggpppppppppppggggggggggggggggggggggggggggggggggggggssssssssssssssggggggggggggggggggggggg",
			"ggggggggggggggggggggggsssssssssssssssssggggggggggggggggggssssssssssssggggggggggggggggggggggggggggggggggggggssssssssssssssggggggggggggggggggggggg",
			"ggggggggggggggggggggggsssssssssssssssssggggggggggggggggggssssssssssssggggggggggggggggggggggggggggggggggggggssssssssssssssggggggggggggggggggggggg",
			"ggggggggggggggggggggggsssssssssssssssssggggggggggggggggggssssssssssssggggggggggggggggggggggggggggggggggggggssssssssssssssggggggggggggggggggggggg",
	};
	private TextureRegion[][] tmp;
	
	WorldView()
	{
		tmp = TextureRegion.split(Assets.texture_static_stage, Assets.texture_static_stage.getWidth()/6, Assets.texture_static_stage.getHeight()/1);
	}
	
	public void draw(SpriteBatch spriteBatch, int x, int y){
		int tx=x%50;
		int ty=y%50;
		x/=50;
		y/=50;
		TextureRegion temp=tmp[0][0];
		for(int i=x-10,pi=0;i!=x+14;i++,pi++)
			for(int j=y-5,pj=0;j!=y+10;j++,pj++){
				if(i>=0 && j>=0 && j<map.length && i<map[j].length()){
					switch(map[j].charAt(i)){
					case 'h':
						temp = tmp[0][0];
						break;
					case '~':
						temp = tmp[0][2];
						break;
					case '.':
						temp = tmp[0][1];
						break;
					case 's':
						temp = tmp[0][4];
						break;
					case 'p':
						temp = tmp[0][5];
						break;
					case 'g':
						temp = tmp[0][3];
						break;
					}
					spriteBatch.draw(temp, pi*50-tx, 540-pj*50+ty);
				}
			}
	}
}
