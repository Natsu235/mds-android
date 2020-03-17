package fr.mds.twoactivitieslifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import fr.mds.twoactivities.R;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = "TwoActivities";
    public static final String EXTRA_REPLY = "fr.mds.twoactivities.extra.REPLY";

    private EditText et_second_reply_text;      // Reply Text
    private TextView tv_second_message_text;    // Message Text

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et_second_reply_text = findViewById(R.id.et_second_reply_text);
        tv_second_message_text = findViewById(R.id.tv_second_message_text);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        tv_second_message_text.setText(message);
    }

    public void returnReply(View view) {
        String reply = et_second_reply_text.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }
}
