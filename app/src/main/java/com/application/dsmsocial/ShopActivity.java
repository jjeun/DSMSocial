package com.application.dsmsocial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity {
    private static final String TAG = "ShopTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        String name = getIntent().getStringExtra("title");
        Bitmap image = getIntent().getParcelableExtra("image");

//        TextView titleTextView = (TextView) findViewById(R.id.shopName);
//        titleTextView.setText(name);

        ImageView imageView = (ImageView) findViewById(R.id.shopImage);
        imageView.setImageBitmap(image);

        ImageButton mButton = (ImageButton) findViewById(R.id.addCart);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "cart button");
                sendToCart();
            }
        });
    }


    public void sendToCart(){

        Intent intent = new Intent(this, AddCart.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shop, menu);
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
                        new Intent(this, ShopActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
