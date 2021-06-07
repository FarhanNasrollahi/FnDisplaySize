package com.example.fndisplaysize;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class FnDisplaySize {


    public static int width;
    public static int height;


    public static void initDisplaySize(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        int width = (int) pxFromDp(context, displayMetrics.widthPixels);
        int height = (int) pxFromDp(context, displayMetrics.heightPixels);
        FnDisplaySize.width = width;
        FnDisplaySize.height = height;
    }

    public static int getWidth(Context context) {
        return (int) dpFromPx(context, width);
    }

    public static int getHeight(Context context) {
        return (int) dpFromPx(context, height);
    }


    public static float pxFromDp(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    public static float dpFromPx(Context context, int px) {
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static int getActionBarSize (Context context){
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(new int[] { android.R.attr.actionBarSize });
        int mActionBarSize = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        return mActionBarSize;
    }

}
