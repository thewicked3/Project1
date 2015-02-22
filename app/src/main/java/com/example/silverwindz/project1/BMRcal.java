package com.example.silverwindz.project1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class BMRcal extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_cal);
    }
    public void buttonlinkClicked(View v) {
        int id = v.getId();
        Intent i;

        switch (id) {
            case R.id.gotocal:
                i = new Intent(this, Exercal.class);
                startActivity(i);
                break;
        }
    }

    public void buttonBMRClicked (View v)
    {
        EditText etInput = (EditText)findViewById(R.id.etInput);
        String s = etInput.getText().toString();
        Double input = Double.parseDouble(s);

        //GET THE INPUT AND CHANGE THE UNIT

        RadioGroup rgFrom = (RadioGroup)findViewById(R.id.rgFrom);
        int selFrom = rgFrom.getCheckedRadioButtonId();

        RadioGroup rgTo = (RadioGroup)findViewById(R.id.rgTo);
        int selTo = rgTo.getCheckedRadioButtonId();



        if (selFrom == R.id.rbFrmC) { //The user wants to convert from Celsius.
            if(selTo == R.id.rbToF)
            {
                input = (input * 9/5)+32;
            }
            else if(selTo == R.id.rbToK)
            {
                input += 273.15;
            }
        }
        else if (selFrom == R.id.rbFrmF) { //The user wants to convert from Farenheit.
            if(selTo == R.id.rbToC)
            {
                input = (input -32)*5/9;
            }
            else if(selTo == R.id.rbToK)
            {
                input = (input +459.67)*5/9;
            }
        }
        else // The user wants to convert from Kelvin.
        {
            if(selTo == R.id.rbToC)
            {
                input -= 273.15;
            }
            else if(selTo == R.id.rbToF)
            {
                input = (input * 9/5)-459.67;
            }
        }



        TextView tv = (TextView)findViewById(R.id.tvOutput);
        tv.setText(String.format("%.2f",input));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bmr_cal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
