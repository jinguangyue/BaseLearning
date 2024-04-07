package com.example.myalgorithm.touchevent;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.myalgorithm.R;

public class TestTouchEventActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_view_touch);
    }
}
