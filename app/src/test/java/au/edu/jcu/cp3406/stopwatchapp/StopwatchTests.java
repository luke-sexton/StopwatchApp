package au.edu.jcu.cp3406.stopwatchapp;

import android.os.Bundle;
import android.os.storage.StorageManager;
import android.widget.TextView;

import org.junit.Test;
import org.w3c.dom.Text;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class StopwatchTests {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testConstructor() {
        Stopwatch stopwatch = new Stopwatch();
        assertEquals("00:00:00", stopwatch.toString());
    }

    @Test
    public void testNewConstructor() {
        String timeString = "00:00:01";
        Stopwatch stopwatch = new Stopwatch(timeString);

        assertEquals(timeString, stopwatch.toString());
    }

    @Test
    public void testTicker() {
        Stopwatch stopwatch = new Stopwatch();

        stopwatch.tick();
        assertEquals("00:00:01", stopwatch.toString());

        for (int i = 0; i < 59; ++i) {
            stopwatch.tick();
        }
        assertEquals("00:01:00", stopwatch.toString());

        for (int i = 0; i < 59 * 60; ++i) {
            stopwatch.tick();
        }
        assertEquals("01:00:00", stopwatch.toString());
    }




}