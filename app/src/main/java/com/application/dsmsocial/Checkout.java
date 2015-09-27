package com.application.dsmsocial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Checkout extends AppCompatActivity {

    private TextView billing;
    private TextView cardinfo;
    private TextView shipping;
    private EditText nameUser, street, townState, zipCode;
    String name;
    Bitmap image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();

        name=getIntent().getStringExtra("name");
        image=getIntent().getParcelableExtra("image");

//        TextView titleTextView = (TextView) findViewById(R.id.shopArtist);
//        titleTextView.setText(name);
//
//        ImageView imageView = (ImageView) findViewById(R.id.shopImage);
//        imageView.setImageBitmap(image);

//
       billing = (TextView) findViewById(R.id.billing);
       billing.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf"));
       cardinfo = (TextView) findViewById(R.id.cardinfo);
       cardinfo.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Raleway-Light.ttf"));
       shipping = (TextView) findViewById(R.id.shipping);
       shipping.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf"));

        ImageButton continueButton2 = (ImageButton) findViewById(R.id.continueButton2);
        continueButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToConfirmation();
            }
        });

    }

    public void sendToConfirmation(){
        Intent intent = new Intent(this, confirmation.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_checkout, menu);
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
