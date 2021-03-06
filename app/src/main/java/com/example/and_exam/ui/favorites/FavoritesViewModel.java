package com.example.and_exam.ui.favorites;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.and_exam.MemeRepository;
import com.example.and_exam.Model.Meme;

import java.util.ArrayList;

public class FavoritesViewModel extends AndroidViewModel {
    private Application mApplication;
    private MutableLiveData<String> mText;
    private MemeRepository repository;

    public FavoritesViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mText = new MutableLiveData<>();
        mText.setValue("This is favorite fragment");
        repository = MemeRepository.getInstance(mApplication);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public ArrayList<Meme> getAllFavoriteMemes(){
        return repository.getAllMemes();
    }
}