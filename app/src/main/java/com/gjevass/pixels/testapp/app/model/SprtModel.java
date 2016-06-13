package com.gjevass.pixels.testapp.app.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.gjevass.pixels.testapp.app.util.DisplayUtil;

public class SprtModel {
    private Bitmap bitmap;

    public SprtModel(float scaleFactor, int resourceId, Context context) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        DisplayUtil displayUtil = new DisplayUtil(context);

        float density = displayUtil.getDensity();
        int height = Math.round((bitmap.getHeight() / density) * scaleFactor);
        int width = Math.round((bitmap.getWidth() / density) * scaleFactor);
        this.bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

}
