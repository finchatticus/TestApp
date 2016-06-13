package com.gjevass.pixels.testapp.app.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class PosterModel {
    private int marginLeft;
    private int marginTop;
    private float rotate;
    private Bitmap bitmap;

    public PosterModel(int marginLeft, int marginTop, float rotate, float scaleFactor, Bitmap bitmap) {
        this.marginLeft = Math.round(marginLeft * scaleFactor);
        this.marginTop = Math.round(marginTop * scaleFactor);
        this.rotate = rotate;
        int height = Math.round(bitmap.getHeight() * scaleFactor);
        int width = Math.round(bitmap.getWidth() * scaleFactor);
        this.bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public float getRotate() {
        return rotate;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
