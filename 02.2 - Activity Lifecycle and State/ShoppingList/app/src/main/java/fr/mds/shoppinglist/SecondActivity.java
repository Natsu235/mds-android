package fr.mds.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_ITEMS = "fr.mds.shoppinglist.extra.ITEMS";

    // Items in Cart
    private static String cart_items = "";

    // Amount of Items in Cart
    public static int nb_cheese = 0;
    public static int nb_rice = 0;
    public static int nb_apple = 0;

    private Button btn_second_cheese;
    private Button btn_second_rice;
    private Button btn_second_apple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_second_cheese = findViewById(R.id.btn_second_cheese);
        btn_second_rice = findViewById(R.id.btn_second_rice);
        btn_second_apple = findViewById(R.id.btn_second_apple);
    }

    // On 'Cheese' Button Clicked...
    public void addCheese(View view) {
        nb_cheese++;
    }

    // On 'Rice' Button Clicked...
    public void addRice(View view) {
        nb_rice++;
    }

    // On 'Apple' Button Clicked...
    public void addApple(View view) {
        nb_apple++;
    }

    // Generate Selected Items List
    public void getItems() {
        if (nb_cheese == 0 && nb_rice == 0 && nb_apple == 0)
            cart_items = "";
        else {
            if (nb_cheese > 0)
                cart_items += "- " + nb_cheese + " Cheese\n";
            if (nb_rice > 0)
                cart_items += "- " + nb_rice + " Rice\n";
            if (nb_apple > 0)
                cart_items += "- " + nb_apple + " Apple\n";
        }
    }

    // Reset Selected Items List
    public void resetItems() {
        nb_cheese = nb_rice = nb_apple = 0;
    }

    // On 'Confirm' Button Clicked...
    public void addToCart(View view) {
        Intent itemsIntent = new Intent();
        getItems();
        itemsIntent.putExtra(EXTRA_ITEMS, cart_items);
        setResult(RESULT_OK, itemsIntent);
        resetItems();
        finish();
    }
}
