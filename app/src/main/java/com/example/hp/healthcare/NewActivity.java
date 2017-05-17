        package com.example.hp.healthcare;

        import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


        public class NewActivity extends Activity {

            String age;
            String contactNo;
            String name;
            String email;
            String password;
            String gender;
            Spinner spinner1;
            EditText pEditText;
            EditText mEditText;
            EditText nEditText;
            EditText qEditText;
            EditText rEditText;

            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                // Get the view from new_activity.xml
                setContentView(R.layout.new_activity);


                pEditText = (EditText) findViewById(R.id.name1);
                name= pEditText.getText().toString();

                 qEditText = (EditText) findViewById(R.id.email1);
                 email = qEditText.getText().toString();

                 rEditText = (EditText) findViewById(R.id.password1);
                 password = rEditText.getText().toString();

                 spinner1 =(Spinner) findViewById(R.id.gender1);
                 gender = spinner1.getSelectedItem().toString();


                addListenerOnSpinnerItemSelection();

            }

            public void addListenerOnSpinnerItemSelection() {
                spinner1 = (Spinner) findViewById(R.id.gender1);
                spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
            }

            public void signUp1(View view) {

                mEditText = (EditText) findViewById(R.id.age1);
                age = mEditText.getText().toString();
                int agei= Integer.parseInt(age);

                nEditText = (EditText) findViewById(R.id.phone1);
                contactNo = nEditText.getText().toString();
                long contactNol= Long.parseLong(contactNo);

                //et export
                if (agei < 0 || agei > 100) {
                    Context context = getApplicationContext();
                    CharSequence text = "Age must be between 0 and 100";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                long min = 1000000000L;
                long max = 9999999999L;
                if (contactNol < min || contactNol > max) {
                    Context context = getApplicationContext();
                    CharSequence text = "Phone no. must be of 10 digits";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

               //
                // DatabaseHelper helper = new DatabaseHelper(this);

                Contact c = new Contact();
                c.setName(name);
                c.setEmail(email);
                c.setPassword(password);
                c.setContact_no(contactNo);
                c.setAge(age);
                c.setGender(gender);
              //  helper.insertContact(c);

               /* ProfileActivity p = new ProfileActivity();
                p.sendInfo(c);*/

                Intent myIntent = new Intent(NewActivity.this, ProfileActivity.class);
                myIntent.putExtra("name",name);
                myIntent.putExtra("age",age);
                myIntent.putExtra("gender",gender);
                myIntent.putExtra("password",password);
                myIntent.putExtra("email",email);
                myIntent.putExtra("contact",contactNo);
                startActivity(myIntent);

            }

        }
