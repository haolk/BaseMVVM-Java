package rikkeisoft.androidtraining.willer.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import rikkeisoft.androidtraining.willer.ui.login.LoginActivity;
import rikkeisoft.androidtraining.willer.ui.login.LoginModule;
import rikkeisoft.androidtraining.willer.ui.main.MainActivity;
import rikkeisoft.androidtraining.willer.ui.main.MainModule;
import rikkeisoft.androidtraining.willer.util.anotation.ActivityScoped;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = {LoginModule.class})
    abstract LoginActivity loginActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity mainActivity();
}
