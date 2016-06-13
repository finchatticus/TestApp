package com.gjevass.pixels.testapp.app.json;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {
    private static final String TAG = JSONParser.class.getSimpleName();

    private Context context;
    private int resourceId;
    private List<Bitmap> posters;

    public JSONParser(Context context, int resourceId) {
        this.context = context;
        this.resourceId = resourceId;
        parseJson();
    }

    private void parseJson() {
        InputStream inputStream = context.getResources().openRawResource(resourceId);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            Log.v(TAG, "IOException");
        }

        List<String> imagesStr = new ArrayList<String>();
        try {
            JSONObject jsonObject = new JSONObject(byteArrayOutputStream.toString());
            JSONObject jsonObjectRes = jsonObject.getJSONObject(JSONName.NFO.getName());
            JSONArray jsonArray = jsonObjectRes.getJSONArray(JSONName.NWS.getName());

            for (int i = 0; i < jsonArray.length(); i++) {
                String base64 = jsonArray.getJSONObject(i).getString(JSONName.PST.getName());
                imagesStr.add(base64);
            }
        } catch (JSONException e) {
            Log.v(TAG, "JSONException");
        }

        posters = new ArrayList<Bitmap>();
        for (int i = 0; i < imagesStr.size(); i++) {
            Base64Decoder base64Decoder = new Base64Decoder(imagesStr.get(i));
            Bitmap bitmap = base64Decoder.getBitmap();
            posters.add(bitmap);
        }
    }

    public List<Bitmap> getPosters() {
        return posters;
    }
}
