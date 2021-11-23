package com.example.watcher_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GroupActivity extends AppCompatActivity {


    public EditText GroupName;
    public EditText GroupPassword;
    public Button GroupConfirm;

    public String Group;
    public String Code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        GroupName = (EditText)findViewById(R.id.groupName);
        GroupPassword = (EditText)findViewById(R.id.passwordGroup);
        GroupConfirm = (Button) findViewById(R.id.confirmGroup);



        GroupConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(GroupActivity.this, MainActivity.class);

                Group = GroupName.getText().toString();
                Code = GroupPassword.getText().toString();
                intent.putExtra("Code", Code);
                intent.putExtra("Group", Group);

                startActivity(intent);
                finish();
            }
        });
    }
}