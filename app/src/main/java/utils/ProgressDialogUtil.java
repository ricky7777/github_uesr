package utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.shopback.exercise.gituser.R;

/**
 * Created by Ricky on 2019-05-29.<br/>
 * progress dialog util, will adapter progress dialog and show
 */
public class ProgressDialogUtil {
    private static AlertDialog mAlertDialog;

    public static void showProgressDialog(Context context) {
        if (mAlertDialog == null) {
            mAlertDialog = new AlertDialog.Builder(context, R.style.CustomProgressDialog).create();
        }

        View loadView = LayoutInflater.from(context).inflate(R.layout.progress_dialog_view
                , null);
        mAlertDialog.setView(loadView, 0, 0, 0, 0);
        mAlertDialog.setCanceledOnTouchOutside(false);

        if (!((Activity) context).isFinishing()) {
            mAlertDialog.show();
        }
    }

    public static void dismiss() {
        if (mAlertDialog != null && mAlertDialog.isShowing()) {
            mAlertDialog.dismiss();
        }
    }
}
