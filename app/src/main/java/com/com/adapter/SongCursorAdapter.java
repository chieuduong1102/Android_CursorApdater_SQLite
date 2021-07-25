package com.com.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class SongCursorAdapter extends CursorAdapter {

    Activity activity;

    public SongCursorAdapter(Activity activity, Cursor c){
        super(activity, c);
        this.activity = activity;
    }



    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.song_layout,null);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView imageSongView = view.findViewById(R.id.sl_imageSong);
        TextView titleSongView = view.findViewById(R.id.sl_titleSong);
        TextView singerNameView = view.findViewById(R.id.sl_singerName);

        String imageSongCursor = cursor.getString(cursor.getColumnIndex("imageSong"));
        String titleSongCursor = cursor.getString(cursor.getColumnIndex("titleSong"));
        String singerNameCursor = cursor.getString(cursor.getColumnIndex("singerName"));

        titleSongView.setText(titleSongCursor);
        singerNameView.setText(singerNameCursor);
        Picasso.with(activity).load(imageSongCursor).into(imageSongView);
    }
}
