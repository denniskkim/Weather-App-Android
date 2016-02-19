package com.example.denniskim.stormy.UI;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by denniskim on 8/25/15.
 */
public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        //Builder is a class extension of the AlertDialog class , which is referred to the
        // factory method pattern
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Oops Sorry")
                .setMessage("There was an error. Please Try again.")
                .setPositiveButton("OK", null); // null onclicklistener will close the dialong

        AlertDialog dialog = builder.create();
        return dialog;

    }
}
