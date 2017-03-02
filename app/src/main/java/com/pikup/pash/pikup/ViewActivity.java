package com.pikup.pash.pikup;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        // Toolbar
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Fragment
        FragmentManager fm = getFragmentManager();
        //ItemDetailFragment idtf = (ItemDetailFragment) fm.findFragmentByTag("idtf");
        //if (idtf == null) {
        ItemFeedFragment ilf = (ItemFeedFragment) fm.findFragmentByTag("ilf");
        if (ilf == null) {
            ilf = new ItemFeedFragment();
            fm.beginTransaction()
                    .add(R.id.frame, ilf, "ilf")
                    .commit();
        }
    }
}
