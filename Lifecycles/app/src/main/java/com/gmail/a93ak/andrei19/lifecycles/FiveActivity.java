package com.gmail.a93ak.andrei19.lifecycles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class FiveActivity extends AppCompatActivity {
    public static final String COUNTRY= "country";
    private EditText editTextActFive;
    private boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        editTextActFive = (EditText)findViewById(R.id.editTextActFive);


    }

    public void fiveButtonClick(View view) {
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES,MODE_PRIVATE).edit();
        editor.putInt(ChooseActivity.LAST_ACTIVITY,0);
        editor.putBoolean(ZeroActivity.IS_LOGGED,true);
        editor.putString(COUNTRY,editTextActFive.getText().toString());
        editor.commit();
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
        flag=true;

    }

    private void load() {
        String country = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES,MODE_PRIVATE).getString(COUNTRY,"null");
        if(!country.equals("null"))
            editTextActFive.setText(country);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,FourActivity.class));
        finish();
    }

    @Override
    protected void onPause() {
        if(!flag){
            SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES,MODE_PRIVATE).edit();
            editor.putInt(ChooseActivity.LAST_ACTIVITY,4);
            editor.putString(COUNTRY,editTextActFive.getText().toString());
            editor.commit();
        }
        super.onPause();

    }

}
