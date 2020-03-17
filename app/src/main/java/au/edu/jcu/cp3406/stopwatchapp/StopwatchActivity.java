package au.edu.jcu.cp3406.stopwatchapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;


public class StopwatchActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private Stopwatch stopwatch;
    private TextView timeText;
    private boolean isRunning;
    private int speedMultiplier = 1;
    private int delayValue = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText = findViewById(R.id.timeText);
        isRunning = false;

        if (savedInstanceState == null) {
            stopwatch = new Stopwatch();
        } else {
            stopwatch = new Stopwatch(Objects.requireNonNull(savedInstanceState.getString("timeText")));
            boolean running = savedInstanceState.getBoolean("running");
            if (running) {
                enableStopwatch();
            }
        }
        timeText.setText(stopwatch.toString());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("timeText", stopwatch.toString());
        outState.putBoolean("running", isRunning);
//        outState.putInt("speedMultiplier", speedMultiplier);
    }

    public void buttonClicked(View view) {
        if (!isRunning) {
            enableStopwatch();
        } else {
            disableStopwatch();
        }
    }

    private void enableStopwatch() {
        isRunning = true;
        handler.post(new Runnable() {

            @Override
            public void run() {

                if (isRunning) {
                    stopwatch.tick();
                    timeText.setText(stopwatch.toString());
                    handler.postDelayed(this, delayValue / speedMultiplier);
                }
            }
        });
    }

    private void disableStopwatch() {
        isRunning = false;
    }

    public void settingsClicked(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivityForResult(intent, SettingsActivity.SETTINGS_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SettingsActivity.SETTINGS_REQUEST) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    speedMultiplier = data.getIntExtra("speedMultiplier", 1);
                }
            }
        }
    }
}
