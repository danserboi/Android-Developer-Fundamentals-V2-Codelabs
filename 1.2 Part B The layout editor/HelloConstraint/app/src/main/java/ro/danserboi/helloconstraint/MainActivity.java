package ro.danserboi.helloconstraint;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button zeroButton;
    private Button countButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        zeroButton = (Button) findViewById(R.id.button_zero);
        countButton = (Button) findViewById(R.id.button_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;

        if(mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            if(mCount % 2 == 1)
                view.setBackgroundColor(Color.CYAN);
            else
                view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
        if(zeroButton != null)
            zeroButton.setBackgroundColor(Color.MAGENTA);
    }

    public void reset(View view) {
        mCount = 0;
        if(mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if(zeroButton != null)
            zeroButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray));
        if(countButton != null)
            countButton.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }
}