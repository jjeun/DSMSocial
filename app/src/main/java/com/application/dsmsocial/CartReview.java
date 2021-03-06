package com.application.dsmsocial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CartReview extends AppCompatActivity {

    private static final String TAG = "CartTag";
    String name;
    Bitmap image;
    int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_review);

        name = getIntent().getStringExtra("name");
        image = getIntent().getParcelableExtra("image");
        page = getIntent().getIntExtra("switch",0);


        if (page == 1){

            TextView titleTextView = (TextView) findViewById(R.id.itemArtist);
            titleTextView.setText(name);

            ImageView imageView = (ImageView) findViewById(R.id.shopImage);
            imageView.setImageBitmap(image);

            TextView cartItem = (TextView) findViewById(R.id.itemName);
            cartItem.setText(null);

            TextView quantity = (TextView) findViewById(R.id.itemQuantity);
            quantity.setText(null);

            View delete = findViewById(R.id.deleteButton);
            delete.setVisibility(View.GONE);

            TextView price = (TextView) findViewById(R.id.itemPrice);
            price.setText("$0.00");

            TextView total = (TextView) findViewById(R.id.total);
            total.setText("$0.00");

            TextView empty = (TextView) findViewById(R.id.space);
            empty.setText("Cart Is Empty");
            empty.setTextSize(30);


            ImageButton returnButton = (ImageButton) findViewById(R.id.checkoutButton);
            returnButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.continuebutton2));
            returnButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.v(TAG, "return button");
                    sendToMain();
                }
            });
        }

        else{

            TextView titleTextView = (TextView) findViewById(R.id.itemArtist);
            titleTextView.setText(name);

            ImageView imageView = (ImageView) findViewById(R.id.shopImage);
            imageView.setImageBitmap(image);

            ImageButton mButton = (ImageButton) findViewById(R.id.deleteButton);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.v(TAG, "cart button");
                    sendToDelete();
                }
            });

            ImageButton mButton2 = (ImageButton) findViewById(R.id.checkoutButton);
            mButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.v(TAG, "cart button");
                    sendToCheckout();
                }
            });
        }
    }


    public void sendToDelete(){
        Toast.makeText(CartReview.this, "Item Deleted", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CartReview.class);
        intent.putExtra("switch", 1);

        startActivity(intent);
    }

    public void sendToMain(){
        Intent intent = new Intent(this, MainPage.class);

        startActivity(intent);

    }


    public void sendToCheckout(){

        Intent intent = new Intent(this, Login.class);
        intent.putExtra("image", image);
        intent.putExtra("name", name);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cart_review, menu);
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
