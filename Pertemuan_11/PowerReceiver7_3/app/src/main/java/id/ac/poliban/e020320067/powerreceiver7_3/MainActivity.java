package id.ac.poliban.e020320067.powerreceiver7_3;

import static java.util.Calendar.getInstance;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private final CustomReceiver mReceiver = new CustomReceiver();

    // String constant that defines the custom broadcast Action.
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        // Define the IntentFilter.
        IntentFilter filter = new IntentFilter();
        // Add system broadcast actions sent by the system when the power is
        // connected and disconnected.
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        // Register the receiver using the activity context, passing in the
        // IntentFilter.
        this.registerReceiver(mReceiver, filter);

        // Register the receiver to receive custom broadcast.
        Calendar LocalBroadcastManager = null;
        assert LocalBroadcastManager != null;
        getInstance(this).registerReceiver
                (mReceiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));
    }

    private MainActivity getInstance(MainActivity mainActivity) {
        return null;
    }

    private void registerReceiver(CustomReceiver mReceiver, IntentFilter filter) {
    }

    private void setContentView(int activity_main) {
    }

    /**
     * Click event handler for the button, that sends custom broadcast using the
     * LocalBroadcastManager.
     */
    public void sendCustomBroadcast(View view) {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        Calendar LocalBroadcastManager;
        getInstance(this)
                .sendBroadcast(customBroadcastIntent);
    }

    private void sendBroadcast(Intent customBroadcastIntent) {
    }

    /**
     * Unregisters the broadcast receivers when the app is destroyed.
     */
    @Override
    protected void onDestroy() {
        // Unregister the receivers.
        this.unregisterReceiver(mReceiver);

        Calendar LocalBroadcastManager = null;
        assert LocalBroadcastManager != null;
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
    }

    private void unregisterReceiver(CustomReceiver mReceiver) {
    }

}