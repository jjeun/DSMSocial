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
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zipcode;
    String email;
    int page;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);



            name = getIntent().getStringExtra("name");
            image = getIntent().getParcelableExtra("image");
            firstName = getIntent().getStringExtra("firstName");
            lastName = getIntent().getStringExtra("lastName");
            email = getIntent().getStringExtra("email");
            address = getIntent().getStringExtra("address");
            city = getIntent().getStringExtra("city");
            state = getIntent().getStringExtra("state");
            zipcode = getIntent().getStringExtra("zipcode");
            page = getIntent().getIntExtra("switch", 0);

        TextView titleTextView = (TextView) findViewById(R.id.itemArtist);
        titleTextView.setText(name);

        ImageView imageView = (ImageView) findViewById(R.id.shopImage);
        imageView.setImageBitmap(image);


        billing = (TextView) findViewById(R.id.billing);
        billing.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf"));
        cardinfo = (TextView) findViewById(R.id.cardinfo);
        cardinfo.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Raleway-Light.ttf"));
        shipping = (TextView) findViewById(R.id.shipping);
        shipping.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf"));

        if(page == 1) {
            TextView name = (TextView) findViewById(R.id.name);
            TextView street = (TextView) findViewById(R.id.street);
            TextView townstate = (TextView) findViewById(R.id.townstate);
            TextView zipCode = (TextView) findViewById(R.id.zipCode);

            TextView nameOnCard = (TextView) findViewById(R.id.nameOnCard);
            TextView nameShipping = (TextView) findViewById(R.id.nameShipping);
            TextView streetShipping = (TextView) findViewById(R.id.streetShipping);
            TextView townstateShipping = (TextView) findViewById(R.id.townstateShipping);
            TextView zipCodeShipping = (TextView) findViewById(R.id.zipCodeShipping);

            name.setText(firstName + " " + lastName);
            street.setText(address);
            townstate.setText(city + ", " + state);
            zipCode.setText(zipcode);

            nameOnCard.setText(firstName + " " + lastName);
            nameShipping.setText(firstName + " " + lastName);
            streetShipping.setText(address);
            townstateShipping.setText(city + ", " + state);
            zipCodeShipping.setText(zipcode);
        }

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
