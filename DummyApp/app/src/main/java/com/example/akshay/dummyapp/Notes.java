package com.example.akshay.dummyapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Notes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Button addnote = (Button)findViewById(R.id.add);
        final EditText myNote = (EditText)findViewById(R.id.note);
        addnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myNoteString = myNote.getText().toString();
                add(myNoteString);

            }
        });
    }void add(String noteText){

        try{
            SQLiteDatabase db = this.openOrCreateDatabase("notes",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS texts(note VARCHAR) ");
            db.execSQL("INSERT INTO texts VALUES('"+ noteText +"')");
            Log.i("NOTE ADDED:","SUCCESS");
        }catch(Exception e){
          e.printStackTrace();
        }
    }
}
