package rikkeisoft.androidtraining.willer.data.network;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rikkeisoft.androidtraining.willer.data.network.response.User;

public interface AppApi {
    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );
}
