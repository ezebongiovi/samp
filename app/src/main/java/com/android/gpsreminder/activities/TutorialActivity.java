package com.android.gpsreminder.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.gpsreminder.R;
import com.android.gpsreminder.adapters.TutorialAdapter;
import com.android.gpsreminder.dtos.TutorialPage;
import com.android.gpsreminder.widgets.PageIndicator;

import java.util.ArrayList;
import java.util.List;

public class TutorialActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        final List<TutorialPage> mPages = new ArrayList<>();
        mPages.add(new TutorialPage(R.drawable.vector_flat_map, R.string.tutorial_page_first, R.color.colorLightBlueDark));
        mPages.add(new TutorialPage(R.drawable.vector_flat_map, R.string.tutorial_page_first, R.color.colorCyanDark));
        mPages.add(new TutorialPage(R.drawable.vector_flat_map, R.string.tutorial_page_first, R.color.colorTeal));

        setStatusBarColor(mPages.get(0).backgroundColor);

        final ViewPager mViewPager = findViewById(R.id.viewPager);
        mViewPager.setAdapter(new TutorialAdapter(mPages));
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onPageSelected(final int position) {
                super.onPageSelected(position);
                setStatusBarColor(mPages.get(position).backgroundColor);
            }
        });

        final PageIndicator pageIndicator = findViewById(R.id.pageIndicator);
        pageIndicator.attach(mViewPager);

        findViewById(R.id.continueButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(new Intent(TutorialActivity.this, RemindersListActivity.class));
                finish();
            }
        });
    }

    private void setStatusBarColor(final int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(color));
        }
    }
}
