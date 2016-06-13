package com.gjevass.pixels.testapp.app.model;

import android.graphics.Bitmap;

public class ViewModel {
    private SprtModel sprtModel;
    private FrameModel frameModel;
    private Bitmap bitmapSprt;
    private Bitmap bitmapFrame;

    public ViewModel(SprtModel sprtModel, FrameModel frameModel) {
        this.sprtModel = sprtModel;
        this.frameModel = frameModel;
        this.bitmapSprt = sprtModel.getBitmap();
        this.bitmapFrame= frameModel.getBitmap();
    }

    /*    public EvenViewModel(float rotateSprt, int widthSprt, int heightSprt, float scaleFactor, int resourceSprt, Context context) {
        this.rotateSprt = rotateSprt;
        this.widthSprt = widthSprt;
        this.heightSprt = heightSprt;
        this.resourceSprt = resourceSprt;

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceSprt);
        DisplayUtil displayUtil = new DisplayUtil(context);

        float density = displayUtil.getDensity();
        this.heightSprt = Math.round((bitmap.getHeight() / density) * scaleFactor);
        this.widthSprt = Math.round((bitmap.getWidth() / density) * scaleFactor);
        this.bitmapSprt = Bitmap.createScaledBitmap(bitmap, this.widthSprt, this.heightSprt, true);
    }

    public EvenViewModel(float rotateSprt, int widthSprt, int heightSprt, float scaleFactor, Bitmap bitmapSprt, Context context) {
        this.rotateSprt = rotateSprt;
        this.heightSprt = Math.round(bitmapSprt.getHeight() * scaleFactor);
        this.widthSprt = Math.round(bitmapSprt.getWidth() * scaleFactor);
        this.bitmapSprt = Bitmap.createScaledBitmap(bitmapSprt, this.widthSprt, this.heightSprt, true);
    }*/

    public Bitmap getBitmapSprt() {
        return bitmapSprt;
    }

    public SprtModel getSprtModel() {
        return sprtModel;
    }

    public FrameModel getFrameModel() {
        return frameModel;
    }

    public Bitmap getBitmapFrame() {
        return bitmapFrame;
    }
}
