package com.example.shaochengyang.mycontactbook.data.testDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.shaochengyang.mycontactbook.data.DbHelper;
import com.example.shaochengyang.mycontactbook.data.IDataManager;
import com.example.shaochengyang.mycontactbook.data.IDbHelper;
import com.example.shaochengyang.mycontactbook.ui.MainActivity;


public class DATABASEHelper implements IDbHelper {
    private static final String TAG = "DATABASEHelper";

    DB db;
    SQLiteDatabase sqLiteDatabase,sqLiteDatabase2;

    public DATABASEHelper(MainActivity mainActivity) {
        db=new DB(mainActivity);
    }

    @Override
    public void createRow(IDataManager.OnResponseListener listener, String name, String phone) {


        sqLiteDatabase = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(db.CNAME,name);
        contentValues.put(db.CPHONE,phone);

        sqLiteDatabase.insert(DbHelper.CTABLE,null,contentValues);


        //Log.d(TAG, "createRow: "+cursor.getString(cursor.getColumnIndex(DbHelper.CPHONE)));
    }

    @Override
    public void createRow2(String name, String phone) {
/*
        sqLiteDatabase = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(db.CNAME,name);
        contentValues.put(db.CPHONE,phone);

        sqLiteDatabase.insert(DbHelper.CTABLE,null,contentValues);

        sqLiteDatabase2 = db.getWritableDatabase();
        Cursor cursor = sqLiteDatabase2.rawQuery("SELECT * FROM "+ db.CTABLE + " WHERE "+ db.CNAME +" = ysc", null);
        cursor.moveToFirst();
        Log.d(TAG, "createRow: "+cursor.getString(cursor.getColumnIndex(DbHelper.CPHONE)));*/
    }


    @Override
    public void readRow(IDataManager.OnResponseListener listener, String s) {
        String getName, getPhone;
        sqLiteDatabase2 = db.getWritableDatabase();
        //Cursor cursor = sqLiteDatabase2.rawQuery("SELECT * FROM "+ db.CTABLE + " WHERE "+ db.CNAME +" = ysc", null);
        Cursor cursor = sqLiteDatabase2.rawQuery("SELECT * FROM " + db.CTABLE ,null);
        cursor.moveToFirst();

        do{
            getName = cursor.getString(cursor.getColumnIndex(DbHelper.CNAME)); //field number 0,1,2


            getPhone = cursor.getString(cursor.getColumnIndex(DbHelper.CPHONE));

            if(getName.equals(s)){
                Log.d(TAG, "createRow: "+getPhone);
                break;
            }

        }while (cursor.moveToNext());

        listener.passPhoneData(getPhone);
    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }

    @Override
    public void readAll(IDataManager.OnResponseListener listener) {
        String [] name = new String[100];
        String [] phone = new String[100];
        sqLiteDatabase2 = db.getWritableDatabase();
        Cursor cursor = sqLiteDatabase2.rawQuery("SELECT * FROM " + db.CTABLE ,null);
        cursor.moveToFirst();
        int i = 0;
        int j = 0;

        do{
            name[i] = cursor.getString(cursor.getColumnIndex(DbHelper.CNAME));
            i++;

            phone[j] = cursor.getString(cursor.getColumnIndex(DbHelper.CPHONE));
            j++;

        }while (cursor.moveToNext());

        listener.passAllData(name,phone);
    }

    @Override
    public void getCount(IDataManager.OnResponseListener listener) {
        /*sqLiteDatabase2 = db.getWritableDatabase();
        Cursor cursor = sqLiteDatabase2.rawQuery("SELECT * FROM " + db.CTABLE ,null);
        cursor.moveToFirst();
        int n=0;
        do{
            n++;

        }while (cursor.moveToNext());
        listener.passCount(n);*/
    }
}
