package com.gjevass.pixels.testapp.app.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class ImageUtil {
    private int realHeight;
    private int realWidth;
    private int densityHeight;
    private int densityWidth;

    public ImageUtil(int resourceId, Context context) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) context.getResources().getDrawable(resourceId);
        DisplayUtil displayUtil = new DisplayUtil(context);
        this.realHeight = Math.round(bitmapDrawable.getBitmap().getHeight() / displayUtil.getDensity());
        this.realWidth = Math.round(bitmapDrawable.getBitmap().getWidth() / displayUtil.getDensity());
        this.densityHeight = bitmapDrawable.getIntrinsicHeight();
        this.densityWidth = bitmapDrawable.getIntrinsicWidth();
    }

    public ImageUtil(Bitmap bitmap, Context context) {
        DisplayUtil displayUtil = new DisplayUtil(context);
        this.realHeight = Math.round(bitmap.getHeight() / displayUtil.getDensity());
        this.realWidth = Math.round(bitmap.getWidth() / displayUtil.getDensity());
    }

    public int getRealHeight() {
        return realHeight;
    }

    public void setRealHeight(int realHeight) {
        this.realHeight = realHeight;
    }

    public int getRealWidth() {
        return realWidth;
    }

    public void setRealWidth(int realWidth) {
        this.realWidth = realWidth;
    }

    public int getDensityHeight() {
        return densityHeight;
    }

    public void setDensityHeight(int densityHeight) {
        this.densityHeight = densityHeight;
    }

    public int getDensityWidth() {
        return densityWidth;
    }

    public void setDensityWidth(int densityWidth) {
        this.densityWidth = densityWidth;
    }

    @Override
    public String toString() {
        return "ImageUtil{" +
                "realHeight=" + realHeight +
                ", realWidth=" + realWidth +
                ", densityHeight=" + densityHeight +
                ", densityWidth=" + densityWidth +
                '}';
    }
}
