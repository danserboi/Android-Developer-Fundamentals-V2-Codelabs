package ro.danserboi.simpleshoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int ITEM_REQUEST = 1;
    public static final String LIST_KEY = "itemsValueStringArray";
    private final TextView[] item = new TextView[10];
    private ArrayList<String> itemsValue = new ArrayList<String>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item[0] = findViewById(R.id.item1);
        item[1] = findViewById(R.id.item2);
        item[2] = findViewById(R.id.item3);
        item[3] = findViewById(R.id.item4);
        item[4] = findViewById(R.id.item5);
        item[5] = findViewById(R.id.item6);
        item[6] = findViewById(R.id.item7);
        item[7] = findViewById(R.id.item8);
        item[8] = findViewById(R.id.item9);
        item[9] = findViewById(R.id.item10);
        if (savedInstanceState != null) {
            itemsValue = savedInstanceState.getStringArrayList(LIST_KEY);
            if (itemsValue != null) {
                for (int i = 0; i < itemsValue.size(); i++) {
                    item[i].setVisibility(View.VISIBLE);
                    item[i].setText(itemsValue.get(i));
                }
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (itemsValue.size() != 0) {
            outState.putStringArrayList(LIST_KEY, itemsValue);
        }
    }

    public void addItem(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, ITEM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ITEM_REQUEST) {
            if (resultCode == RESULT_OK) {
                String itemString = data.getStringExtra(SecondActivity.EXTRA_ITEMS);
                if (itemsValue.size() < 10) {
                    itemsValue.add(itemString);
                } else {
                    Toast.makeText(MainActivity.this, "The maximum number of items is 10 !", Toast.LENGTH_LONG).show();
                }
                for (int i = 0; i < itemsValue.size(); i++) {
                    item[i].setVisibility(View.VISIBLE);
                    item[i].setText(itemsValue.get(i));
                }

            }
        }
    }
}