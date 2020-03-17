package fr.mds.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String ImplicitIntents = "Implicit Intents";

    private EditText et_main_website;
    private EditText et_main_location;
    private EditText et_main_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_main_website = findViewById(R.id.et_main_website);
        et_main_location = findViewById(R.id.et_main_location);
        et_main_share = findViewById(R.id.et_main_share);
    }

    // On 'Open Website' Button Clicked...
    public void openWebsite(View view) {
        String url = et_main_website.getText().toString();

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
        else
            Log.d("ImplicitIntents", "Invalid Intent!");
    }

    // On 'Open Location' Button Clicked...
    public void openLocation(View view) {
        String loc = et_main_location.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
        else
            Log.d("ImplicitIntents", "Invalid Intent!");
    }

    // On 'Open Website' Button Clicked...
    public void shareText(View view) {
        String txt = et_main_share.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder.from(this).setType(mimeType).setChooserTitle(R.string.share_text).setText(txt).startChooser();
    }
}
