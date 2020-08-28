package ro.danserboi.drawabletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private int imageLevel = 0;
    private final String LEVEL = "CURR_LEVEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.battery_image);
        if(savedInstanceState != null) {
            imageLevel = savedInstanceState.getInt(LEVEL);
        }
        image.setImageLevel(imageLevel);
    }

    public void changeBatteryLevel(View view) {
        switch (view.getId()){
            case R.id.decrease_btn:
                if (imageLevel > 0){
                    imageLevel --;
                    image.setImageLevel(imageLevel);
                }
                break;
            case R.id.increase_btn:
                if (imageLevel < 7){
                    imageLevel ++;
                    image.setImageLevel(imageLevel);
                }
                break;
            default: break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(LEVEL, imageLevel);
        super.onSaveInstanceState(outState);
    }
}
