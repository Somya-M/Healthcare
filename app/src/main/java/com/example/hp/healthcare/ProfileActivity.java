package com.example.hp.healthcare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.hp.healthcare.R.id.spinner;

public class ProfileActivity extends Activity implements OnItemSelectedListener{

    EditText mEditText;
    String height;

    EditText nEditText;
    String weight;

    EditText pEditText;
    String allergicTo;

    Spinner spinner1;
    String bloodGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);


        // Spinner element
        spinner1 = (Spinner) findViewById(spinner);

        // Spinner click listener
        spinner1.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("A+");
        categories.add("A-");
        categories.add("B+");
        categories.add("B-");
        categories.add("AB+");
        categories.add("AB-");
        categories.add("O+");
        categories.add("O-");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        spinner1.setAdapter(dataAdapter);

        bloodGroup = spinner1.getSelectedItem().toString();

    }

    DatabaseHelper helper= new DatabaseHelper(this);
                public void sendInfo(Contact c) {

                    mEditText = (EditText) findViewById(R.id.height);
                    height = mEditText.getText().toString();

                    nEditText = (EditText) findViewById(R.id.weight);
                    weight = nEditText.getText().toString();

                    pEditText = (EditText) findViewById(R.id.allergy);
                    allergicTo = pEditText.getText().toString();


                    c.setHeight(height);
                    c.setWeight(weight);
                    c.setBloodGroup(bloodGroup);
                    c.setAllergic_to(allergicTo);
                    helper.insertContact(c);
                }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void signin(View view){

        Intent myIntent = new Intent(ProfileActivity.this, DashboardActivity.class);
        startActivity(myIntent);

    }
}