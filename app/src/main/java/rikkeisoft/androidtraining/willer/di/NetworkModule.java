package rikkeisoft.androidtraining.willer.di;


import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rikkeisoft.androidtraining.willer.BuildConfig;
import rikkeisoft.androidtraining.willer.data.network.AppApi;
import rikkeisoft.androidtraining.willer.util.AppConstants;
import rikkeisoft.androidtraining.willer.util.anotation.Remote;
import rikkeisoft.androidtraining.willer.util.scheduler.BaseSchedulerProvider;
import rikkeisoft.androidtraining.willer.util.scheduler.SchedulerProvider;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    BaseSchedulerProvider provideSchedulerProvider() {
        return new SchedulerProvider();
    }

    @Singleton
    @Provides
    @Remote
    AppApi appApi(@Remote Retrofit retrofit) {
        return retrofit.create(AppApi.class);
    }

    @Provides
    @Singleton
    @Remote
    Retrofit restAppApi(OkHttpClient client, GsonBuilder builder) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(builder.create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        retrofitBuilder.client(client);
        return retrofitBuilder.build();
    }

    @Provides
    @Singleton
    GsonBuilder gsonBuilder() {
        return new GsonBuilder();
    }

    @Provides
    @Singleton
    OkHttpClient getHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                .readTimeout(20, TimeUnit.SECONDS);
        return builder.build();
    }
}

