package dte.masteriot.mdp.finalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    // Holds references to individual item views
    Context context;
    TextView name;
    TextView district;
    TextView cp;

    private static final String TAG = "ListOfItems, MyViewHolder";

    public MyViewHolder(Context ctxt, View centerView) {
        super(centerView);
        context = ctxt;
        name = centerView.findViewById(R.id.name);
        district = centerView.findViewById(R.id.district);
        cp = centerView.findViewById(R.id.cp);
    }

    void bindValues(SportCenter center, Boolean isSelected) {
        // give values to the elements contained in the item view
        name.setText(center.getName());
        district.setText(center.getDistrict());
        cp.setText(center.getCp());
        if(isSelected) {
            name.setTextColor(Color.BLUE);
        } else {
            name.setTextColor(Color.BLACK);
        }
    }

    @SuppressLint("LongLogTag")
    @Nullable
    public ItemDetailsLookup.ItemDetails<Long> getCenterDetails() {

        Log.d(TAG, "getItemDetails() called");

        ItemDetailsLookup.ItemDetails<Long> itemdet = new ItemDetailsLookup.ItemDetails<Long>() {
            @Override
            public int getPosition() {
                Log.d(TAG, "ItemDetailsLookup.ItemDetails<Long>.getPosition() called");
                return getAdapterPosition();
            }

            @Nullable
            @Override
            public Long getSelectionKey() {
                Log.d(TAG, "ItemDetailsLookup.ItemDetails<Long>.getSelectionKey() called");
                return (long) (getAdapterPosition());
            }
        };

        return itemdet;
    }
}
