package com.blackdog.himemo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ThirdAty extends AppCompatActivity {
    private EditText editText;
    private int temp;
    private UserDatabase udBase;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.third_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==(R.id.save)){
            String time = getSysNowTime();
            editText = (EditText)findViewById(R.id.editText);
            String content = editText.getText().toString();
            if (content == null || content.equals("")) {
                Toast.makeText(getApplicationContext(),
                        "Memo内容不能为空", Toast.LENGTH_SHORT)
                        .show();
            } else {
                udBase = new UserDatabase(this, "Memo.db", null, 4);
                udBase.getWritableDatabase();
                SQLiteDatabase db = udBase.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("content", content);
                values.put("time",time);
                db.insert("Memo", null, values);
                values.clear();
                Toast.makeText(ThirdAty.this, "保存成功", Toast.LENGTH_SHORT).show();
                finish();


            }

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_aty);

    }
    public String getSysNowTime(){
       /* Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
    */
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    }
}
