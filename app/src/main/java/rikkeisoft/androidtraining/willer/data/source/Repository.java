package rikkeisoft.androidtraining.willer.data.source;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import rikkeisoft.androidtraining.willer.data.network.AppApi;
import rikkeisoft.androidtraining.willer.data.network.response.User;
import rikkeisoft.androidtraining.willer.data.source.interf.AppDataSource;
import rikkeisoft.androidtraining.willer.data.source.interf.DBSource;
import rikkeisoft.androidtraining.willer.util.anotation.Remote;

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
