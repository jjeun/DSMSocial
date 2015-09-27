package com.application.dsmsocial;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;

public class Login extends AppCompatActivity
{
    private EditText inputEmail;
    private EditText inputPassword;

    boolean isItAUser = false;

    int userNumber = 0;

    public final static boolean IS_THERE_A_USER = false;
    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        user.setUser("123", "danthedad@yahoo.com", "Dan", "Jones", "1591 North Pleasant Drive", "Des Moines", "IA", "50311");

        inputEmail = (EditText) findViewById(R.id.emailField);
        inputPassword = (EditText) findViewById(R.id.passwordField);
        inputPassword.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf"));
        inputEmail.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf"));

        ImageButton loginUserButton = (ImageButton) findViewById(R.id.enterButton);
        loginUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(user);
            }

        });

        ImageButton guestUserButton = (ImageButton) findViewById(R.id.guestButton);
        guestUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginGuest();
            }

        });
    }
    public void loginUser(User user)
    {
        Intent intent = new Intent(this, Checkout.class);
        String inputtedEmail = inputEmail.getText().toString();
        String inputtedPassword = inputPassword.getText().toString();

            if(inputtedEmail == user.getEmail() && inputtedPassword == user.getPassword())
            {
                isItAUser = true;
                startActivity(intent);
            }
            else
            {
                Toast.makeText(Login.this, "Please enter a Valid Username and Password", Toast.LENGTH_SHORT).show();
            }
    }

    public void loginGuest()
    {
        Intent intent = new Intent(this, Checkout.class);
        isItAUser = false;
        startActivity(intent);
    }



}