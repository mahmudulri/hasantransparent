package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewAllData extends AppCompatActivity {
    private ListView listView;
    private  DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_data);

        listView = findViewById(R.id.mylistivewid);
        databaseHelper = new DatabaseHelper(this);
        loadData();
    }
    public  void  loadData(){
        ArrayList<String> listData =  new ArrayList<>();
        Cursor cursor = databaseHelper.showAllData();
        if (cursor.getCount()==0){
            Toast.makeText(getApplicationContext(), "No data",Toast.LENGTH_LONG).show();

        } else {
            while (cursor.moveToNext()){
                listData.add(cursor.getString(0)+"\t "+cursor.getString(1));

            }
        }
        ArrayAdapter<String>adapter =  new ArrayAdapter<String>(this, R.layout.list_items, R.id.mylistivewid, listData);
       listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String selectedValue = parent.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "selected value", Toast.LENGTH_LONG).show();
            }
        });




    }
}