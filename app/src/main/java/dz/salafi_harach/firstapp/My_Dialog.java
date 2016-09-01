package dz.salafi_harach.firstapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

/**
 * Created by noussair on 31/08/16.
 */
public class My_Dialog extends DialogFragment {

    private String title;
    private int resource;
    public void setParameter(String title, int resource)
    {
        this.title = title;
        this.resource = resource;
    }
    public interface My_DialogListener
    {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    My_DialogListener mListener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (My_DialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        if(resource != 0)
        {
            builder.setTitle(title)
                    .setView(inflater.inflate(resource, null))
                    .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            mListener.onDialogPositiveClick(My_Dialog.this);
                        }
                    })
                    .setNegativeButton(" إلغاء ", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            mListener.onDialogNegativeClick(My_Dialog.this);
                        }
                    });
        }
        else
        {
            builder.setMessage(title)
                    .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            mListener.onDialogPositiveClick(My_Dialog.this);
                        }
                    })
                    .setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            mListener.onDialogNegativeClick(My_Dialog.this);
                        }
                    });
        }
        // Create the AlertDialog object and return it
        return builder.create();
    }

}

