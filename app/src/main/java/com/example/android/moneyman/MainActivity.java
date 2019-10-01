package com.example.android.moneyman;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    FloatingActionButton fbtn;
    // TextView amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fbtn = (FloatingActionButton)findViewById(R.id.fbtn);
        fbtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                open_dialog();
            }
        });

    }

    public void open_dialog() {

    final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
    View mview = getLayoutInflater().inflate(R.layout.dialog,null);

        final EditText etxt = (EditText)mview.findViewById(R.id.etxt1);
        TextView txt = (TextView)mview.findViewById(R.id.txt);
        Spinner spinner = (Spinner)mview.findViewById(R.id.spinner) ;
        DatePicker datePicker = (DatePicker)mview.findViewById(R.id.datepicker);
        Button ok_btn = (Button)mview.findViewById(R.id.ok_btn);
        Button cancel_btn = (Button)mview.findViewById(R.id.cancel_btn);


        alert.setView(mview);
        final AlertDialog  alertDialog = alert.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

        ok_btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                alertDialog.dismiss();
            }
        });


        List<String> categories = new ArrayList<>();
        categories.add(0,"Choose Category");
        categories.add(" Breakfast");
        categories.add(" Lunch");
        categories.add(" Dinner");
        categories.add(" Other");

        //Style and populate the spinner
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, categories);

        //dropdown layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //adding data
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Choose Category"))
                {
                    //do nothing
                }
                else
                {
                    //selecting a valid position
                    String item = parent.getItemAtPosition(position).toString();

                    // show selected spinner item
                    Toast.makeText(parent.getContext(), "Selected" +item, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
