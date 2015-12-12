package com.blackdog.himemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FourthAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_aty);
        UserDatabase userDatabase = new UserDatabase(FourthAty.this, "Memo.db", null, 4);
        SQLiteDatabase db = userDatabase.getWritableDatabase();
        Cursor cursor = db.query("Memo", null, null, null, null, null, null, null);
        String id = cursor.getString(cursor.getColumnIndex("id"));
    }
}
