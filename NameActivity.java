package com.example.watcher_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    public EditText User;
    private Button Confirm;
    private TextView groupName;

    public String Group;

    public String Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        User = (EditText)findViewById(R.id.UserName);
        Confirm = (Button) findViewById(R.id.ConfirmName);
        groupName = (TextView) findViewById(R.id.GroupName);

        Group = getIntent().getStringExtra("Group");
        groupName.setText(String.valueOf(Group));

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmitClicked(User.getText().toString());
            }

            private void onSubmitClicked(String username)
            {

                if(TextUtils.isEmpty(username) || username.length() < 3)
                {
                    User.setError("Your name is too short.");
                }

                else {

                    Intent intent = new Intent(NameActivity.this, AlertActivity.class);

                    Name = User.getText().toString();
                    intent.putExtra("Name", Name);
                    intent.putExtra("Group", Group);

                    startActivity(intent);
                }

            }
        });
    }
}