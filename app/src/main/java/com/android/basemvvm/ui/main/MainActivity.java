package com.android.basemvvm.ui.main;

import com.android.basemvvm.AppActivity;
import com.android.basemvvm.R;

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
