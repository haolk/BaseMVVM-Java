package rikkeisoft.androidtraining.willer.ui.main;

import rikkeisoft.androidtraining.willer.AppActivity;
import rikkeisoft.androidtraining.willer.R;

public class MainActivity extends AppActivity<MainViewModel> {
    @Override
    protected int defaultLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected Class<MainViewModel> viewModelClass() {
        return MainViewModel.class;
    }

    @Override
    protected void setView() {

    }
}
