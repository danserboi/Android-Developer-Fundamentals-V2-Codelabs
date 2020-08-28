package ro.danserboi.checkboxes_and_etc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String message = "Toppings:";
    CheckBox syrup;
    CheckBox sprinkles;
    CheckBox crushedNuts;
    CheckBox cherries;
    CheckBox oreo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        syrup = (CheckBox) findViewById(R.id.check_syrup);
        sprinkles = (CheckBox) findViewById(R.id.check_sprinkles);
        crushedNuts = (CheckBox) findViewById(R.id.check_crushed_nuts);
        cherries = (CheckBox) findViewById(R.id.check_cherries);
        oreo = (CheckBox) findViewById(R.id.check_oreo);
    }

    public void toastMessage(View view) {
        checkToppings(syrup, getString(R.string.syrup));
        checkToppings(sprinkles, getString(R.string.sprinkles));
        checkToppings(crushedNuts, getString(R.string.crushed_nuts));
        checkToppings(cherries, getString(R.string.cherries));
        checkToppings(oreo, getString(R.string.oreo));
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void checkToppings(CheckBox checkBox, String topping){
        if (checkBox.isChecked()){
            if (!message.contains(topping)){
                message = message + " " + topping;
            }
        }
        else{
            if (message.contains(topping)){
                message = message.replace(" " + topping, "");
            }
        }
    }
}
