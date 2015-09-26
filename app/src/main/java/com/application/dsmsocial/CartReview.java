package com.application.dsmsocial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class CartReview extends AppCompatActivity {

    private static final String TAG = "CartTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_review);

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


    public void sendToDelete(){
        Toast.makeText(CartReview.this, "Item Deleted", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CartReview.class);
        startActivity(intent);
    }


    public void sendToCheckout(){

        Intent intent = new Intent(this, Login.class);
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
