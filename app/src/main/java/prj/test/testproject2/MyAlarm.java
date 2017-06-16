package prj.test.testproject2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Murager on 6/9/17.
 */

public class MyAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Start", Toast.LENGTH_SHORT).show();
        Log.d("Timer_off_br", "My alarm start");

        Intent intent1 = new Intent(context.getApplicationContext(), MyService.class);
        context.getApplicationContext().stopService(intent1);
    }
}
