package com.example.denniskim.stormy.UI;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.denniskim.stormy.Adapters.DayAdapter;
import com.example.denniskim.stormy.R;
import com.example.denniskim.stormy.Weather.Daily;

import java.util.Arrays;

import butterknife.*;
import butterknife.ButterKnife;

public class DailyForecastActivity extends AppCompatActivity {

    private Daily[] mDays;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        ListView mListView = (ListView) findViewById(android.R.id.list);
        TextView mEmptyText = (TextView) findViewById(android.R.id.empty);


        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);

        mDays = Arrays.copyOf(parcelables,parcelables.length, Daily[].class);

        // creating our customized adapter to create our listView
        DayAdapter adapter = new DayAdapter(this, mDays);
        mListView.setAdapter(adapter);
        mListView.setEmptyView(mEmptyText);
        // this method is when you click on one of the items on the ListView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dayOfTheWeek = mDays[position].getDayOfTheWeek();
                String conditions = mDays[position].getSummary();
                String highTemp = mDays[position].getTempMax() + "";
                String message = String.format("On %s the high will be %s and it will be %s",
                        dayOfTheWeek,highTemp,conditions);

                // need to explicitly call the class dailyforecast because if not 'this' refers to
                // the Adapter.View class
                Toast.makeText(DailyForecastActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });


        /* An example of how to implement a built in adapter from android api. (arrayAdapter)

        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                daysOfTheWeek);

        setListAdapter(adapter);

        */

    }


}
