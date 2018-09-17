package com.example.shaochengyang.mycontactbook.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaochengyang.mycontactbook.R;

public class ViewFragment extends Fragment {


    TextView viewName, viewPhone;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragview,container,false);
        viewName = view.findViewById(R.id.viewNameText);
        viewPhone = view.findViewById(R.id.viewPhoneText);
        return view;
    }

    public void showDatas(String name, String phone){
        viewName.setText(name);
        viewPhone.setText(phone);
    }



}
