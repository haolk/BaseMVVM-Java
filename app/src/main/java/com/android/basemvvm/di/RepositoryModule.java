package com.android.basemvvm.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.android.basemvvm.data.source.interf.AppDataSource;
import com.android.basemvvm.data.source.remote.RemoteDataSource;
import com.android.basemvvm.util.anotation.Remote;

@Module
public class RepositoryModule {
    @Singleton
    @Provides
    @Remote
    AppDataSource provideFleetRemoteDataSource(RemoteDataSource appApi) {
        return appApi;
    }
}
