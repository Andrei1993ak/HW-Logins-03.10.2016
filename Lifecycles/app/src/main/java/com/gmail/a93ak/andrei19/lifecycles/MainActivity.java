package com.gmail.a93ak.andrei19.lifecycles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView name;
    private TextView secondName;
    private TextView birthday;
    private TextView sex;
    private TextView country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.textViewName);
        secondName = (TextView) findViewById(R.id.textViewSecondName);
        birthday = (TextView) findViewById(R.id.textViewBirthday);
        sex = (TextView) findViewById(R.id.textViewSex);
        country = (TextView) findViewById(R.id.textViewCountry);
        fillData();
    }

    private void fillData() {
        name.setText(getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).getString(FirstActivity.NAME, "null"));
        secondName.setText(getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).getString(SecondActivity.SECOND_NAME, "null"));
        birthday.setText(getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).getString(ThirdActivity.AGE, "null"));
        sex.setText(getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).getString(FourActivity.SEX, "null"));
        country.setText(getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).getString(FiveActivity.COUNTRY, "null"));
    }


    public void clear(View view) {
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).edit();
        editor.remove(ZeroActivity.IS_LOGGED);
        editor.remove(ZeroActivity.LAST_ACTIVITY);
        editor.remove(FirstActivity.NAME);
        editor.remove(SecondActivity.SECOND_NAME);
        editor.remove(ThirdActivity.AGE);
        editor.remove(FourActivity.SEX);
        editor.remove(FiveActivity.COUNTRY);
        editor.commit();
        Intent intent = new Intent(this, FirstActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
