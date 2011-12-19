package io.gun.minicraft;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class GameSurface extends SurfaceView implements SurfaceHolder.Callback {
	
    public GameSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
	    getHolder().addCallback(this);
//	    canvasthread = new CanvasThread(getHolder(), this);
	    setFocusable(true);
    }
	
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // TODO Auto-generated method stub
    }
 
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }
 
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }

}
