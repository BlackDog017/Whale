package com.blackdog.himemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondAty extends AppCompatActivity {
    private ListView listView;
    private TimeLineAdapter timelineAdapter;
    String a = "";
    private List list = new ArrayList();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.second_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==(R.id.add)){
            startActivity(new Intent(SecondAty.this,ThirdAty.class));

        }
        if(item.getItemId()==(R.id.refresh)){
            ListView listView = (ListView)findViewById(R.id.listView);
            list.clear();
            this.getMemo();
            timelineAdapter.notifyDataSetChanged();

        }
        if(item.getItemId()==(R.id.delete)){



        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_aty);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        timelineAdapter = new TimeLineAdapter(this, getMemo());
        timelineAdapter.notifyDataSetChanged();
        ListView listView  = (ListView)findViewById(R.id.listView);
        listView.setAdapter(timelineAdapter);


    }



    private List<Map<String, Object>> getMemo() {
        UserDatabase userDatabase = new UserDatabase(SecondAty.this, "Memo.db", null, 4);
        SQLiteDatabase db = userDatabase.getWritableDatabase();
        Cursor cursor = db.query("Memo",null,null,null,null,null,null,null);
        if(cursor.moveToFirst()) {
            do {
                String content = cursor.getString(cursor.getColumnIndex("content"));
                String time = cursor.getString(cursor.getColumnIndex("time"));
                listView = (ListView) this.findViewById(R.id.listView);
                listView.setDividerHeight(0);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("title", content);
                map.put("time", time);
                list.add(map);
                listView.setAdapter(timelineAdapter);


            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }



    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SecondAty Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.blackdog.himemo/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SecondAty Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.blackdog.himemo/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }}

/**
 * Created by asus on 2015/12/5.
 */

