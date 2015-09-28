package com.application.dsmsocial;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {
    private static final String TAG = "ArtistBioTag";
    final Context context = this;
    private GridView gridView;
    private GridViewAdapter gridAdapter;

    String name;
    String type;
    Bitmap image;
    int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);


        name = getIntent().getStringExtra("name");
        type = getIntent().getStringExtra("type");
        image = getIntent().getParcelableExtra("image");
        page = getIntent().getIntExtra("switch", 0);

        if (page == 1) {
            TextView titleTextView = (TextView) findViewById(R.id.artistName);
            TextView titleTextView2 = (TextView) findViewById(R.id.artistType);
            titleTextView.setGravity(Gravity.CENTER_HORIZONTAL);
            titleTextView.setText(name);
            titleTextView2.setGravity(Gravity.CENTER_HORIZONTAL);
            titleTextView2.setText(type);

            ImageView imageView = (ImageView) findViewById(R.id.artistImage);
            imageView.setImageBitmap(image);
        }
        else{
            TextView titleTextView = (TextView) findViewById(R.id.artistName);
            titleTextView.setGravity(Gravity.CENTER_HORIZONTAL);
            titleTextView.setText(R.string.featureArtist);

            TextView titleTextView2 = (TextView) findViewById(R.id.artistType);
            titleTextView2.setGravity(Gravity.CENTER_HORIZONTAL);
            titleTextView2.setTextSize(15);
            titleTextView2.setPadding(0,20,0,0);
            titleTextView2.setText(name);

            ImageView imageView = (ImageView) findViewById(R.id.artistImage);
            imageView.setImageResource(R.drawable.artist1);
        }

        gridView = (GridView) findViewById(R.id.artistBioGridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Log.v(TAG, "artist bio clicked");
                ImageItem item = (ImageItem) gridView.getItemAtPosition(position);

                Intent intent = new Intent(context, ShopActivity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("image", item.getImage());
                intent.putExtra("type", item.getType());
                intent.putExtra("name", item.getName());
                startActivity(intent);
            }
        });
    }


    // Prepare some dummy data for shopGridview
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.lyndsay);

        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap,null, name, null,null));
        }
        return imageItems;
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
