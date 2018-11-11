package com.example.lzied.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DB_SQlite extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="test.db";
    public static final String TABLE_NAME="test_table";
    public static final String COL_1="ID";
    public static final String COL_2="Nom";
    public static final String COL_3="Prenom";

    public DB_SQlite(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table test_table (ID INTEGER PRIMARY KEY AUTOINCREMENT,Nom TEXT,Prenom TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    onCreate(db);
    }
    public boolean insertData(String nom,String prenom)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,nom);
        contentValues.put(COL_3,prenom);
        long res=db.insert(TABLE_NAME,null,contentValues);
       if(res==-1)
           return false;
       else
           return true;
    }
}
