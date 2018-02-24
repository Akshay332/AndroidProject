package com.example.akshay.dummyapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NotesList extends AppCompatActivity {
    ArrayList<String>notes;
    ListView ListView;
    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
            ListView = (ListView)findViewById(R.id.listview);
            getNotes();
    }

    void getNotes(){
        notes = new ArrayList<String>();
        try{
            SQLiteDatabase db = this.openOrCreateDatabase("notes",MODE_PRIVATE,null);
            Cursor c = db.rawQuery("SELECT * FROM texts",null);
            int noteIndex = c.getColumnIndex("note");
            c.moveToFirst();
            while (c!=null);{
                Log.i("NOTE TEXT:",c.getString(noteIndex));
                notes.add(c.getString(noteIndex));
                c.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,notes);
            ListView.setAdapter(adapter);
        }

    }
}
