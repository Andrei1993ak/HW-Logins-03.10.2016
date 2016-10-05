package com.gmail.a93ak.andrei19.lifecycles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ChooseActivity extends AppCompatActivity {

    public static final String LAST_ACTIVITY = "lastActivity";

    private int lastActivity;
    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        lastActivity=getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES,MODE_PRIVATE).getInt(LAST_ACTIVITY,0);
        textViewInfo = (TextView)findViewById(R.id.textViewInfo);
        textViewInfo.append(String.valueOf(lastActivity+1));
    }


    public void ChooseActivityNext(View view) {
        switch (lastActivity) {
            case 1:
                startActivity(new Intent(this,SecondActivity.class));
                break;
            case 2:
                startActivity(new Intent(this,ThirdActivity.class));
                break;
            case 3:
                startActivity(new Intent(this,FourActivity.class));
                break;
            case 4:
                startActivity(new Intent(this,FiveActivity.class));
                break;
            default:
                break;
        }
        finish();
    }

    public void ChooseActivityReset(View view) {
        clearInputs();
        startActivity(new Intent(this,FirstActivity.class));
    }

    private void clearInputs(){
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(ZeroActivity.PREFERENCES,MODE_PRIVATE).edit();
        editor.remove(ZeroActivity.LAST_ACTIVITY);
        editor.remove(FirstActivity.NAME);
        editor.remove(SecondActivity.SECOND_NAME);
        editor.remove(ThirdActivity.AGE);
        editor.remove(FourActivity.SEX);
        editor.remove(FiveActivity.COUNTRY);
        editor.commit();
    }
}
