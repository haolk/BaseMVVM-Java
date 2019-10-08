package rikkeisoft.androidtraining.willer;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;
import rikkeisoft.androidtraining.willer.util.DialogUtils;

public abstract class AppActivity<VM extends AppViewModel> extends DaggerAppCompatActivity {
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    public VM viewModel;

    protected abstract int defaultLayout();

    protected abstract Class<VM> viewModelClass();

    protected abstract void setView();

    private Unbinder unbinder;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        viewModel = obtainViewModel();
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(defaultLayout());
        AppActivity seft = this;
        if (viewModel != null)
            viewModel.loader.observe(this, aBoolean -> {
                if (aBoolean) {
                    seft.showLoading();
                } else {
                    seft.closeLoading();
                }
            });
        setView();
    }

    @Override
    protected void onDestroy() {
        viewModel = null;
        unbinder.unbind();
        super.onDestroy();
    }

    private VM obtainViewModel() {
        return ViewModelProviders.of(this, viewModelFactory).get(viewModelClass());
    }

    public void showLoading() {
        DialogUtils.showProgress(this);
    }

    public void closeLoading() {
        DialogUtils.closeMessage();
    }
}
