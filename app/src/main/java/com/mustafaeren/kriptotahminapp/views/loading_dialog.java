package com.mustafaeren.kriptotahminapp.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import androidx.appcompat.widget.ActivityChooserView;

import com.mustafaeren.kriptotahminapp.R;

public class loading_dialog {
    private Activity activity;
    private AlertDialog alertDialog;

    public loading_dialog(Activity activity) {
        this.activity = activity;
    }

    void startLoading()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog,null));

        builder.setCancelable(false);
        alertDialog= builder.create();
        alertDialog.show();

    }

    void dismissDialog()
    {
        alertDialog.dismiss();
    }
}
