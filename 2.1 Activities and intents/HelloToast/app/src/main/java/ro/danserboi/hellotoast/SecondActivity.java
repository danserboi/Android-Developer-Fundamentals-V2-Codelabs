package ro.danserboi.hellotoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.text_view);
        Intent intent = getIntent();
        int count = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, -1);
        textView.setText("Hello !\n" + count);
    }
}