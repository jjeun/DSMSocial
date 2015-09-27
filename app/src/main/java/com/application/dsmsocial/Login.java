package com.application.dsmsocial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login extends AppCompatActivity
{
    private EditText inputEmail;
    private EditText inputPassword;
    private String email;
    private String pass;
    User user = new User();
    String name;
    Bitmap image;

    boolean isItAUser = false;

    int userNumber = 0;

    public final static String IS_THERE_A_USER = "com.application.dsmsocial.USER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = getIntent().getStringExtra("name");
        image = getIntent().getParcelableExtra("image");

        user.setUser("123", "danthedad@yahoo.com", "Dan", "Jones", "1591 North Pleasant Drive", "Des Moines", "IA", "50311");

        ImageButton loginButton = (ImageButton) findViewById(R.id.enterButton);
        ImageButton guestButton = (ImageButton) findViewById(R.id.guestButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(user);
            }
        });

        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginGuest();
            }
        });

    }

    public void loginUser(User user)
    {
        Intent intent = new Intent(this, Checkout.class);
        inputEmail = (EditText) findViewById(R.id.emailField);
        inputPassword = (EditText) findViewById(R.id.passwordField);
        email = inputEmail.getText().toString();
        pass = inputPassword.getText().toString();

            if(email.equals(user.getEmail()) && pass.equals(user.getPassword()))
            {
                intent.putExtra("image", image);
                intent.putExtra("name", name);
                intent.putExtra("firstName", user.getFirstName());
                intent.putExtra("lastName", user.getLastName());
                intent.putExtra("email", user.getEmail());
                intent.putExtra("address", user.getStreetAddress());
                intent.putExtra("city", user.getCity());
                intent.putExtra("state", user.getState());
                intent.putExtra("zipcode", user.getZipCode());
                intent.putExtra("switch",1);
                startActivity(intent);
            }

            else{
                Toast.makeText(Login.this,"Please enter a Valid Username or Password", Toast.LENGTH_SHORT).show();
            }
    }


    public void loginGuest()
    {
        Intent intent = new Intent(this, Checkout.class);

        intent.putExtra("image", image);
        intent.putExtra("name", name);

        startActivity(intent);
    }



}