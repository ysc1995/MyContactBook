package com.example.shaochengyang.mycontactbook.data;

import com.example.shaochengyang.mycontactbook.data.testDB.DATABASEHelper;
import com.example.shaochengyang.mycontactbook.ui.MainActivity;
import com.example.shaochengyang.mycontactbook.ui.Presenter;

public class DataManager implements  IDataManager{


    IDbHelper dbHelper;
    public DataManager(MainActivity mainActivity) {
        //dbHelper = new DbHelper(mainActivity);
        dbHelper = new DATABASEHelper(mainActivity);
    }

    @Override
    public void createRow(OnResponseListener listener, String name, String Phone) {
        dbHelper.createRow(listener,name,Phone);
    }

    @Override
    public void createRow2(String name, String phone) {

    }

    @Override
    public void readRow(OnResponseListener listener, String s) {
        dbHelper.readRow(listener,s);
    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }

    @Override
    public void readAll(OnResponseListener listener) {
        dbHelper.readAll(listener);
    }

    @Override
    public void getCount(OnResponseListener listener) {
        dbHelper.getCount(listener);
    }
}
