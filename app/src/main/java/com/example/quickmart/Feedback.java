package com.example.quickmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quickmart.ui.feedback.FeedbackFragment;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FeedbackFragment.newInstance())
                    .commitNow();
        }
    }
}