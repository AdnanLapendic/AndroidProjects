package com.lapa.citypatrol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by lapa on 10/22/16.
 */

public class DbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "leftor.db";
    public static final String TABLE_ISSUES = "issues";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ISSUE_CATEGORY = "category";
    public static final String COLUMN_ISSUE_LATITUDE = "latitude";
    public static final String COLUMN_ISSUE_LONGITUDE = "longitude";
    public static final String COLUMN_ISSUE_IMG_URL = "image";
    public static final String COLUMN_ISSUE_DESCRIPTION = "description";
    public static final String COLUMN_ISSUE_ADDRESS = "address";

    public DbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_ISSUES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ISSUE_CATEGORY + " TEXT, " +
                COLUMN_ISSUE_LATITUDE + " TEXT, " +
                COLUMN_ISSUE_LONGITUDE + " TEXT, " +
                COLUMN_ISSUE_IMG_URL + " TEXT, " +
                COLUMN_ISSUE_DESCRIPTION + " TEXT " +
                COLUMN_ISSUE_ADDRESS + "TEXT" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ISSUES);
        onCreate(db);
    }

    public void addNewIssue(Issue issue) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ISSUE_CATEGORY, issue.getCategory());
        values.put(COLUMN_ISSUE_LATITUDE, issue.getLatitude());
        values.put(COLUMN_ISSUE_LONGITUDE, issue.getLongitude());
        values.put(COLUMN_ISSUE_IMG_URL, issue.getImageUrl());
        values.put(COLUMN_ISSUE_DESCRIPTION, issue.getDescription());
//        values.put(COLUMN_ISSUE_ADDRESS, issue.getAddress());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ISSUES, null, values);
        db.close();
    }

    public void deleteAllFromTable(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE * FROM " + TABLE_ISSUES + "\";" );
    }

    public String printDatabase(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ISSUES + " WHERE 1";

        Cursor c = db.rawQuery(query, null);

        c.moveToFirst();

        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("image")) != null){
                dbString += c.getString(c.getColumnIndex("image"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return  dbString;
    }

    public void updateDatabase(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ISSUES);
        onCreate(db);

    }

    public ArrayList<Issue> showAllFromDatabase(){
ArrayList<Issue> issues = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ISSUES + " WHERE 1";

        Cursor c = db.rawQuery(query, null);

        c.moveToFirst();

        Issue issue;

        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("latitude")) != null){

                issue = new Issue(c.getString(c.getColumnIndex("category")), c.getString(c.getColumnIndex("image")), c.getString(c.getColumnIndex("latitude")), c.getString(c.getColumnIndex("longitude")), c.getString(c.getColumnIndex("description")), "Default Address 13/A");
                issues.add(issue);
            }
            c.moveToNext();
        }
        db.close();
        return  issues;
    }

}
