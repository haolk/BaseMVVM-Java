package rikkeisoft.androidtraining.willer.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rikkeisoft.androidtraining.willer.data.source.interf.AppDataSource;
import rikkeisoft.androidtraining.willer.data.source.remote.RemoteDataSource;
import rikkeisoft.androidtraining.willer.util.anotation.Remote;

@Module
public class RepositoryModule {
    @Singleton
    @Provides
    @Remote
    AppDataSource provideFleetRemoteDataSource(RemoteDataSource appApi) {
        return appApi;
    }
}
