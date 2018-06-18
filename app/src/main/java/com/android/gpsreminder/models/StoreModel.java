package com.android.gpsreminder.models;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.android.gpsreminder.dtos.Reminder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressLint("StaticFieldLeak")
public final class StoreModel {
    private static final String PREF_NAME = "account";
    private static final String PREF_REMINDER = "reminder";
    private static final Gson GSON = new Gson();
    private static StoreModel INSTANCE;
    private final Context context;

    private StoreModel(@NonNull final Context context) {
        this.context = context;
    }

    public static StoreModel getInstance(@NonNull final Context context) {
        if (INSTANCE == null) {
            INSTANCE = new StoreModel(context);
        }

        return INSTANCE;
    }

    public void saveRemind(@NonNull final Reminder reminder) {
        final List<Reminder> reminders = getReminders();
        reminders.add(reminder);

        context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE).edit()
                .putString(PREF_REMINDER, GSON.toJson(reminders)).apply();
    }

    public List<Reminder> getReminders() {
        final Type type = new TypeToken<ArrayList<Reminder>>() {}.getType();
        final ArrayList<Reminder> reminders = GSON.fromJson(context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE)
                .getString(PREF_REMINDER, null), type);

        return reminders == null ? new ArrayList<Reminder>() : reminders;
    }
}
