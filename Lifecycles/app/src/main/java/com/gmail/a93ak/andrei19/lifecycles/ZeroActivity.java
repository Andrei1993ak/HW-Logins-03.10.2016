package com.gmail.a93ak.andrei19.lifecycles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ZeroActivity extends AppCompatActivity {

    public static final String PREFERENCES = "Preferences";
    public static final String LAST_ACTIVITY = "lastActivity";
    public static final String IS_LOGGED ="isLogged";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        redirect();
    }

    private void redirect(){
        if (isLogin()) {
            startActivity(new Intent(this,MainActivity.class));
        } else if (isLoginStart()){
            startActivity(new Intent(this,ChooseActivity.class));
        } else {
            startActivity(new Intent(this,FirstActivity.class));
        }
        finish();
    }

    private boolean isLogin(){
        return getApplicationContext().getSharedPreferences(PREFERENCES,MODE_PRIVATE).getBoolean(IS_LOGGED,false);
    }

    private boolean isLoginStart(){
        if(getApplicationContext().getSharedPreferences(PREFERENCES,MODE_PRIVATE).getInt(LAST_ACTIVITY,0)==0)
            return false;
        else
            return true;
        }

}
