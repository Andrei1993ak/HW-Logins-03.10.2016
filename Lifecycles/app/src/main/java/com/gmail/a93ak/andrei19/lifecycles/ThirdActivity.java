package com.gmail.a93ak.andrei19.lifecycles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    public static final String AGE = "age";
    private EditText editTextActThird;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        editTextActThird = (EditText) findViewById(R.id.editTextActThird);
        load();
    }

    public void thirdButtonClick(View view) {
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).edit();
        editor.putInt(ChooseActivity.LAST_ACTIVITY, 3);
        editor.putString(AGE, editTextActThird.getText().toString());
        editor.commit();
        startActivity(new Intent(this, FourActivity.class));
        finish();
        flag = true;
    }

    private void load() {
        String age = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).getString(AGE, getResources().getString(R.string.null_value));
        if (!age.equals(getResources().getString(R.string.null_value)))
            editTextActThird.setText(age);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, SecondActivity.class));
        finish();
    }

    @Override
    protected void onPause() {
        if (!flag) {
            SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).edit();
            editor.putInt(ChooseActivity.LAST_ACTIVITY, 2);
            editor.putString(AGE, editTextActThird.getText().toString());
            editor.commit();
        }
        super.onPause();

    }

}
