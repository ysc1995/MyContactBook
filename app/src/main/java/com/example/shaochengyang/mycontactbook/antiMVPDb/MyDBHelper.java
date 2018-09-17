package com.example.shaochengyang.mycontactbook.antiMVPDb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper{


    public static final String MYDATABASE = "myDataBase2";
    public static final int VERSION = 1;
    public static final String CTABLE = "contactTab";
    public static final String CNAME = "CName";
    public static final String CPHONE = "CPhone";
    public static final String KEY_ID = "key_id";


    public MyDBHelper(Context context) {
        super(context, MYDATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + CTABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + CNAME + " TEXT," + CPHONE + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {  //only when newVersion > oldVersion
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CTABLE);
        //could be backed up
        onCreate(sqLiteDatabase);

    }
}
