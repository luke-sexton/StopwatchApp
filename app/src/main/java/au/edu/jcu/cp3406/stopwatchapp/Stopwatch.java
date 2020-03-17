package au.edu.jcu.cp3406.stopwatchapp;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

class Stopwatch {
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;


    Stopwatch() {
    }

    Stopwatch(String value) {
        hours += Integer.parseInt(value.substring(0, 2));
        minutes += Integer.parseInt(value.substring(3, 5));
        seconds += Integer.parseInt(value.substring(6));
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    void tick() {
        final int maximum = 59;
        int tickValue = 1;
        if (seconds < maximum) {
            seconds += tickValue;
        } else {
            seconds = 0;
            if (minutes < maximum) {
                minutes += tickValue;
            } else {
                minutes = 0;
                hours += tickValue;
            }
        }
    }
}
