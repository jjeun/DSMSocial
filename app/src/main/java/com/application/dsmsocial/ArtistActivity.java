package com.application.dsmsocial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);


        String name = getIntent().getStringExtra("title");
        Bitmap image = getIntent().getParcelableExtra("image");
        int page = getIntent().getIntExtra("switch", 0);

        if (page == 1) {
            TextView titleTextView = (TextView) findViewById(R.id.artistName);
            titleTextView.setText(name);

            ImageView imageView = (ImageView) findViewById(R.id.artistImage);
            imageView.setImageBitmap(image);
        }
        else{
            TextView titleTextView = (TextView) findViewById(R.id.artistName);
            titleTextView.setText(R.string.featureArtist);

            ImageView imageView = (ImageView) findViewById(R.id.artistImage);
            imageView.setImageResource(R.drawable.dmsc);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_artist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // switch statement to navigate up back to the fragment. Pops from stack.
        switch (item.getItemId()) {
            case android.R.id.home:

                NavUtils.navigateUpTo(this,
                        new Intent(this, ArtistActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
