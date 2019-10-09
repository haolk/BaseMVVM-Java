package com.android.basemvvm.data.network;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import com.android.basemvvm.data.network.response.User;

public interface AppApi {
    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );
}
