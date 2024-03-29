package com.android.basemvvm.ui.login;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import com.android.basemvvm.AppViewModel;
import com.android.basemvvm.data.network.response.User;

public class LoginViewModel extends AppViewModel {

    @Inject
    public LoginViewModel() {
    }

    MutableLiveData<User> userSuccess = new MutableLiveData<>();
    MutableLiveData<Throwable> userFailure = new MutableLiveData<>();

    public void getUser(int id) {
        showLoading();
        addDisposable(repository.getUser(id)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(user -> {
                    closeLoading();
                    userSuccess.setValue(user);
                }, throwable -> {
                    closeLoading();
                    userFailure.setValue(throwable);
                }));
    }
}
