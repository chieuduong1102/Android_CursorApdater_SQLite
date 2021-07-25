package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.com.adapter.SongCursorAdapter;
import com.com.modify.SongModify;
import com.db.DBHelper;
import com.model.Song;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Song> listSong = new ArrayList<>();
    SongCursorAdapter adapter;
    Cursor currentCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper.getInstance(this);

        listView = findViewById(R.id.am_listViewSong);
        currentCursor = SongModify.getSongCursor();
        adapter = new SongCursorAdapter(this, currentCursor);
        listView.setAdapter(adapter);

    }
}