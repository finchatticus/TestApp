package com.gjevass.pixels.testapp.app.json;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class Base64Decoder {
    private Bitmap bitmap;

    public Base64Decoder(String base64) {
        byte[] decodedString = Base64.decode(base64, Base64.DEFAULT);
        this.bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
