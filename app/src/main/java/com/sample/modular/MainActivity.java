package com.sample.modular;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sample.modular.moduleb.ModuleBHelper;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ModuleBHelper moduleBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result = findViewById(R.id.result);

        moduleBHelper = new ModuleBHelper(getApplicationContext());

        findViewById(R.id.sum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Calling sum");
                result.setText("Sum result : " + moduleBHelper.calculateSum(10, 20));
            }
        });
        findViewById(R.id.concatenate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Calling concatenate");
                result.setText("Concatenation result : " + moduleBHelper.concatenate("Hello-", "World!"));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        moduleBHelper.bind();
        Log.d(TAG, "Calling bind");
    }

    @Override
    protected void onStop() {
        super.onStop();
        moduleBHelper.unbind();
        Log.d(TAG, "Calling unbind");
    }
}
