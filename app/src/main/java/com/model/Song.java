package com.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {
    int id;
    String imageSong;
    String titleSong;
    String singerName;

    public Song() {
    }

    public Song(int id, String imageSong, String titleSong, String singerName) {
        this.id = id;
        this.imageSong = imageSong;
        this.titleSong = titleSong;
        this.singerName = singerName;
    }

    protected Song(Parcel in) {
        imageSong = in.readString();
        titleSong = in.readString();
        singerName = in.readString();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageSong() {
        return imageSong;
    }

    public void setImageUrl(String imageSong) {
        this.imageSong = imageSong;
    }

    public String getTitleSong() {
        return titleSong;
    }

    public void setTitleSong(String titleSong) {
        this.titleSong = titleSong;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageSong);
        dest.writeString(titleSong);
        dest.writeString(singerName);
    }
}
