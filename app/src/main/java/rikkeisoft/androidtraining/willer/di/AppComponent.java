package rikkeisoft.androidtraining.willer.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
import rikkeisoft.androidtraining.willer.BaseApplication;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBindingModule.class,
                NetworkModule.class,
                ApplicationModule.class,
                RepositoryModule.class
        }
)
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication baseApplication);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
