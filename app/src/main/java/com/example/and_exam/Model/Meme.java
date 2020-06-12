package com.example.and_exam.Model;

public class Meme {
    private String title;
    private int picId;

    public Meme(String title, int picId) {
        this.title = title;
        this.picId = picId;
    }

    public String getTitle() {
        return title;
    }

    public int getPicId() {
        return picId;
    }

}
