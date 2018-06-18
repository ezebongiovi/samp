package com.android.gpsreminder.dtos;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public class TutorialPage {
    @DrawableRes
    public final int icon;
    @StringRes
    public final int description;
    @ColorRes
    public final int backgroundColor;

    public TutorialPage(@DrawableRes final int icon, @StringRes final int description,
                        @ColorRes final int backgroundColor) {
        this.icon = icon;
        this.description = description;
        this.backgroundColor = backgroundColor;
    }
}
