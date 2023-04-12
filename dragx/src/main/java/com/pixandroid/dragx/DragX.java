package com.pixandroid.dragx;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.core.content.ContextCompat;

import org.jetbrains.annotations.NotNull;

public class DragX {


    private static int CIRCLE_SIZE_DP = 36;


    public static void enableLeftTopDrag(Context context,
                                         @NotNull RelativeLayout custom_view_top,
                                         int touch_drawable,
                                         int touch_drawable_size) {
        CIRCLE_SIZE_DP = touch_drawable_size;

        Drawable circle = ContextCompat.getDrawable(context, touch_drawable);
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(circle);
        int circleSize = dpToPx(CIRCLE_SIZE_DP, context);

        ImageView topLeftAnchor = new ImageView(context);
        topLeftAnchor.setImageDrawable(circle);
        RelativeLayout.LayoutParams bottomRightParms =
                new RelativeLayout.LayoutParams(circleSize, circleSize);
        bottomRightParms.addRule(RelativeLayout.ALIGN_PARENT_START, custom_view_top.getId());
        bottomRightParms.addRule(RelativeLayout.ALIGN_PARENT_TOP, custom_view_top.getId());
        custom_view_top.addView(topLeftAnchor, bottomRightParms);


    }

    private static int dpToPx(int dp, Context context) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }


}
