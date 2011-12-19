package io.gun.minicraft;

import com.mojang.ld22.Game;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {
	
	Game game;
	public static final int HEIGHT = 120;
	public static final int WIDTH = 160;
	private static final int SCALE = 3;
	
    public GameSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
	    getHolder().addCallback(this);
	    
	    game = new Game();
	    
	    game.context = this.getContext();
	    game.surface = this;
	    game.surfaceHolder = getHolder();
	    
//		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
//		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
//		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
	    
	    setFocusable(true);
    }
	
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }
 
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    	game.start();
    }
 
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        game.stop();
        
    }

}
