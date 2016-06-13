package com.gjevass.pixels.testapp.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import com.gjevass.pixels.testapp.app.json.JSONParser;
import com.gjevass.pixels.testapp.app.model.BackgroundImage;
import com.gjevass.pixels.testapp.app.model.ElementImage;
import com.gjevass.pixels.testapp.app.ui.MainAdapter;
import com.gjevass.pixels.testapp.app.ui.ViewType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private MainAdapter mainAdapter;
    private float scaleFactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView) findViewById(R.id.listview);

        int [] drawables = {
                R.drawable.main_part_0,
                R.drawable.main_part_1,
                R.drawable.main_part_2,
                R.drawable.main_part_3,
                R.drawable.main_part_4,
        };

        List<BackgroundImage> listBackground = new ArrayList<BackgroundImage>();
        for (int i = 0; i < 5; i++) {
            listBackground.add(new BackgroundImage(drawables[i], this));
        }
        listBackground.get(0).setMarginTop(Math.round(-1000 * listBackground.get(0).getScaleFactor()));
        listBackground.get(4).setMarginBottom(Math.round(-1000 * listBackground.get(4).getScaleFactor()));
        listBackground.get(0).setType(ViewType.EMPTY);
        listBackground.get(1).setType(ViewType.PART1);
        listBackground.get(2).setType(ViewType.EMPTY);
        listBackground.get(3).setType(ViewType.PART2);
        listBackground.get(4).setType(ViewType.EMPTY);

        scaleFactor = listBackground.get(0).getScaleFactor();

        mainAdapter = new MainAdapter(this, listBackground);
        listView.setAdapter(mainAdapter);

        ElementsTask elementsTask = new ElementsTask();
        elementsTask.execute();
    }

    private class ElementsTask extends AsyncTask<Void, Void, List<Bitmap>> {
        private Context context = getApplicationContext();

        @Override
        protected List<Bitmap> doInBackground(Void... voids) {
            JSONParser jsonParser = new JSONParser(context, R.raw.uk_main);
            return jsonParser.getPosters();
        }

        @Override
        protected void onPostExecute(List<Bitmap> posters) {
            super.onPostExecute(posters);

            List<ElementImage> elementImageList = new ArrayList<ElementImage>();
            //poster1
            elementImageList.add(new ElementImage(130 , 617 , 3, scaleFactor, posters.get(0), context));
            //poster2
            elementImageList.add(new ElementImage(334, 677, -1, scaleFactor, posters.get(1), context));
            //poster1 frame
            elementImageList.add(new ElementImage(121, 608, 3, scaleFactor, R.drawable.main_poster_frame, context));
            //poster2 frame
            elementImageList.add(new ElementImage(325, 668, -1, scaleFactor, R.drawable.main_poster_frame, context));
            //sticks frame
            elementImageList.add(new ElementImage(106, 587, 0, scaleFactor, R.drawable.main_sticks, context));

            //poster3
            elementImageList.add(new ElementImage(84, 1100, 2, scaleFactor, posters.get(2), context));
            //poster4
            elementImageList.add(new ElementImage(372, 1098, 2.5f, scaleFactor, posters.get(3), context));
            //pin
            elementImageList.add(new ElementImage(212, 206, 0, scaleFactor, R.drawable.main_pin, context));
            //light
            elementImageList.add(new ElementImage(394, 545, 0, scaleFactor, R.drawable.main_light, context));
            //sticker
            //elementImageList.add(new ElementImage(372, 1098, 2.5f, scaleFactor, R.drawable.test_pst, context));

            mainAdapter.setElementImageList(elementImageList);
            mainAdapter.notifyDataSetChanged();
        }
    }
}

