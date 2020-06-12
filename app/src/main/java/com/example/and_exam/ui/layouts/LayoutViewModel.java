package com.example.and_exam.ui.layouts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LayoutViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public LayoutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is layout fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
