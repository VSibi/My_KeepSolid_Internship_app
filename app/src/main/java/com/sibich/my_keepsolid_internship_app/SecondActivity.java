package com.sibich.my_keepsolid_internship_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sibich.my_keepsolid_internship_app.models.User;
import com.sibich.my_keepsolid_internship_app.models.UserLab;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String EXTRA_ID = "com.sibich.my_keepsolid_internship_app_email";
    public static final String EXTRA_ANSWER = "com.sibich.my_keepsolid_internship_app_answer";

    private TextView mEmailTextView, mIsOnline, mUserName, mCategory;
    private Button mDeclineButton, mConfirmButton;
    private int mId;
    private User mUser;

    public static Intent newIntent(Context packageContext, int id) {
        Intent i = new Intent(packageContext, SecondActivity.class);
        i.putExtra(EXTRA_ID, id);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         mId = getIntent().getIntExtra(EXTRA_ID, -1);
        mUser = UserLab.getInstance().getUser(mId);

        mUserName = (TextView) findViewById(R.id.tv_user_name);
        mUserName.setText(mUser.getUserName());

        mIsOnline = (TextView) findViewById(R.id.tv_is_online);
        if (mUser.isOnline()) {
            mIsOnline.setText(getResources().getString(R.string.online));
        } else {
            mIsOnline.setText(getResources().getString(R.string.offline));
        }

        mEmailTextView = (TextView) findViewById(R.id.tv_email);
        mEmailTextView.setText(mUser.getUserAddress());


        mCategory = (TextView) findViewById(R.id.tv_category);
        mCategory.setText(mUser.getCategory().name());

        mDeclineButton = (Button) findViewById(R.id.b_decline);
        mDeclineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnswer(false);
            }
        });

        mConfirmButton = (Button) findViewById(R.id.b_confirm);
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnswer(true);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setAnswer(boolean isAnswer) {
        String email = getIntent().getStringExtra(EXTRA_ID);
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER, email);
        if (isAnswer) {
            Toast.makeText(this, getResources().getString(R.string.sending_message), Toast.LENGTH_SHORT).show();

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{mUser.getUserAddress()});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Message body");
            emailIntent.setType("text/plain");
            startActivity(Intent.createChooser(emailIntent, "Send Email"));

            setResult(RESULT_OK, data);
        } else {
            setResult(RESULT_CANCELED, data);
        }
        finish();
    }

    public static String getAnswer(Intent result) {
        return result.getStringExtra(EXTRA_ANSWER);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
