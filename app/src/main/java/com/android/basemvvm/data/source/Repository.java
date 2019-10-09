package com.android.basemvvm.data.source;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import com.android.basemvvm.data.network.AppApi;
import com.android.basemvvm.data.network.response.User;
import com.android.basemvvm.data.source.interf.AppDataSource;
import com.android.basemvvm.data.source.interf.DBSource;
import com.android.basemvvm.util.anotation.Remote;

@Singleton
public class Repository implements AppDataSource, DBSource {
    private final AppApi remoteDataSource;

    @Inject
    public Repository(@Remote AppApi remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Flowable<User> getUser(int id) {
        return remoteDataSource.getUser(id);
    }
}
