package com.android.basemvvm.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.android.basemvvm.ui.login.LoginActivity;
import com.android.basemvvm.ui.login.LoginModule;
import com.android.basemvvm.ui.main.MainActivity;
import com.android.basemvvm.ui.main.MainModule;
import com.android.basemvvm.util.anotation.ActivityScoped;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = {LoginModule.class})
    abstract LoginActivity loginActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity mainActivity();
}
