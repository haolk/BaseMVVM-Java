package com.android.basemvvm.data.source.remote;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import com.android.basemvvm.data.network.AppApi;
import com.android.basemvvm.data.network.response.User;
import com.android.basemvvm.data.source.interf.AppDataSource;

@Singleton
public class RemoteDataSource implements AppDataSource {
    private final AppApi appApi;

    @Inject
    public RemoteDataSource(AppApi appApi) {
        this.appApi = appApi;
    }

    @Override
    public Flowable<User> getUser(int id) {
        return appApi.getUser(id);
    }
}
