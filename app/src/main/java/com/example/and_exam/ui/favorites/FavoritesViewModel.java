package com.example.and_exam.ui.favorites;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.and_exam.Meme;
import com.example.and_exam.MemeRepository;

import java.util.List;

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

    public LiveData<List<Meme>> getAllFavoriteMemes(){
        return repository.getAllMemes();
    }
}