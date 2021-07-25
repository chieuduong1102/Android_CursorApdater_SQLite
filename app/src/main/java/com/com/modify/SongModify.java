package com.com.modify;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.db.DBHelper;
import com.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongModify  {
    private  static final String TABLE_NAME = "songs";

    public static final String TABLE_SQL = "CREATE TABLE songs (\n" +
            "\tid integer primary key autoincrement,\n" +
            "\timageSong varchar(500) not null,\n" +
            "\ttitleSong varchar(150),\n" +
            "\tsingerName varchar(150)\n" +
            ")";

    public static void insert(Song song) {
        ContentValues values = new ContentValues();
        values.put("imageSong",song.getImageSong());
        values.put("titleSong", song.getTitleSong());
        values.put("singerName",song.getSingerName());

        SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(null).getWritableDatabase();
        sqLiteDatabase.insert(TABLE_NAME,null,values);
    }

    public static void update(Song song){
        ContentValues values = new ContentValues();
        values.put("imageSong",song.getImageSong());
        values.put("titleSong", song.getTitleSong());
        values.put("singerName",song.getSingerName());

        SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(null).getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME, values, " _id = " + song.getId(), null);
    }

    public static void delete(int id) {
        //Insert database
        SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(null).getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, " id = " + id, null);
    }

    public static Song find(int id){
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id = " + id;

        SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(null).getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

        Song song = null;
        while (cursor.moveToNext()){
            song = new Song(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("imageSong")),
                    cursor.getString(cursor.getColumnIndex("titleSong")),
                    cursor.getString(cursor.getColumnIndex("singerName"))
            );
            break;
        }
        return song;
    }

    public static List<Song> getSongList(){
        List<Song> songList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(null).getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
        while (cursor.moveToNext()){
            Song song = new Song(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("imageSong")),
                    cursor.getString(cursor.getColumnIndex("titleSong")),
                    cursor.getString(cursor.getColumnIndex("singerName"))
            );
            songList.add(song);
        }
        return  songList;
    }

    public static Cursor getSongCursor(){
        String sqlQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(null).getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
        return cursor;
    }
}
