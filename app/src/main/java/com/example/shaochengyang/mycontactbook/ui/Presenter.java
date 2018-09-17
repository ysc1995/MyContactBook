package com.example.shaochengyang.mycontactbook.ui;

import android.view.View;
import android.widget.Toast;

import com.example.shaochengyang.mycontactbook.data.DataManager;
import com.example.shaochengyang.mycontactbook.data.IDataManager;

public class Presenter implements IPresenter,IDataManager.OnResponseListener {
    IView iView;
    IDataManager dataManager;


    public Presenter(MainActivity mainActivity) {
        iView = mainActivity;
        dataManager = (IDataManager) new DataManager(mainActivity);
    }


    @Override
    public void onSaveButtonClicked(View view, String name, String phone) {
        //Toast.makeText(view.getContext(),""+name+""+phone,Toast.LENGTH_LONG).show();
        dataManager.createRow(this, name,phone);
    }

    @Override
    public void onGoButtonClicked(View view) {
        iView.navigateToSecActivity();
    }

    @Override
    public void showView(View v) {
        iView.showView();
    }

    @Override
    public void onViewButtonClicked(View v, String s) {
        dataManager.readRow(this,s);
    }

    @Override
    public void onViewAllButtonClicked(View v) {
        dataManager.readAll(this);
    }

    @Override
    public void getCount(View v) {
        //dataManager.getCount(this);
        /*MainActivity.MyAsyncTask myAsyncTask = new MainActivity.MyAsyncTask();
        myAsyncTask.execute();*/
    }


    @Override
    public void passPhoneData(String phone) {
        iView.showPhoneData(phone);
    }

    @Override
    public void passAllData(String[] name, String[] phone) {
        iView.showAllData(name,phone);
    }
}
