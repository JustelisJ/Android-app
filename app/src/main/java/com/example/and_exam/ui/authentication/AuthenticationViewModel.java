package com.example.and_exam.ui.authentication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AuthenticationViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public AuthenticationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is layout fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}