package com.example.notificationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    private  static  final String DATABASE_NAME = "mydata.db";
    private  static  final  String TABLE_NAME = "mydata_details";
    private  static  final  String ID = "id";
    private  static  final  String DATA = "data";
    private  static  final int  VERSION_NUMBER = 1;
    private  static  final  String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"(DATA VARCHAR(30));";
//    private  static  final  String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY, "+DATA+" VARCHAR(30));";
    private  Context context;





    public DatabaseHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "onCreate is called : ", Toast.LENGTH_LONG).show();

        } catch (Exception e){
            Toast.makeText(context, "Exception : " +e, Toast.LENGTH_LONG).show();

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context, "onUpgrade is called ", Toast.LENGTH_LONG).show();
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);
        } catch (Exception e){
            Toast.makeText(context, "Exception"+ e, Toast.LENGTH_LONG).show();
        }

    }

    public  long  saveData(String name){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATA, name);
        long rowNumber = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return rowNumber;

    }
    public Cursor showAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ TABLE_NAME,null);

        return  cursor;
    }
}
