package com.gjevass.pixels.testapp.app.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ScaleFactorCalc {
    private float scaleFactor;

    public ScaleFactorCalc(int resourceId, Context context) {
        System.out.println("resorce ");
        DisplayUtil displayUtil = new DisplayUtil(context);
        ImageUtil imageUtil = new ImageUtil(resourceId, context);
        int imageWidth = imageUtil.getRealWidth();
        System.out.println("imageWidth " +imageWidth);
        int displayWidth = displayUtil.getWidth();
        System.out.println("displayWidth "+ displayWidth);
        if(displayWidth < imageWidth) {
            this.scaleFactor = ((float)displayWidth / (float) imageWidth);
            System.out.println("scaleFactor " + scaleFactor);
        }
        else {
            this.scaleFactor = displayWidth / (float) imageWidth;
            System.out.println("scaleFactor " + scaleFactor);
        }
    }

    public ScaleFactorCalc(Bitmap bitmap, Context context) {
        System.out.println("bitmap");
        DisplayUtil displayUtil = new DisplayUtil(context);
        int imageWidth = bitmap.getWidth();
        int displayWidth = displayUtil.getWidth();
        if(displayWidth < imageWidth) {
            this.scaleFactor = ((float)displayWidth / (float) imageWidth);
            System.out.println("scaleFactor " + scaleFactor);
        }
        else {
            this.scaleFactor = displayWidth / (float) imageWidth;
            System.out.println("scaleFactor " + scaleFactor);
        }
    }

    public float getScaleFactor() {
        return scaleFactor;
    }
}
