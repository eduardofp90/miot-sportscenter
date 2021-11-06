package dte.masteriot.mdp.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private static final List<SportCenter> listOfCenters = new ArrayList<>();
    private static boolean listofcenterssinitialized = false;

    private RecyclerView recyclerView;
    private Adapter recyclerViewAdapter;
    private SelectionTracker tracker;
    private MyOnItemActivatedListener onItemActivatedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initListOfItems();

        // Prepare the RecyclerView:
        recyclerView = findViewById(R.id.rv_sports_center_list);
        recyclerViewAdapter = new Adapter(this, listOfCenters);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Choose the layout manager to be set.
        // some options for the layout manager:  GridLayoutManager, LinearLayoutManager, StaggeredGridLayoutManager
        // initially, a linear layout is chosen:
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Selection tracker (to allow for selection of items):
        onItemActivatedListener = new MyOnItemActivatedListener(this);
        tracker = new SelectionTracker.Builder<>(
                "my-selection-id",
                recyclerView,
                new MyItemKeyProvider(ItemKeyProvider.SCOPE_MAPPED),
//                new StableIdKeyProvider(recyclerView), // This caused the app to crash on long clicks
                new MyCenterDetailsLookup(recyclerView),
                StorageStrategy.createLongStorage())
                .withOnItemActivatedListener(onItemActivatedListener)
                .build();
        recyclerViewAdapter.setSelectionTracker(tracker);

        if (savedInstanceState != null) {
            // Restore state on selections
            tracker.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        tracker.onSaveInstanceState(outState); // Save state about selections.
    }

    private void initListOfItems () {
        // Populate the list of items if not done before:
        final int ITEM_COUNT = 50;
        if (listofcenterssinitialized == false) {
            for (int i = 0; i < ITEM_COUNT; i++) {
                listOfCenters.add(new SportCenter("SportCenter " + i, "District " + i, i));
            }
            listofcenterssinitialized = true;
        }
    }

    // ------ Button on-click listeners ------ //

    public void listLayout(View view) {
        // Button to see in a linear fashion is clicked:
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void gridLayout(View view) {
        // Button to see in a grid fashion is clicked:
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    public void seeCurrentSelection(View view) {
        // Button "see current selection" clicked
        Iterator iterator = tracker.getSelection().iterator();
        String text = "";
        while (iterator.hasNext()) {
            text += iterator.next().toString();
            if (iterator.hasNext()) {
                text += ", ";
            }
        }
        text = "Currently selected items = \n" + text;
        //Intent i = new Intent(this, SecondActivity.class);
        //i.putExtra("text", text);
        //startActivity(i);
    }

}
