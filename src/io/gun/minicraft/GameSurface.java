package io.gun.minicraft;

import com.mojang.ld22.Game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {
	
	Game game;
	public static final int HEIGHT = 120;
	public static final int WIDTH = 160;
	private static final int SCALE = 3;
	public Bitmap b;
	
    public GameSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
	    getHolder().addCallback(this);
	    
	    game = new Game();
	    
	    game.context = this.getContext();
	    game.surface = this;
	    game.surfaceHolder = getHolder();
	    
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
    
    @Override
    public void onDraw(Canvas canvas) {
    	
    	System.out.println("Drawing!");
    	if(b != null){
    		System.out.println("b aint null");
    		canvas.drawBitmap(b, 10, 10, null);
//	        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
//	        canvas.drawColor(Color.RED);
//	        canvas.drawBitmap(bmp, 10, 10, null);
    	}
//    	
////    	System.out.println("Drawing");
////        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
////        canvas.drawColor(Color.RED);
////        canvas.drawBitmap(bmp, 10, 10, null);
           
    }

}
