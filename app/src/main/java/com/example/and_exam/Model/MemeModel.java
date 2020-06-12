package com.example.and_exam.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemeModel {

    private MutableLiveData<List<Meme>> allMemes;
    private static MemeModel instance;

    private MemeModel()
    {
        allMemes = new MutableLiveData<>();
        List<Meme> newList = new ArrayList<>();
        allMemes.setValue(newList);
    }

    public static MemeModel getInstance() {
        if(instance == null)
            instance = new MemeModel();

        return instance;
    }

    public LiveData<List<Meme>> getAllMemes() {
        return allMemes;
    }

    public void refresh() {
        List<Meme> newMemes = new ArrayList<>();
        //TODO: fetch data from API
        allMemes.setValue(newMemes);
    }

}
