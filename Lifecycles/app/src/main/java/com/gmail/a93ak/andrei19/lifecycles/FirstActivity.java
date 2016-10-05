package com.gmail.a93ak.andrei19.lifecycles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

     public static final String NAME = "name";
     private EditText editTextActFirst;
     private boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        editTextActFirst = (EditText)findViewById(R.id.editTextActFirst);
        load();
    }

    public void firstButtonClick(View view) {
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES,MODE_PRIVATE).edit();
        editor.putInt(ChooseActivity.LAST_ACTIVITY,1);
        editor.putString(NAME,editTextActFirst.getText().toString());
        editor.commit();
        startActivity(new Intent(this,SecondActivity.class));
        finish();
        flag=true;

    }

    private void load(){
        String name = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES,MODE_PRIVATE).getString(NAME,"null");
        if(!name.equals("null"))
            editTextActFirst.setText(name);

    }

    @Override
    protected void onPause() {
        if(!flag){
            SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES,MODE_PRIVATE).edit();
            editor.putInt(ChooseActivity.LAST_ACTIVITY,0);
            editor.putString(NAME,editTextActFirst.getText().toString());
            editor.commit();
        }
        super.onPause();

    }
}
