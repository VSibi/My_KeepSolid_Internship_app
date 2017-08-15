package com.sibich.my_keepsolid_internship_app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sibich.my_keepsolid_internship_app.adapters.TimesIndiaRecyclerAdapter;
import com.sibich.my_keepsolid_internship_app.api.RestClient;
import com.sibich.my_keepsolid_internship_app.listeners.OnTimesIndiaRecyclerItemClickListener;
import com.sibich.my_keepsolid_internship_app.models.TimesIndiaItem;
import com.sibich.my_keepsolid_internship_app.utils.Consts;
import com.sibich.my_keepsolid_internship_app.utils.Database;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimesIndiaActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private ProgressBar progressBar;

    private Database database;

    private TimesIndiaRecyclerAdapter adapter;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times_india);

        database = new Database(this);
        database.open();
        database.clearData();

        preferences = getSharedPreferences(Consts.PREFS_NAME, MODE_PRIVATE);


        recycler = (RecyclerView) findViewById(R.id.rv_times_india_recycler);
        progressBar = (ProgressBar) findViewById(R.id.pb_progress);

        adapter = new TimesIndiaRecyclerAdapter(database.getAllData(), this, new OnTimesIndiaRecyclerItemClickListener() {
            @Override
            public void onItemClick(View v, int position, Uri uri) {
                openRepo(uri);
            }
        });

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
        loadData();

    }


    private void openRepo(Uri uri) {
        try {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No application can handle this request."
                    + " Please install a webbrowser", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void showProgressBlock() {
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }

    }

    private void hideProgressBlock() {
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void makeErrorToast(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    private void loadData() {
        showProgressBlock();

        RestClient.getInstance().getService().getData("the-times-of-india", "latest", "4bd9750b2f7948b6b108ff09aff3f435").enqueue(new Callback<TimesIndiaItem>() {
     //   RestClient.getInstance().getService().getData("anekdot.ru", "new anekdot", 2).enqueue(new Callback<List<TimesIndiaItem>>() {
            @Override
            public void onResponse(Call<TimesIndiaItem> call, Response<TimesIndiaItem> response) {

                database.addApiData(response.body());
                adapter.swapCursor(database.getAllData());
                hideProgressBlock();
                recycler.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TimesIndiaItem> call, Throwable t) {
                hideProgressBlock();
                makeErrorToast("An error occurred during networking");
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.close();
    }
}
