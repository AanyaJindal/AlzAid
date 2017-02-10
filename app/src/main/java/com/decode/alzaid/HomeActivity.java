package com.decode.alzaid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    String[] itemList = {"Home","Call Home","Quiz","New Question"};
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        List<String> st = Arrays.asList(itemList);
        recyclerView = (RecyclerView) findViewById(R.id.home_recycler_view);
        RecyclerView.Adapter mAdapter = new HomeAdapter(st,getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);


    }
}
