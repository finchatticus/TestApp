package com.gjevass.pixels.testapp.app.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.gjevass.pixels.testapp.app.R;
import com.gjevass.pixels.testapp.app.model.PosterModel;
import com.gjevass.pixels.testapp.app.model.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<ViewModel> imageList = new ArrayList<ViewModel>();
    private List<PosterModel> posters = null;

    public NewsAdapter(Context context, List<ViewModel> imageList) {
        this.imageList = imageList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public ViewModel getItem(int i) {
        return imageList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = layoutInflater.inflate(R.layout.item_news, viewGroup, false);
        }
        ViewModel viewModel = getItem(i);

        ImageView imageViewBackground = (ImageView) view.findViewById(R.id.image_view_item_background);
        ImageView imageViewNws = (ImageView) view.findViewById(R.id.image_view_nws);
        ImageView imageViewFrame = (ImageView) view.findViewById(R.id.image_view_frame);

        imageViewBackground.setImageBitmap(viewModel.getBitmapSprt());

        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(imageViewFrame.getLayoutParams());
        lp.setMargins(viewModel.getFrameModel().getMarginLeft(), viewModel.getFrameModel().getMarginTop(), 0, 0);
        imageViewFrame.setLayoutParams(lp);
        imageViewFrame.setRotation(viewModel.getFrameModel().getRotate());
        imageViewFrame.setImageBitmap(viewModel.getBitmapFrame());

        if (posters != null) {
            //poster
            PosterModel posterModel = posters.get(i);
            FrameLayout.LayoutParams lp0 = new FrameLayout.LayoutParams(imageViewNws.getLayoutParams());
            lp0.setMargins(posterModel.getMarginLeft(), posterModel.getMarginTop(), 0, 0);
            imageViewNws.setLayoutParams(lp0);
            imageViewNws.setRotation(posterModel.getRotate());
            imageViewNws.setImageBitmap(posterModel.getBitmap());
        }
        return view;
    }

    public void setPosters(List<PosterModel> posters) {
        this.posters = posters;
    }

}
