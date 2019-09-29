package com.example.android.moneyman;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fbtn;
    TextView amt;

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
        //amt=(TextView)findViewById(R.id.amount);




    public void open_dialog() {

    final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
    View mview = getLayoutInflater().inflate(R.layout.dialog,null);

        final EditText etxt = (EditText)mview.findViewById(R.id.etxt1);
        TextView txt = (TextView)mview.findViewById(R.id.txt);
        DatePicker datePicker = (DatePicker)mview.findViewById(R.id.datepicker);

        alert.setView(mview);
        final AlertDialog  alertDialog = alert.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

    }
}
