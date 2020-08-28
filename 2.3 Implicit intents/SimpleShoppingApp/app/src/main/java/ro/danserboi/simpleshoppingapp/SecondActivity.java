package ro.danserboi.simpleshoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_ITEMS = "ro.danserboi.simpleshoppingapp.extra.ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void selectItem(View view) {
        Intent retIntent = new Intent();

        switch (view.getId()) {
            case R.id.button_cereals:
                retIntent.putExtra(EXTRA_ITEMS, getString(R.string.cereals));
                break;
            case R.id.button_wine:
                retIntent.putExtra(EXTRA_ITEMS, getString(R.string.wine));
                break;
            case R.id.button_pepper:
                retIntent.putExtra(EXTRA_ITEMS, getString(R.string.pepper));
                break;
            case R.id.button_jeans:
                retIntent.putExtra(EXTRA_ITEMS, getString(R.string.jeans));
                break;
            case R.id.button_apples:
                retIntent.putExtra(EXTRA_ITEMS, getString(R.string.apples));
                break;
            case R.id.button_yoghurt:
                retIntent.putExtra(EXTRA_ITEMS, getString(R.string.yoghurt));
                break;
            case R.id.button_shirt:
                retIntent.putExtra(EXTRA_ITEMS, getString(R.string.shirt));
                break;
            case R.id.button_lemmon:
                retIntent.putExtra(EXTRA_ITEMS, getString(R.string.lemmon));
                break;
            case R.id.button_mushrooms:
                retIntent.putExtra(EXTRA_ITEMS, getString(R.string.mushrooms));
                break;
            case R.id.button_kiwi:
                retIntent.putExtra(EXTRA_ITEMS, getString(R.string.kiwi));
                break;
            default:
                break;
        }

        setResult(RESULT_OK, retIntent);
        finish();
    }
}