package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        CharSequence fullname = getIntent().getCharSequenceExtra("fullname");
        int age = getIntent().getIntExtra("age",0);
        Person p = (Person) getIntent().getSerializableExtra("person");
        ((TextView)findViewById(R.id.tv_result)).setText(p.getFullname() + " / " + p.getAge() );
    }
}