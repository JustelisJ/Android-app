package com.example.and_exam.Model;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MemeRepository {

    private MemeModel memeModel;
    private static MemeRepository instance;

    private MemeRepository()
    {
        memeModel = MemeModel.getInstance();
    }

    public static MemeRepository getInstance() {
        if(instance == null)
            instance = new MemeRepository();

        return instance;
    }

    public LiveData<List<Meme>> getAllMemes() {
        return memeModel.getAllMemes();
    }

    public void refresh() {
        memeModel.refresh();
    }
}
