package com.application.dsmsocial;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.sql.SQLException;

public class Login extends AppCompatActivity
{
    private static final String DB_NAME = "DSMSocialClubDB.sqlite3";

    private ImageButton loginButton;
    private ImageButton guestButton;

    private EditText inputEmail;
    private EditText inputPassword;
    private TextView loginError;

    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(this,DB_NAME);
//        try {
//            database = dbOpenHelper.openDataBase();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }





}