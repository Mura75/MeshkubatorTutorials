package prj.test.secondproject;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int cnt = 0;

    private Button buttonClickMe;
    private Button button2;

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Activiy_lifecycle", "onCreate   " + getResources().getConfiguration().orientation);

        buttonClickMe = (Button)findViewById(R.id.buttonClickMe);
        buttonClickMe.setOnClickListener(this);
        textViewResult = (TextView)findViewById(R.id.textViewResult);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            button2 = (Button)findViewById(R.id.button2);
            button2.setOnClickListener(this);
        }

        if (savedInstanceState != null) {
            cnt = savedInstanceState.getInt("cnt_key");
            textViewResult.setText(cnt + "");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Activiy_lifecycle", "onSaveInstanceState");
        outState.putInt("cnt_key", cnt);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Activiy_lifecycle", "onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activiy_lifecycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activiy_lifecycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activiy_lifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activiy_lifecycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activiy_lifecycle", "onDestroy");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonClickMe) {
            cnt++;
            textViewResult.setText(cnt + "");
        }
        else if (view.getId() == R.id.button2) {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        }

    }
}
