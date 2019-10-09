package com.android.basemvvm.data.source.interf;

import io.reactivex.Flowable;
import com.android.basemvvm.data.network.response.User;

public interface AppDataSource {
    Flowable<User> getUser(int id);
}
