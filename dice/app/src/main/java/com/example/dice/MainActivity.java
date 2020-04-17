package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private com.example.layout.DiceView mDice;                  //設定一個變數叫mDice，他是從DiceView過來的

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDice = findViewById(R.id.mDice);                       //呼叫一下layout的mDice過來，在這邊也把它叫做mDice
        mDice.setOnClickListener(new View.OnClickListener() {   //滑鼠點一下mDice
            @Override
            public void onClick(View v) {
                mDice.next();                                   //我們就去next!!
            }
        });
    }
}

