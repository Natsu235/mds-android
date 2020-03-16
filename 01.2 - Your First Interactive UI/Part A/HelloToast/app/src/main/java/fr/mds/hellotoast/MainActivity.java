package fr.mds.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;             // Toast Count Number
    private TextView tv_main_show_count;    // Show Count TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_main_show_count = (TextView) findViewById(R.id.show_count);
    }

    // On "Toast" Button CLicked...
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    // On "Count" Button CLicked...
    public void countUp(View view) {
        count++;
        if (tv_main_show_count != null)
            tv_main_show_count.setText(Integer.toString(count));
    }
}
