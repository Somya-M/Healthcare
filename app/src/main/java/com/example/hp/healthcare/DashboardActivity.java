package com.example.hp.healthcare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DashboardActivity extends Activity implements OnItemSelectedListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.dashboard_activity);



        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);

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



       /* Contact c= new Contact();

        TextView user = (TextView) findViewById(id.helloUser);
              //add username here

        TextView userAge = (TextView) findViewById(id.userAge);
              //add user age here

        TextView userGender = (TextView) findViewById(id.userGender);
              //add user gender here

        if (userGender.getText().toString() == "Male")
        {
            ImageView imgUser = (ImageView) findViewById(id.img);
        }
        else
        {
            ImageView imgUser = (ImageView) findViewById(id.img);
        }


        TextView userContactNo = (TextView) findViewById(id.userContactNo);

        TextView userEmail = (TextView) findViewById(id.userEmail);


        TextView userHeight = (TextView) findViewById(id.userHeight);


        TextView userWeight = (TextView) findViewById(id.userWeight);

        TextView userBloodGroup = (TextView) findViewById(id.userBloodGroup);

        TextView userAllegicTo = (TextView) findViewById(id.userAllergicTo);
        */

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Specialist: " + item, Toast.LENGTH_LONG).show();



        if(item.equalsIgnoreCase("gynaecologist"))

        {
            Intent intent=new Intent(DashboardActivity.this,gynaecologist.class);
            startActivity(intent);
        }

        if(item.equalsIgnoreCase("physician"))
        {
            Intent intent=new Intent(DashboardActivity.this,physician.class);
            startActivity(intent);
        }
         if (item.equalsIgnoreCase("ayurvedic"))
        {
            Intent intent = new Intent(DashboardActivity.this, ayurvedic.class);
            startActivity(intent);
        }
        if (item.equalsIgnoreCase("pediatrician"))
        {
            Intent intent = new Intent(DashboardActivity.this, pediatrician.class);
            startActivity(intent);
        }


    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
