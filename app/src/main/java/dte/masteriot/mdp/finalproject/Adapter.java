package dte.masteriot.mdp.finalproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<MyViewHolder>{

    private static final String TAG = "ListOfCenters, MyAdapter";

    private List<SportCenter> centers;
    private SelectionTracker selectionTracker;
    Context context;


    public Adapter(Context ctxt, List<SportCenter> listofcenters) {
        super();
        context = ctxt;
        centers = listofcenters;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method has to actually inflate the item view and return the view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sports_center, parent, false);
        return new MyViewHolder(context, v);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // this method actually gives values to the elements of the view holder
        // (values corresponding to the item in 'position')
        final SportCenter center = centers.get(position);
        holder.bindValues(center, selectionTracker.isSelected(holder.getCenterDetails().getSelectionKey()));
    }

    @Override
    public int getItemCount() {
        return centers.size();
    }

    public void setSelectionTracker(SelectionTracker selectionTracker) {
        this.selectionTracker = selectionTracker;
    }

}
