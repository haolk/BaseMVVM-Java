package rikkeisoft.androidtraining.willer.util;

import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import rikkeisoft.androidtraining.willer.R;

public class DialogUtils {
    private static AlertDialog mAlertDialog;
    public static void showProgress(FragmentActivity activity) {
        if (!activity.isFinishing()) {
            if (mAlertDialog == null) {
                closeMessage();
                View view = activity.getLayoutInflater().inflate(R.layout.progress_bar, null, false);
                AlertDialog.Builder builder = getBuilderProgress(activity)
                        .setCancelable(false)
                        .setView(view);
                show(activity, builder);
            }
        }
    }

    public static void closeMessage() {
        try {
            if (mAlertDialog != null && mAlertDialog.isShowing()) {
                mAlertDialog.cancel();
                mAlertDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show(FragmentActivity activity, AlertDialog.Builder builder) {
        if (!activity.isFinishing()) {
            try {
                closeMessage();
                mAlertDialog = builder.create();
                mAlertDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static AlertDialog.Builder getBuilderProgress(FragmentActivity activity) {
        return new AlertDialog.Builder(activity, R.style.AppCompat_AlertDialog_Progress);
    }
}
