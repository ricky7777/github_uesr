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
    private static AlertDialog alertDialog;

    public static void showProgressDialog(Context context) {
        if (alertDialog == null) {
            alertDialog = new AlertDialog.Builder(context, R.style.CustomProgressDialog).create();
        }

        View loadView = LayoutInflater.from(context).inflate(R.layout.progress_dialog_view
                , null);
        alertDialog.setView(loadView, 0, 0, 0, 0);
        alertDialog.setCanceledOnTouchOutside(false);

        if (!((Activity) context).isFinishing()) {
            alertDialog.show();
        }
    }

    public static void dismiss() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    public static void onDestory() {
        alertDialog = null;
    }
}
