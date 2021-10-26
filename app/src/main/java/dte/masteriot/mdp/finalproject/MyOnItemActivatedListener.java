package dte.masteriot.mdp.finalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.OnItemActivatedListener;

public class MyOnItemActivatedListener implements OnItemActivatedListener {

    private static final String TAG = "ListOfItems, MyOnItemActivatedListener";

    private Context context;

    public MyOnItemActivatedListener(Context context) {
        this.context = context;
    }

    @SuppressLint("LongLogTag")
    @Override
    public boolean onItemActivated(@NonNull ItemDetailsLookup.ItemDetails item,
                                   @NonNull MotionEvent e) {
        Log.d(TAG, "Clicked item with position = " + item.getPosition());
        Intent i = new Intent(context, sports_center.class);
        i.putExtra("text", "Clicked Sport Center with position = " + item.getPosition());
        context.startActivity(i);
        return true;
    }
}
