package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestCallPermission(android.Manifest.permission.CALL_PHONE);
        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,SecondActivity.class);

                CharSequence fullName = ((EditText)findViewById(R.id.edt_fullname)).getText();
                String age = ((EditText)findViewById(R.id.edt_age)).getText().toString();
//                it.putExtra("fullname",fullName);
//                it.putExtra("Age",Integer.valueOf(age));
                Person person = new Person(fullName.toString(),Integer.valueOf(age));
                it.putExtra("Person",person);
                startActivity(it);
            }
        });
        ((Button)findViewById(R.id.call)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent im_intent = new Intent();
                im_intent.setAction(Intent.ACTION_CALL);
                im_intent.setData(Uri.parse("tel:0943895292"));
                startActivity(im_intent);
            }
        });

    }
    public void requestCallPermission (String permission){
        if(checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{permission},1001);
        }

    }
}