package com.example.hp.healthcare;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.hp.healthcare.R.drawable;
import static com.example.hp.healthcare.R.id;
import static com.example.hp.healthcare.R.layout;


public class DashboardActivity extends Activity implements OnItemSelectedListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(layout.dashboard_activity);



        // Spinner element
        Spinner spinner = (Spinner) findViewById(id.spinner1);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Specialist");
        categories.add("Physician");
        categories.add("Ayurvedic");
        categories.add("Gynaecologist");
        categories.add("Pediatrician");
        categories.add("Dentist");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);



        Contact c= new Contact();

        TextView user = (TextView) findViewById(id.helloUser);
        user.setText("Hello" + c.getName());      //add username here

        TextView userAge = (TextView) findViewById(id.userAge);
        userAge.setText(c.getAge());      //add user age here

        TextView userGender = (TextView) findViewById(id.userGender);
        userGender.setText(c.getGender());      //add user gender here

        if (userGender.getText().toString() == "Male")
        {
            ImageView imgUser = (ImageView) findViewById(id.img);
            imgUser.setImageResource(drawable.male);
        }
        else
        {
            ImageView imgUser = (ImageView) findViewById(id.img);
            imgUser.setImageResource(drawable.female);
        }


        TextView userContactNo = (TextView) findViewById(id.userContactNo);
        userContactNo.setText(c.getContact_no());      //add user contact no here

        TextView userEmail = (TextView) findViewById(id.userEmail);
        userEmail.setText(c.getEmail());      //add user email here


        TextView userHeight = (TextView) findViewById(id.userHeight);
        userHeight.setText(c.getHeight());      //add user height here


        TextView userWeight = (TextView) findViewById(id.userWeight);
        userWeight.setText(c.getWeight());      //add user weight here

        TextView userBloodGroup = (TextView) findViewById(id.userBloodGroup);
        userBloodGroup.setText(c.getBlood_group());      //add user blood group here

        TextView userAllegicTo = (TextView) findViewById(id.userAllergicTo);
        userAllegicTo.setText(c.getAllergic_to());      //add user allergy here

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Specialist: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
