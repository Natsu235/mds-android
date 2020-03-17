package fr.mds.twoactivitieslifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import fr.mds.twoactivities.R;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "TwoActivities";
    public static final String EXTRA_MESSAGE = "fr.mds.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private EditText et_main_message_text;    // Message Text
    private TextView tv_main_reply_text;      // Reply Text
    private TextView tv_main_reply_header;    // Reply Header

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        et_main_message_text = findViewById(R.id.et_main_message_text);
        tv_main_reply_text = findViewById(R.id.tv_main_reply_text);
        tv_main_reply_header = findViewById(R.id.tv_main_reply_header);

        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");

            if (isVisible) {
                tv_main_reply_header.setVisibility(View.VISIBLE);
                tv_main_reply_text.setText(savedInstanceState.getString("reply_text"));
                tv_main_reply_text.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (tv_main_reply_header.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", tv_main_reply_text.getText().toString());
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button 'Launch Second Activity' clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = et_main_message_text.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                tv_main_reply_text.setText(reply);
            }
        }
    }
}
