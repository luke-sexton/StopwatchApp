package au.edu.jcu.cp3406.stopwatchapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class SettingsActivity extends Activity {
    public static final int SETTINGS_REQUEST = 1;
    private SeekBar speedBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        speedBar = findViewById(R.id.speedBar);
        speedBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(), "Speed Multiplier: " + progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void doneClicked(View view) {
        int speedMultiplier = speedBar.getProgress();
        System.out.println(speedMultiplier);

        Intent intent = new Intent();
        intent.putExtra("speedMultiplier", speedMultiplier);
        setResult(RESULT_OK, intent);
        finish();
    }


}
