package fr.mds.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "TwoActivities";
    public static final String EXTRA_MESSAGE = "fr.mds.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private EditText et_main_message_text;    // Message Text
    private TextView tv_main_reply_text;      // Reply Text

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_main_message_text = findViewById(R.id.et_main_message_text);
        tv_main_reply_text = findViewById(R.id.tv_main_reply_text);
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
