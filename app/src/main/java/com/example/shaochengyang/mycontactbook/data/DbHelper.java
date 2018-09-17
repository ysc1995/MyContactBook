package com.example.shaochengyang.mycontactbook.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DbHelper extends SQLiteOpenHelper implements IDbHelper {
    private static final String TAG = "DbHelper";
    
    public static final String MYDATABASE = "myDataBase";
    public static final int VERSION = 1;
    public static final String CTABLE = "CTable";
    public static final String CNAME = "CName";
    public static final String CPHONE = "CPhone";
    public static final String KEY_ID = "key_id";
    SQLiteDatabase sqLiteDatabase;


    public DbHelper(Context context) {

        super(context, MYDATABASE, null, VERSION);

    }

    @Override
    public void createRow(IDataManager.OnResponseListener listener, String name, String phone) {
        sqLiteDatabase= this.getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.CNAME,name);
        contentValues.put(DbHelper.CPHONE,phone);

        sqLiteDatabase.insert(DbHelper.CTABLE,null,contentValues);
        Log.d(TAG, "createRow: success");
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ CTABLE + " WHERE "+ CNAME +" = ysc", null);
        cursor.moveToFirst();
        Log.d(TAG, "createRow: "+cursor.getString(cursor.getColumnIndex(DbHelper.CPHONE)));
    }

    @Override
    public void createRow2(String name, String phone) {

    }

    @Override
    public void readRow(IDataManager.OnResponseListener listener, String s) {

        //return "sample todo note";
        //listener.getTodoNote("sample todo note");//implementation
        sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ CTABLE + " WHERE "+ CNAME +" = "+s, null);
        cursor.moveToFirst();
        String resPhone = cursor.getString(cursor.getColumnIndex(DbHelper.CPHONE));
        listener.passPhoneData(resPhone);


    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }

    @Override
    public void readAll(IDataManager.OnResponseListener listener) {

    }

    @Override
    public void getCount(IDataManager.OnResponseListener listener) {

    }


    //extends sql
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + CTABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + CNAME + " TEXT," + CPHONE + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d(TAG, "onCreate: tableCreated");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CTABLE);
        onCreate(sqLiteDatabase);
    }
}
