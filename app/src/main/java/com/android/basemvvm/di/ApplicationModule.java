package com.android.basemvvm.di;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

@Module(includes = {ViewModelModule.class})
public abstract class ApplicationModule {
    @Binds
    abstract Context bindContext(Application application);
}
