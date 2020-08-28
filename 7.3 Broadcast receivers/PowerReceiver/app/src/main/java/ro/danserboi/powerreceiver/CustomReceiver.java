package ro.danserboi.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    private static final String EXTRA_RANDOM_NUMBER = BuildConfig.APPLICATION_ID + ".RANDOM_NUMBER";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        Integer number = null;
        if(intentAction.equals(ACTION_CUSTOM_BROADCAST)) {
            String stringNumber = intent.getStringExtra(EXTRA_RANDOM_NUMBER);
            number = Integer.valueOf(stringNumber);
        }
        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    int state = intent.getIntExtra("state", -1);
                    switch (state) {
                        case 0:
                            toastMessage = "Headset is unplugged";
                            break;
                        case 1:
                            toastMessage = "Headset is plugged";
                            break;
                        default:
                            toastMessage = "I have no idea what the headset state is";
                    }
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = "Custom Broadcast Received";
                    break;
            }

            //Display the toast.
            if(toastMessage.equals("Custom Broadcast Received"))
                Toast.makeText(context, toastMessage + "\n Square of the number is "
                    + number * number, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show();
        }
    }
}
