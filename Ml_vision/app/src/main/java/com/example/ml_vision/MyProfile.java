package com.example.ml_vision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

public class MyProfile extends AppCompatActivity
{

    EditText st_email;
    SharedPreferences sharedPreferences;
    static final String mypreference="mypref";
    static final String phone="phoneKey";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setTitle("Profile");
        setContentView(R.layout.activity_my_profile);

        st_email=findViewById(R.id.phoneText);

        sharedPreferences=getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(phone))
        {
            st_email.setText(sharedPreferences.getString(phone,""));
        }

        setDefaults(phone,st_email.getText().toString(),this);

    }

    public static void setDefaults(String key, String value, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }


    public void save (View v)
    {
        String p=st_email.getText().toString();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(phone,p);
        editor.commit();
    }

    public void clear(View v)
    {
        st_email.setText("");
    }

    public String retrive(View v)
    {
        sharedPreferences=getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(phone))
        {
            st_email.setText(sharedPreferences.getString(phone,""));
            return sharedPreferences.getString(phone,"");
        }
        return "xyz@gmail.com";
    }
}
