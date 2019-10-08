package rikkeisoft.androidtraining.willer.data.source.remote;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import rikkeisoft.androidtraining.willer.data.network.AppApi;
import rikkeisoft.androidtraining.willer.data.network.response.User;
import rikkeisoft.androidtraining.willer.data.source.interf.AppDataSource;

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
