package com.example.movilversion.ui.login.ui.carreras;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CarreraViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CarreraViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is carreras fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}