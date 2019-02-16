package pk.edu.pucit.munib.mcassignment2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActvity","onCreate() is called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActvity","onStart() is called");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActvity","onResume() is called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActvity","onPause() is called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActvity","onStop() is called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActvity","onDestroy() is called");

    }
}
