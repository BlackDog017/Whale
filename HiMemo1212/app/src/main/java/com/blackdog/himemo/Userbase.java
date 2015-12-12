package com.blackdog.himemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asus on 2015/12/12.
 */
public class Userbase extends SQLiteOpenHelper {

        public static final String CREATE_USER= " create table Memo("
                + "id integer primary key autoincrement, "
                + "account text, "
                + "password text) ";

        private Context mContext;

        public Userbase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            mContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_USER);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

