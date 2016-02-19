package com.example.denniskim.stormy.UI;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.denniskim.stormy.Adapters.DayAdapter;
import com.example.denniskim.stormy.Adapters.HourAdapter;
import com.example.denniskim.stormy.R;
import com.example.denniskim.stormy.Weather.Daily;
import com.example.denniskim.stormy.Weather.Hour;

import java.util.Arrays;

import butterknife.Bind;

public class HourlyForecastActivity extends AppCompatActivity {

    private Hour[] mHours;

    //@Bind(R.id.recyclerView) RecyclerView mRecyclerView;

   // RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);

        mHours = Arrays.copyOf(parcelables, parcelables.length, Hour[].class);

      //  final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
      //  mRecyclerView.setLayoutManager(layoutManager);

        HourAdapter adapter = new HourAdapter(this,mHours);
        mRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);


        mRecyclerView.setHasFixedSize(true);


        // creating our customized adapter to create our listView
      //  HourAdapter adapter = new DayAdapter(this, mHours);
      //  setListAdapter(adapter);
    }

}
