package com.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.com.modify.SongModify;

public class DBHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "SongApp";
    static final int VERSION = 1;

    static  DBHelper instance = null;

    private DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    public synchronized static DBHelper getInstance(Context context){
        if(instance == null){
            instance = new DBHelper(context);
        }
        return  instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //chỉ gọi lần đầu tiên để khỏi tạo DB , chỉ 1 lần duy nhất
        sqLiteDatabase.execSQL(SongModify.TABLE_SQL);
        Log.d(DBHelper.class.getName(), "****CREATE TABLE SUCCESS");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //chỉ gọi 1 lần khi thây đổi VERSION của DB

    }
}
