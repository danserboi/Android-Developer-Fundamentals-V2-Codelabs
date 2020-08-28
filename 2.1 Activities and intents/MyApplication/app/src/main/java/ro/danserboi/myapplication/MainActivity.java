package ro.danserboi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    public static final String EXTRA_MESSAGE =
            "ro.danserboi.myapplication.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOne = findViewById(R.id.button_one);
        buttonTwo = findViewById(R.id.button_two);
        buttonThree = findViewById(R.id.button_three);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        if(view == buttonOne) {
            String message = getString(R.string.article_title);
            intent.putExtra(EXTRA_MESSAGE, message);
        }
        if(view == buttonTwo) {
            String message = getString(R.string.article_subtitle);
            intent.putExtra(EXTRA_MESSAGE, message);
        }
        if(view == buttonThree) {
            String message = getString(R.string.article_text);
            intent.putExtra(EXTRA_MESSAGE, message);
        }
        startActivity(intent);
    }
}