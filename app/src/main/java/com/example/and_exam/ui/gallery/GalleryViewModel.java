package com.example.and_exam.ui.gallery;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Meme;
import com.example.and_exam.MemeRepository;

import java.util.ArrayList;

public class GalleryViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private MemeRepository repository;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
        repository = MemeRepository.getInstance(application);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void addToFavorites(Meme meme)
    {
        repository.insert(meme);
    }

    public ArrayList<Meme> getMemesFromReddit()
    {
        return repository.getMayMaysFromReddit();
    }
}