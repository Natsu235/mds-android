package fr.mds.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import fr.mds.hellotoast.R;

public class MainActivity extends AppCompatActivity {

    private int count = 0;                     // Toast Count Number
    private TextView tv_main_show_count;       // Show Count View
    private TextView btn_main_button_zero;     // Zero Button
    private TextView btn_main_button_count;    // Count Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_main_show_count = (TextView) findViewById(R.id.show_count);
        btn_main_button_zero = (TextView) findViewById(R.id.button_zero);
        btn_main_button_count = (TextView) findViewById(R.id.button_count);
    }

    // On "Toast" Button CLicked...
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    // On "Zero" Button CLicked...
    public void resetCount(View view) {
        count = 0;
        resetBackgroundColors();
    }

    // On "Count" Button CLicked...
    public void countUp(View view) {
        count++;
        btn_main_button_zero.setBackgroundColor(Color.RED);

        if (tv_main_show_count != null)
            tv_main_show_count.setText(Integer.toString(count));
        if (count % 2 == 0)
            btn_main_button_count.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        else
            btn_main_button_count.setBackgroundColor(Color.GREEN);
    }

    public void resetBackgroundColors() {
        btn_main_button_zero.setBackgroundColor(Color.GRAY);
        btn_main_button_count.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }
}
