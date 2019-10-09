package com.android.basemvvm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

public abstract class AppFragment<VM extends AppViewModel> extends DaggerFragment {
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    VM viewModel;

    protected abstract int defaultLayout();

    protected abstract Class<VM> viewModelClass();

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(defaultLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        viewModel = obtainViewModel();
        return view;
    }

    private VM obtainViewModel() {
        return ViewModelProviders.of(this, viewModelFactory).get(viewModelClass());
    }

    @Override
    public void onDestroy() {
        viewModel = null;
        unbinder.unbind();
        super.onDestroy();
    }
}
