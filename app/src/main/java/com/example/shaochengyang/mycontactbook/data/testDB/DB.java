package com.example.shaochengyang.mycontactbook.data.testDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    private static final String TAG = "DbHelper";

    public static final String MYDATABASE = "myDataBase3";
    public static final int VERSION = 1;
    public static final String CTABLE = "cTable";
    public static final String CNAME = "CName";
    public static final String CPHONE = "CPhone";
    public static final String KEY_ID = "key_id";


    public DB(Context context) {
        super(context, MYDATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + CTABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + CNAME + " TEXT," + CPHONE + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CTABLE);
        onCreate(sqLiteDatabase);
    }
}
