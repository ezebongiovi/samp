package com.android.gpsreminder.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.android.gpsreminder.R;


public class PageIndicator extends LinearLayout implements ViewPager.OnPageChangeListener {

    private static final float ALPHA_UNSELECTED = 0.41f;
    private static final float ALPHA_SELECTED = 1f;
    private View[] mViews;

    /**
     * Default constructor
     *
     * @param context the application's context
     */
    public PageIndicator(@NonNull final Context context) {
        this(context, null);
    }

    /**
     * @param context the application's context
     * @param attrs   the attributes
     */
    public PageIndicator(@NonNull final Context context, @Nullable final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context      the applitacion's context
     * @param attrs        the view's attributes
     * @param defStyleAttr the style attributes
     */
    public PageIndicator(@NonNull final Context context, @Nullable final AttributeSet attrs,
                         final int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.widget_page_indicator, this);
    }

    /**
     * Attaches the view pager to the page indicator
     *
     * @param viewPager the viewPager where's being attached to
     */
    public void attach(@NonNull final ViewPager viewPager) {
        viewPager.addOnPageChangeListener(this);
        mViews = new View[viewPager.getAdapter().getCount()];

        for (int i = 0; i < viewPager.getAdapter().getCount(); i++) {

            final View view = LayoutInflater.from(getContext())
                    .inflate(R.layout.widget_page_circle_indicator, this, false);

            addView(view);

            mViews[i] = view;
        }

        setSelected(viewPager.getCurrentItem());
    }

    private void setSelected(final int position) {

        for (int i = 0; i < mViews.length; i++) {
            if (i == position) {
                mViews[i].setAlpha(ALPHA_SELECTED);
            } else {
                mViews[i].setAlpha(ALPHA_UNSELECTED);
            }
        }
    }

    @Override
    public void onPageScrolled(final int position, final float positionOffset,
                               final int positionOffsetPixels) {
        // Nothing to do
    }

    @Override
    public void onPageSelected(final int position) {
        setSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(final int state) {
        // Nothing to do
    }
}