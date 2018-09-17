package com.example.shaochengyang.mycontactbook.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shaochengyang.mycontactbook.R;

public class MyAdaptor extends BaseAdapter {

    String names[], phones[];
    LayoutInflater layoutInflater;

    public MyAdaptor(String[] names, String[] phones,Context ctx) {
        this.names = names;
        this.phones = phones;
        layoutInflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return phones.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        View v =  layoutInflater.inflate(R.layout.adaptorlayout,null);
        TextView name = v.findViewById(R.id.textView2);
        TextView phone = v.findViewById(R.id.textView3);
        //View layout = v.findViewById(R.id.myadaptor);

        name.setText(names[position]);
        phone.setText(phones[position]);
        return v;
    }
}
