package ro.danserboi.homework11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(LOG_TAG, "Verbose Homework 1.1");
        Log.d(LOG_TAG,"Debug Homework 1.1");
        Log.i(LOG_TAG, "Info Homework 1.1");
        Log.w(LOG_TAG, "Warning Homework 1.1");
        Log.e(LOG_TAG, "Error Homework 1.1");
    }
}