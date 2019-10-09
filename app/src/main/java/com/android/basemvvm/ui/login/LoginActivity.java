package com.android.basemvvm.ui.login;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import com.android.basemvvm.AppActivity;
import com.android.basemvvm.R;
import com.android.basemvvm.ui.main.MainActivity;

public class LoginActivity extends AppActivity<LoginViewModel> {

    @BindView(R.id.edtUserId)
    EditText edtUserId;

    @Override
    protected int defaultLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected Class<LoginViewModel> viewModelClass() {
        return LoginViewModel.class;
    }

    @Override
    protected void setView() {
        listenerViewModel();
    }

    @OnClick(R.id.btnLogin)
    void onLogonClick() {
        int id = Integer.parseInt(edtUserId.getText().toString());
        viewModel.getUser(id);
    }

    private void listenerViewModel() {
        viewModel.userSuccess.observe(this, user -> {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        });
        viewModel.userFailure.observe(this, throwable -> {
            Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
        });
    }
}
