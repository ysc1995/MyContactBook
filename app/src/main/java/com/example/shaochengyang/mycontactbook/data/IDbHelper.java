package com.example.shaochengyang.mycontactbook.data;

import com.example.shaochengyang.mycontactbook.ui.Presenter;

public interface IDbHelper {

    public void createRow(IDataManager.OnResponseListener listener, String name, String Phone);

    void createRow2(String name, String phone);

    public void readRow(IDataManager.OnResponseListener listener, String s);
    public void updateRow();
    public void deleteRow();
    public void readAll(IDataManager.OnResponseListener listener);

    void getCount(IDataManager.OnResponseListener listener);
}
