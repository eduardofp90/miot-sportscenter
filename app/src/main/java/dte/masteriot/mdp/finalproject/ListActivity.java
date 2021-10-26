package dte.masteriot.mdp.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private static final List<SportCenter> listOfCenters = new ArrayList<>();
    private static boolean listofcenterssinitialized = false;

    private RecyclerView recyclerView;
    private Adapter recyclerViewAdapter;
    private SelectionTracker tracker;
    //private MyOnItemActivatedListener onItemActivatedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }


}