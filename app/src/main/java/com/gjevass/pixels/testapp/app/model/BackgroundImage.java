package com.gjevass.pixels.testapp.app.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.gjevass.pixels.testapp.app.ui.ViewType;
import com.gjevass.pixels.testapp.app.util.DisplayUtil;
import com.gjevass.pixels.testapp.app.util.ImageUtil;

public class BackgroundImage {
    private int marginTop;
    private int marginBottom;
    private int resourceId;
    private float scaleFactor;
    private Bitmap bitmap;
    private Context context;
    private ViewType type;

    public BackgroundImage(int resourceId, Context context) {
        this.resourceId = resourceId;

        DisplayUtil displayUtil = new DisplayUtil(context);
        ImageUtil imageUtil = new ImageUtil(resourceId, context);

        int imageWidth = imageUtil.getRealWidth();
        int imageHeight = imageUtil.getRealHeight();
        int displayWidth = displayUtil.getWidth();
        int displayHeight = displayUtil.getHeight();

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);

        if(displayWidth < imageWidth) {
            float scale = imageHeight / (float)imageWidth;
            int scalledImageWidth = displayWidth;
            int scalledImageHeight = Math.round(displayWidth * scale);
            this.scaleFactor = ((float)displayWidth / (float) imageWidth);
            this.bitmap = Bitmap.createScaledBitmap(bitmap, scalledImageWidth, scalledImageHeight, true);
        }
        else {
            this.scaleFactor = displayWidth / (float) imageWidth;
            int scalledImageWidth = displayWidth;
            int scalledImageHeight = Math.round(imageHeight * this.scaleFactor);
            this.bitmap = Bitmap.createScaledBitmap(bitmap, scalledImageWidth, scalledImageHeight, true);
        }

    }

    public int getMarginTop() {
        return marginTop;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public int getResourceId() {
        return resourceId;
    }

    public float getScaleFactor() {
        return scaleFactor;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    public void setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
    }

    public ViewType getType() {
        return type;
    }

    public void setType(ViewType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BackgroundImage{" +
                "marginTop=" + marginTop +
                ", marginBottom=" + marginBottom +
                ", resourceId=" + resourceId +
                ", scaleFactor=" + scaleFactor +
                '}';
    }
}
