package com.application.dsmsocial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class AddCart extends AppCompatActivity {
    private static final String TAG = "AddCartTag";
    Context context = this;

    String name;
    Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cart);

        name = getIntent().getStringExtra("name");
        image = getIntent().getParcelableExtra("image");


        ImageButton mButton = (ImageButton) findViewById(R.id.cartButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "shopping cart view button");
                sendToCart();
            }
        });


        ImageButton mButton2 = (ImageButton) findViewById(R.id.continueButton);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "continue shopping button");
                returnShop();
            }
        });
    }


    public void sendToCart(){

        Intent intent = new Intent(this, CartReview.class);
        intent.putExtra("image", image);
        intent.putExtra("name", name);
        startActivity(intent);
    }


    public void returnShop(){

        Intent intent = new Intent(context, MainPage.class);
        intent.putExtra("image", image);
        intent.putExtra("name", name);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_cart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
