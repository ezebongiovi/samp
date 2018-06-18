package com.android.gpsreminder.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.android.gpsreminder.R;
import com.android.gpsreminder.dtos.Reminder;
import com.android.gpsreminder.models.StoreModel;

public class CreateReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reminder);

        if (getIntent().getData() != null) {
            System.out.println(getIntent().getData().getQueryParameter("redirect_link"));
        }

        final EditText editText = findViewById(R.id.editText);
        findViewById(R.id.continueButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                StoreModel.getInstance(CreateReminderActivity.this)
                        .saveRemind(new Reminder(editText.getText().toString(), "Bernardo de irigoyen"));
                finish();
            }
        });
    }
}
