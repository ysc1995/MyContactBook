package com.example.shaochengyang.mycontactbook.ui;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaochengyang.mycontactbook.R;

import com.example.shaochengyang.mycontactbook.antiMVPDb.MyDBHelper;
import com.example.shaochengyang.mycontactbook.data.IDataManager;
import com.example.shaochengyang.mycontactbook.data.testDB.DATABASEHelper;
import com.example.shaochengyang.mycontactbook.service.MyIntentService;
import com.example.shaochengyang.mycontactbook.service.MyService;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements IView{
    private static final String TAG = "MainActivity";

    //private Receiver receiver;
    private LocalBroadcastManager localBroadcastManager;

    Button saveButton, countButton;
    Button button, button2;
    EditText phoneText,nameText;

    TextView checkText;

    IPresenter presenter;

    MyDBHelper myDBHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);

        phoneText = findViewById(R.id.phoneText);
        nameText = findViewById(R.id.nameText);
        saveButton = findViewById(R.id.saveButton);
        checkText = findViewById(R.id.checkText);


        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver,new IntentFilter("CUSTOM_ACTION"));
        /*receiver = new Receiver();
        IntentFilter filter = new IntentFilter(".");*/

        button = findViewById(R.id.button);


        Intent i = new Intent(MainActivity.this,MyService.class);
        startService(i);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MyService.class);
                stopService(i);
            }
        });

        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent i = new Intent();
                i.putExtra("Phone",phoneText.getText().toString());

                LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(i);
                Log.d(TAG, "onClick: sended"+phoneText.getText().toString());*/

                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
                intent.putExtra("Phone",phoneText.getText().toString());
                startService(intent);
            }
        });



    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {


            String phone = intent.getStringExtra("Phone");
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
            startActivity(i);
        }
    };



    public void clickHandler(View v) {
        switch (v.getId()){
            case R.id.countButton:
                //presenter.getCount(v);
                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute();
                break;

            case R.id.saveButton:
                presenter.onSaveButtonClicked(v,nameText.getText().toString(),phoneText.getText().toString());
                //mainSaveClicked(nameText.getText().toString(),phoneText.getText().toString());
                break;
            case R.id.viewButton:
                presenter.onViewButtonClicked(v,nameText.getText().toString());

                break;
            case R.id.viewAllButton:
                presenter.onViewAllButtonClicked(v);
                break;
        }
    }

    /*private void mainSaveClicked(String name, String phone) {
        *//*DATABASEHelper databaseHelper = new DATABASEHelper(MainActivity.this);
        databaseHelper.createRow2(name,phone);*//*
        myDBHelper = new MyDBHelper(MainActivity.this);
        sqLiteDatabase = myDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(myDBHelper.CNAME,name);

        contentValues.put(myDBHelper.CPHONE,phone);
        sqLiteDatabase.insert(myDBHelper.CTABLE,null,contentValues);


    }*/

    @Override
    public void navigateToSecActivity() {
        Intent i = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(i);
    }

    @Override
    public void showView() {
        Log.d(TAG, "navigateToViewFragment: came here");
    }

    @Override
    public void showPhoneData(String phone) {
        String name = nameText.getText().toString();
        ViewFragment fragment = (ViewFragment) getFragmentManager().findFragmentById(R.id.fragment);
        fragment.showDatas(name,phone);
    }

    @Override
    public void showAllData(String[] name, String[] phone) {
        Intent i = new Intent(MainActivity.this,SecondActivity.class);
        i.putExtra("CN",name);
        i.putExtra("CP",phone);

        startActivity(i);
    }


     public class MyAsyncTask extends AsyncTask<String, String , String> {
        IDataManager dataManager;

         @Override
         protected void onPreExecute() {
             super.onPreExecute();
             checkText.setText("");
         }

         @Override
        protected String doInBackground(String... strings) {

            if(!Pattern.matches("^[a-zA-Z0-9._-]{1,14}$", nameText.getText().toString())){
                publishProgress("Name not valid");
            }
            if(!Pattern.matches("^[0-9]{3,16}$", phoneText.getText().toString())){
                publishProgress("phone number not valid");
            }






            return null; //result goes to postExecute as s

        }

         @Override
         protected void onProgressUpdate(String... values) {
             super.onProgressUpdate(values);
             checkText.setText(""+values[0]);

         }


     }
}


