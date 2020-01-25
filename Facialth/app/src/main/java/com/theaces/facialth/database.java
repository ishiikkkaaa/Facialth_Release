package com.theaces.facialth;

import android.app.DownloadManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME="contacts.db";
    private static final String COLOUMN_ID="contacts.db";
    private static final String COLOUMN_name="name";
    private static final String COLOUMN_age="age";
    private static final String COLOUMN_uname="uname";
    private static final String COLOUMN_email="email";
    private static final String COLOUMN_password="password";
    private static final String COLOUMN_bloodgroup="bloodgroup";
    private static final String COLOUMN_gender="gender";
    private static final String TABLE_CREATE="create table contacts(id integer primary key not null auto_increment , "+"name text not null , age text not null , uname text not null , email text not null , password text not null , bloodgroup text not null , gender text not null);";
    SQLiteDatabase db;

public database (Context context)
{
    super(context , DATABASE_NAME , null, DATABASE_VERSION);
}

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db = db;


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.db = db;
    }
}
