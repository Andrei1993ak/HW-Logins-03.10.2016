package com.gmail.a93ak.andrei19.lifecycles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class FourActivity extends AppCompatActivity {

    public static final String SEX = "sex";
    private EditText editTextActFour;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        editTextActFour = (EditText) findViewById(R.id.editTextActFour);
        load();
    }

    private void load() {
        String sex = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).getString(SEX, getResources().getString(R.string.null_value));
        if (!sex.equals(getResources().getString(R.string.null_value)))
            editTextActFour.setText(sex);
    }


    public void fourButtonClick(View view) {
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).edit();
        editor.putInt(ChooseActivity.LAST_ACTIVITY, 4);
        editor.putString(SEX, editTextActFour.getText().toString());
        editor.commit();
        startActivity(new Intent(this, FiveActivity.class));
        finish();
        flag = true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ThirdActivity.class));
        finish();
    }

    @Override
    protected void onPause() {
        if (!flag) {
            SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).edit();
            editor.putInt(ChooseActivity.LAST_ACTIVITY, 3);
            editor.putString(SEX, editTextActFour.getText().toString());
            editor.commit();
        }
        super.onPause();

    }

}
