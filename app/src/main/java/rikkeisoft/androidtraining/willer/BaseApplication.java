package rikkeisoft.androidtraining.willer;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import rikkeisoft.androidtraining.willer.di.DaggerAppComponent;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
