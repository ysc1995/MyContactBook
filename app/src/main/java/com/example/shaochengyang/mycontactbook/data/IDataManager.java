package com.example.shaochengyang.mycontactbook.data;

import com.example.shaochengyang.mycontactbook.ui.Presenter;

public interface IDataManager extends IDbHelper{



    interface OnResponseListener{
        void passPhoneData(String data);

        void passAllData(String[] name, String[] phone);
    }
}