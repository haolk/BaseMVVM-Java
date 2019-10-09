package com.android.basemvvm;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import com.android.basemvvm.di.DaggerAppComponent;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
