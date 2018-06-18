package com.android.gpsreminder.dtos;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class Reminder implements Parcelable {

    public final String title;
    private final String address;

    public Reminder(@NonNull final String title, @NonNull final String address) {
        this.title = title;
        this.address = address;
    }

    private Reminder(final Parcel in) {
        title = in.readString();
        address = in.readString();
    }

    public static final Creator<Reminder> CREATOR = new Creator<Reminder>() {
        @Override
        public Reminder createFromParcel(final Parcel in) {
            return new Reminder(in);
        }

        @Override
        public Reminder[] newArray(final int size) {
            return new Reminder[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(title);
        dest.writeString(address);
    }
}
