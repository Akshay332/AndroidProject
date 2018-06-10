package com.example.akshay.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView ListView;
    String [] countryArr={"India","Japan","Canada","Usa","Pakistan","Nepal","China"};
    ArrayAdapter<String> countryAdapter;
    String [] indiaStateSpinner = {"Delhi","Haryana","up","Gujrat"};
    Spinner stateSpinner;
    ArrayAdapter<String> StateArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView = (ListView)findViewById(R.id.countrylistview);
         countryAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,countryArr);
       ListView.setAdapter(countryAdapter);
       ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(MainActivity.this,"country Selected is :"+countryArr[position],Toast.LENGTH_SHORT).show();
           }
       });
       stateSpinner = (Spinner)findViewById(R.id.StateSpinner);
       StateArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,indiaStateSpinner);
       stateSpinner.setAdapter(StateArrayAdapter);
       stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(MainActivity.this,"State Selected is :"+indiaStateSpinner[position],Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
    }
}

