package com.gjevass.pixels.testapp.app.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.gjevass.pixels.testapp.app.util.DisplayUtil;

public class FrameModel {
    private int marginLeft;
    private int marginTop;
    private float rotate;
    private Bitmap bitmap;

    public FrameModel(int marginLeft, int marginTop, float rotate, float scaleFactor, int resourceId, Context context) {
        this.marginLeft = Math.round(marginLeft * scaleFactor);
        this.marginTop = Math.round(marginTop * scaleFactor);
        System.out.println("marginLeft " + marginLeft);
        System.out.println("marginTop " + marginTop);
        System.out.println("scaleFactor " + scaleFactor);
        this.rotate = rotate;

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        DisplayUtil displayUtil = new DisplayUtil(context);

        float density = displayUtil.getDensity();
        int height = Math.round((bitmap.getHeight() / density) * scaleFactor);
        int width = Math.round((bitmap.getWidth() / density) * scaleFactor);
        this.bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public float getRotate() {
        return rotate;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
