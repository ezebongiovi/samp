package com.android.gpsreminder.adapters.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.gpsreminder.R;
import com.android.gpsreminder.dtos.Reminder;

public class RemindersViewHolder extends RecyclerView.ViewHolder {
    public RemindersViewHolder(@NonNull final View itemView) {
        super(itemView);
    }

    public void onBind(final Reminder reminder) {
        ((TextView) itemView.findViewById(R.id.titleView)).setText(reminder.title);
    }
}
