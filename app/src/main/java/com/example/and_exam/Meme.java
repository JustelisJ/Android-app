package com.example.and_exam;

public class Meme {
    private String mTitle;
    private int mIconId;

    public Meme(String name, int iconId) {
        mTitle = name;
        mIconId = iconId;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getIconId() {
        return mIconId;
    }

}
