package com.example.d038395.myfilelist;

import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;


public class MainActivity extends ActionBarActivity {

    static final String filePathString=
            Environment.getExternalStorageDirectory().getPath();
    //File.separator;+R.string.app_name;
    static final File filePath= new File(filePathString);

    /*static boolean existPath(){
        return (filePath.mkdir()||filePath.isDirectory());
    }*/

    String[] countryArray = {"China","italy","USA","German"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*if(!existPath()){
            Log.e("Directory","not exist");
            return;
        }*/
        String[] fileList=filePath.list();
        ArrayAdapter adapter = new ArrayAdapter<>(this,
                R.layout.activity_listview,
                fileList);
        ListView listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
