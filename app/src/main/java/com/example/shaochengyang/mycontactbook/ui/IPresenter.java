package com.example.shaochengyang.mycontactbook.ui;

import android.view.View;

/**
 *  view -> presenter
 */
public interface IPresenter {

    void onSaveButtonClicked(View view, String s, String toString);
    void onGoButtonClicked(View view);
    void showView(View v);

    void onViewButtonClicked(View v, String s);

    void onViewAllButtonClicked(View v);

    void getCount(View v);
}
