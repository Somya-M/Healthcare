package com.example.hp.healthcare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private String user;
    private String password;
    public Button b2;
    public Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText mEditText = (EditText) findViewById(R.id.username_text_view);
        user = mEditText.getText().toString();


        EditText nEditText = (EditText) findViewById(R.id.password_text_view);
        password = nEditText.getText().toString();


      /*  // Locate the button in activity_main.xml
        b2 = (Button) findViewById(R.id.logIn_button);

        // Capture button clicks

        b2.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Start NewActivity.class
                Intent myIntent1 = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(myIntent1);
            }
        });     */


        // Locate the button in activity_main.xml
        b1 = (Button) findViewById(R.id.signUp);

        // Capture button clicks

        b1.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Start NewActivity.class
                Intent myIntent1 = new Intent(MainActivity.this, NewActivity.class);
                startActivity(myIntent1);
            }
        });
    }

    public void logIn(View view)

    {
        DatabaseHelper helper = new DatabaseHelper(this);
        if (view.getId() == R.id.logIn_button) {
            String pass = helper.searchPass(user);
            if (password.equals(pass)) {
                Intent I = new Intent(MainActivity.this, DashboardActivity.class);
                // I.putExtra();
                startActivity(I);
            }
            else {

                Context context = getApplicationContext();
                CharSequence text = "Username and password do not match";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }

    }
}

