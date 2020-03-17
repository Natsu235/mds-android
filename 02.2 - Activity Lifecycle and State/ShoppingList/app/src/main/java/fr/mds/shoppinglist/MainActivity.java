package fr.mds.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int ITEM_REQUEST = 1;

    private TextView tv_main_cart_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_main_cart_items = findViewById(R.id.tv_main_cart_items);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ITEM_REQUEST) {
            if (resultCode == RESULT_OK) {
                String items = data.getStringExtra(SecondActivity.EXTRA_ITEMS);
                tv_main_cart_items.setText(items);
            }
        }
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, ITEM_REQUEST);
    }

    // On 'Reset' Button Clicked...
    public void resetCart(View view) {
        tv_main_cart_items.setText("");
    }
}
