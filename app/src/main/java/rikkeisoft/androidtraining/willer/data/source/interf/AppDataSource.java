package rikkeisoft.androidtraining.willer.data.source.interf;

import io.reactivex.Flowable;
import rikkeisoft.androidtraining.willer.data.network.response.User;

public interface AppDataSource {
    Flowable<User> getUser(int id);
}
