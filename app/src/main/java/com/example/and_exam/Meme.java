package com.example.and_exam;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "favorites_table")
public class Meme {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String mTitle;
    private String url;

    public Meme(String title, String url) {
        mTitle = title;
        this.url = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return url;
    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

}
