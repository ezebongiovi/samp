package com.android.gpsreminder.adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.gpsreminder.R;
import com.android.gpsreminder.dtos.TutorialPage;

import java.util.List;

public class TutorialAdapter extends PagerAdapter {

    private final List<TutorialPage> mPages;

    public TutorialAdapter(@NonNull final List<TutorialPage> pages) {
        mPages = pages;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        final View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.view_page_tutorial, container, false);

        container.addView(view);

        view.findViewById(R.id.rootView).setBackgroundColor(container.getContext().getResources()
                .getColor(mPages.get(position).backgroundColor));

        ((ImageView) view.findViewById(R.id.iconView)).setImageResource(mPages.get(position).icon);
        ((TextView) view.findViewById(R.id.descriptionView)).setText(mPages.get(position).description);

        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull final View view, @NonNull final Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull final ViewGroup container, final int position,
                            @NonNull final Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mPages.size();
    }
}
