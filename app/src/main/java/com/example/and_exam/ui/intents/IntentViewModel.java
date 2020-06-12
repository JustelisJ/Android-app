package com.example.and_exam.ui.intents;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IntentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public IntentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is intent fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}