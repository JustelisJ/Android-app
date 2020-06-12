package com.example.and_exam.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.and_exam.Model.Meme;
import com.example.and_exam.Model.MemeRepository;

import java.util.List;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MemeRepository repository;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
        repository = MemeRepository.getInstance();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Meme>> getAllMemes() {
        //TODO: should return all the memes from the API
        return repository.getAllMemes();
    }

    public void refresh() {
        //TODO: refreshes new memes from the reddit API
        repository.refresh();
    }
}