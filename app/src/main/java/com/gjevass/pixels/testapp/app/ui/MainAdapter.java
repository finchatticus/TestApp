package com.gjevass.pixels.testapp.app.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.gjevass.pixels.testapp.app.NewsActivity;
import com.gjevass.pixels.testapp.app.R;
import com.gjevass.pixels.testapp.app.model.BackgroundImage;
import com.gjevass.pixels.testapp.app.model.ElementImage;
import com.gjevass.pixels.testapp.app.viewholder.ViewHolder;

import java.util.List;

public class MainAdapter extends BaseAdapter {

    private List<BackgroundImage> listBackground;
    private List<ElementImage> elementImageList;
    private LayoutInflater layoutInflater;
    private Context context;

    public MainAdapter(Context context, List<BackgroundImage> listBackground) {
        this.listBackground = listBackground;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listBackground.size();
    }

    @Override
    public BackgroundImage getItem(int i) {
        return listBackground.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        if(listBackground.get(position).getType() == ViewType.EMPTY) {
            return ViewType.EMPTY.getType();
        }
        else if(listBackground.get(position).getType() == ViewType.PART1) {
            return ViewType.PART1.getType();
        }
        else {
            return ViewType.PART2.getType();
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder.EmptyViewHolder emptyViewHolder;
        ViewHolder.Part1ViewHolder part1ViewHolder;
        ViewHolder.Part2ViewHolder part2ViewHolder;

        int type = getItemViewType(i);

        BackgroundImage backgroundImage = getItem(i);

        if(type == ViewType.EMPTY.getType()) {
            view = layoutInflater.inflate(R.layout.item_empty, parent, false);
            emptyViewHolder = new ViewHolder().new EmptyViewHolder();
            emptyViewHolder.imageViewBackround = (ImageView)  view.findViewById(R.id.image_empty_background);

            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(emptyViewHolder.imageViewBackround.getLayoutParams());
            lp.setMargins(0, backgroundImage.getMarginTop(), 0 , backgroundImage.getMarginBottom());
            emptyViewHolder.imageViewBackround.setLayoutParams(lp);
            emptyViewHolder.imageViewBackround.setImageBitmap(backgroundImage.getBitmap());

            emptyViewHolder.imageViewBackround.setImageBitmap(listBackground.get(i).getBitmap());
        }
        else if(type == ViewType.PART1.getType()) {
            view = layoutInflater.inflate(R.layout.item_part1, parent, false);
            part1ViewHolder = new ViewHolder().new Part1ViewHolder();
            part1ViewHolder.imageViewBackground = (ImageView)  view.findViewById(R.id.image_part1_background);
            part1ViewHolder.imageViewEl0 = (ElementImageView) view.findViewById(R.id.element_part1_image0);
            part1ViewHolder.imageViewEl1 = (ElementImageView) view.findViewById(R.id.element_part1_image1);
            part1ViewHolder.imageViewEl2 = (ElementImageView) view.findViewById(R.id.element_part1_image2);
            part1ViewHolder.imageViewEl3 = (ElementImageView) view.findViewById(R.id.element_part1_image3);
            part1ViewHolder.imageViewEl4 = (ElementImageView) view.findViewById(R.id.element_part1_image4);

            part1ViewHolder.imageViewBackground.setImageBitmap(backgroundImage.getBitmap());

            if(elementImageList != null) {
                part1ViewHolder.imageViewEl0.setElementImage(elementImageList.get(0));
                part1ViewHolder.imageViewEl1.setElementImage(elementImageList.get(2));
                part1ViewHolder.imageViewEl2.setElementImage(elementImageList.get(1));
                part1ViewHolder.imageViewEl3.setElementImage(elementImageList.get(3));
                part1ViewHolder.imageViewEl4.setElementImage(elementImageList.get(4));
                part1ViewHolder.imageViewEl4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, NewsActivity.class);
                        context.startActivity(intent);
                    }
                });
            }
        }
        else {
            view = layoutInflater.inflate(R.layout.item_part2, parent, false);
            part2ViewHolder = new ViewHolder().new Part2ViewHolder();
            part2ViewHolder.imageViewBackground = (ImageView)  view.findViewById(R.id.image_part2_background);
            part2ViewHolder.imageViewEl0 = (ElementImageView) view.findViewById(R.id.element_part2_image0);
            part2ViewHolder.imageViewEl1 = (ElementImageView) view.findViewById(R.id.element_part2_image1);
            part2ViewHolder.imageViewEl2 = (ElementImageView) view.findViewById(R.id.element_part2_image2);
            part2ViewHolder.imageViewEl3 = (ElementImageView) view.findViewById(R.id.element_part2_image3);
            part2ViewHolder.imageViewEl4 = (ElementImageView) view.findViewById(R.id.element_part2_image4);

            part2ViewHolder.imageViewBackground.setImageBitmap(backgroundImage.getBitmap());

            if(elementImageList != null) {
                part2ViewHolder.imageViewEl0.setElementImage(elementImageList.get(5));
                part2ViewHolder.imageViewEl1.setElementImage(elementImageList.get(6));
                part2ViewHolder.imageViewEl2.setElementImage(elementImageList.get(7));
                part2ViewHolder.imageViewEl3.setElementImage(elementImageList.get(8));
            }
        }

        return view;
    }

    public void setElementImageList(List<ElementImage> elementImageList) {
        this.elementImageList = elementImageList;
    }
}
