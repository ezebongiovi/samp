package com.android.gpsreminder.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.gpsreminder.R;
import com.android.gpsreminder.adapters.holders.RemindersViewHolder;
import com.android.gpsreminder.dtos.Reminder;

import java.util.ArrayList;
import java.util.List;

public class RemindersAdapter extends RecyclerView.Adapter<RemindersViewHolder> {

    private final List<Reminder> reminderList = new ArrayList<>();
    private int selectedPosition = -1;

    public RemindersAdapter(@NonNull final List<Reminder> reminderList) {
        this.reminderList.clear();
        this.reminderList.addAll(reminderList);
    }

    @NonNull
    @Override
    public RemindersViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                  final int viewType) {
        return new RemindersViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final RemindersViewHolder holder,
                                 final int position) {
        holder.onBind(reminderList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final int oldPosition = selectedPosition;

                if (selectedPosition == holder.getAdapterPosition()) {
                    selectedPosition = -1;
                } else {
                    selectedPosition = holder.getAdapterPosition();
                }
                final int startPosition = oldPosition < selectedPosition ? oldPosition : selectedPosition;
                final int endPosition = oldPosition < selectedPosition ? selectedPosition : oldPosition;

                notifyItemRangeChanged(startPosition == -1 ? 0 : startPosition, startPosition == -1 ? 1 : endPosition);
            }
        });
    }

    @Override
    public int getItemViewType(final int position) {
        return position == selectedPosition ? R.layout.holder_selected_reminder : R.layout.holder_reminder;
    }

    @Override
    public int getItemCount() {
        return reminderList.size();
    }
}
