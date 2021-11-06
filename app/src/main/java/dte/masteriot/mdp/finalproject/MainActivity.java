package dte.masteriot.mdp.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bsub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bsub = findViewById(R.id.bSubmit);
   /*     bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListActivity();
            }
        }); */

    }
    public void openListActivity(){
        Intent iList = new Intent(this, ListActivity.class);
        startActivity(iList);
    }
    public void clickList(){
        Intent iList = new Intent(this, ListActivity.class);
        startActivity(iList);
    }
}