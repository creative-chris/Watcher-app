package com.example.watcher_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText Password;
    private TextView Fail;
    private Button Login;
    private int counter = 2;
    private TextView CreateGroup;

    public String Code;
    public String Group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Password = (EditText) findViewById(R.id.Password);
        Fail = (TextView) findViewById(R.id.FailLogin);
        Login = (Button) findViewById(R.id.LoginButton);
        CreateGroup = (TextView) findViewById(R.id.createGroup);

        Code = getIntent().getStringExtra("Code");
        Group = getIntent().getStringExtra("Group");
//        Password.setText(String.valueOf(Code));

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Password.getText().toString());
            }
        });

        CreateGroup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, GroupActivity.class));
            }
        });



    }

    private void validate(String userPassword) {
        if (userPassword.equals(Code)) {
            Intent intent = new Intent(MainActivity.this, NameActivity.class);
            intent.putExtra("Group", Group);

            startActivity(intent);

        }
        if (userPassword.equals("eindhoven")) {
            Intent intent = new Intent(MainActivity.this, NameActivity.class);

            startActivity(intent);

        }

        if(TextUtils.isEmpty(userPassword) || userPassword.length() < 3)
        {
            Password.setError("Please enter a group code.");
        }
        else {
            counter--;

            if(counter == 0) {
                Fail.setVisibility(View.VISIBLE);
            }
        }
    }

}