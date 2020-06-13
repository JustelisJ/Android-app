package com.example.and_exam;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "favorites_table")
public class Meme {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "url")
    private String url;

    public Meme(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }


}
