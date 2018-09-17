package com.example.shaochengyang.mycontactbook.ui;

/**
 * presenter -> view
 */
public interface IView {
    void navigateToSecActivity();

    void showView();

    void showPhoneData(String phone);

    void showAllData(String[] name, String[] phone);
}
