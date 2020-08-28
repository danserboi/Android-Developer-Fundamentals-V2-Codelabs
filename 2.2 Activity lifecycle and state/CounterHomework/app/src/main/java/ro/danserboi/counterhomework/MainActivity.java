package ro.danserboi.counterhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String KEY = "count_value";
    private TextView countTextView;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countTextView = findViewById(R.id.count_textView);
        if (savedInstanceState != null) {
            String savedCount = savedInstanceState.getString(KEY);
            if(savedCount != null) {
                countTextView.setText(savedCount);
                count = Integer.parseInt(savedCount);
            }
        }
    }

    public void increment(View view) {
        count++;
        countTextView.setText(String.valueOf(count));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY, countTextView.getText().toString());
    }
}