package com.pixandroid.dragx.helper;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class AnchorTouchListener implements View.OnTouchListener {
    private static final String TAG = "AnchorTouchListener";
    private int _xDelta;
    private int _yDelta;
    private View viewToResize;
//    private Anchor.ResizeMode resizeMode;


    private TouchListener listener;


    public AnchorTouchListener(View viewToResize, TouchListener listener) {
        this.viewToResize = viewToResize;
        this.listener = listener;
        original_width = 0;
        original_height = 0;
    }


    private int original_width;
    private int original_height;

    private int initialHeight;
    private int initialWidth;
    private int initialX;
    private int initialY;



    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();

        Log.d("Anchor", "Updating X & Y");

        switch (event.getActionMasked() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:

                listener.onStateChanged("JUST_TOUCHED");
                // Capture initial conditions of the view to resize.
                initialHeight = viewToResize.getHeight();
                initialWidth = viewToResize.getWidth();

                if (original_width == 0) {
                    original_width = initialWidth;
                    original_height = initialHeight;
                }

                // Capture initial touch point.
                initialX = X;
                initialY = Y;
                Log.e(TAG, "onTouch: X " + X );
                Log.e(TAG, "onTouch: Y " + Y );
                break;

            case MotionEvent.ACTION_UP:
                listener.onStateChanged("DRAG_FINISHED");
                //lblStatus.setText("Drag finished");
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                break;

            case MotionEvent.ACTION_POINTER_UP:
                break;

            case MotionEvent.ACTION_MOVE:
                listener.onStateChanged("MOVING_AROUND");
                //lblStatus.setText("Moving around");
                RelativeLayout.LayoutParams lp =
                        (RelativeLayout.LayoutParams) viewToResize.getLayoutParams();
                // Compute how far we have moved in the X/Y directions.
                _xDelta =  initialX - X;
                _yDelta =  initialY - Y;

                int w = initialWidth + _xDelta;
                if (w < original_width) {
                    w =  original_width;
                }

                int h = initialHeight + _yDelta;
                if (h < original_height) {
                    h =  original_height;
                }

                Log.e(TAG, "onTouch: w = " + w );
                //Log.e(TAG, "onTouch: mX = " + DragDropActivity.mX );

                // Adjust the size of the targeted view. Note that we don't have to position
                // the resize handle since it will be positioned correctly due to the layout.
                lp.width = w;
                lp.height = h;
                viewToResize.setLayoutParams(lp);
                break;
        }
        return true;
    }


    public interface TouchListener {
        void  onTap(int x, int y);
        void onStateChanged(String state);
    }

}
