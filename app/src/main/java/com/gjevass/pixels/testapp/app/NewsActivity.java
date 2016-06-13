package com.gjevass.pixels.testapp.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.gjevass.pixels.testapp.app.json.JSONParser;
import com.gjevass.pixels.testapp.app.model.FrameModel;
import com.gjevass.pixels.testapp.app.model.PosterModel;
import com.gjevass.pixels.testapp.app.model.SprtModel;
import com.gjevass.pixels.testapp.app.model.ViewModel;
import com.gjevass.pixels.testapp.app.ui.NewsAdapter;
import com.gjevass.pixels.testapp.app.util.ImageUtil;
import com.gjevass.pixels.testapp.app.util.ScaleFactorCalc;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends Activity {
    private NewsAdapter newsAdapter;
    private float scaleFactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);

        ScaleFactorCalc scaleFactorCalc = new ScaleFactorCalc(R.drawable.news, this);
        scaleFactor = scaleFactorCalc.getScaleFactor();

        ImageView imageViewBackground = (ImageView) findViewById(R.id.imageview_background);
        ListView listView = (ListView) findViewById(R.id.listview);
        ImageView imageViewTop = (ImageView) findViewById(R.id.imageview_top);

        imageViewBackground.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //news_best
        Bitmap bitmapTop = BitmapFactory.decodeResource(getResources(), R.drawable.news_best);
        ImageUtil imageUtil = new ImageUtil(bitmapTop, this);
        Bitmap bitmapTopScalled = Bitmap.createScaledBitmap(bitmapTop, Math.round(imageUtil.getRealWidth() * scaleFactor), Math.round( imageUtil.getRealHeight() * scaleFactor), true);
        imageViewTop.setImageBitmap(bitmapTopScalled);

        ArrayList<ViewModel> imageList = new ArrayList<ViewModel>();

        SprtModel sprtEven = new SprtModel(scaleFactor, R.drawable.news_poster_sprt_0, this);
        SprtModel sprtOdd = new SprtModel(scaleFactor, R.drawable.news_poster_sprt_1, this);

        FrameModel frameEven = new FrameModel(6, 40, 1, scaleFactor, R.drawable.news_poster_frame, this);
        FrameModel frameOdd = new FrameModel(6, 40, -0.7f, scaleFactor, R.drawable.news_poster_frame, this);

        ViewModel viewModelEven = new ViewModel(sprtEven, frameEven);
        ViewModel viewModelOdd = new ViewModel(sprtOdd, frameOdd);

        imageList.add(viewModelEven);
        imageList.add(viewModelOdd);
        imageList.add(viewModelEven);
        imageList.add(viewModelOdd);

        newsAdapter = new NewsAdapter(getApplicationContext(), imageList);
        listView.setAdapter(newsAdapter);

        FrameLayout.LayoutParams listViewLayoutParams = new FrameLayout.LayoutParams(listView.getLayoutParams());
        listViewLayoutParams.setMargins(Math.round(112 * scaleFactor), 0, 0, 0);
        listView.setLayoutParams(listViewLayoutParams);

        PosterTask posterTask = new PosterTask();
        posterTask.execute();
    }

    private class PosterTask extends AsyncTask<Void,Void, List<Bitmap>> {
        private Context context = getApplicationContext();

        @Override
        protected List<Bitmap> doInBackground(Void... voids) {
            JSONParser jsonParser = new JSONParser(context, R.raw.uk_news);
            return jsonParser.getPosters();
        }

        @Override
        protected void onPostExecute(List<Bitmap> posters) {
            super.onPostExecute(posters);

            List<PosterModel> posterModels = new ArrayList<PosterModel>();
            for (int i = 0; i < posters.size(); i++) {
                if(i % 2 == 0) {
                    posterModels.add(new PosterModel( 30, 68, 1, scaleFactor, posters.get(i)));
                }
                else {
                    posterModels.add(new PosterModel( 30, 68, -0.7f, scaleFactor, posters.get(i)));
                }
            }
            newsAdapter.setPosters(posterModels);
            newsAdapter.notifyDataSetChanged();
        }
    }
}
