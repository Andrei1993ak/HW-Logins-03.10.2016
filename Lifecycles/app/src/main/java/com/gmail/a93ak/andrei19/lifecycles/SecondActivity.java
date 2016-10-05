package com.gmail.a93ak.andrei19.lifecycles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    public static final String SECOND_NAME = "secondName";
    private EditText editTextActSecond;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editTextActSecond = (EditText) findViewById(R.id.editTextActSecond);
        load();

    }

    private void load() {
        String secondName = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).getString(SECOND_NAME, getResources().getString(R.string.null_value));
        if (!secondName.equals(getResources().getString(R.string.null_value)))
            editTextActSecond.setText(secondName);
    }

    public void secondButtonClick(View view) {
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).edit();
        editor.putInt(ChooseActivity.LAST_ACTIVITY, 2);
        editor.putString(SECOND_NAME, editTextActSecond.getText().toString());
        editor.commit();
        startActivity(new Intent(this, ThirdActivity.class));
        flag = true;
        finish();

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, FirstActivity.class));
        finish();
    }

    @Override
    protected void onPause() {
        if (!flag) {
            SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES, MODE_PRIVATE).edit();
            editor.putInt(ChooseActivity.LAST_ACTIVITY, 1);
            editor.putString(SECOND_NAME, editTextActSecond.getText().toString());
            editor.commit();
        }
        super.onPause();

    }
}
