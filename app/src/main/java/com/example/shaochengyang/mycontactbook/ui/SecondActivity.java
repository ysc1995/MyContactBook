package com.example.shaochengyang.mycontactbook.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shaochengyang.mycontactbook.R;

public class SecondActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView = findViewById(R.id.listview);

        String [] name = getIntent().getExtras().getStringArray("CN");
        String [] phone = getIntent().getExtras().getStringArray("CP");
        //Toast.makeText(SecondActivity.this,""+name[1]+""+phone[1],Toast.LENGTH_LONG).show();
        MyAdaptor arrayAdapter = new MyAdaptor(name,phone,SecondActivity.this);

        listView.setAdapter(arrayAdapter);
    }
}
