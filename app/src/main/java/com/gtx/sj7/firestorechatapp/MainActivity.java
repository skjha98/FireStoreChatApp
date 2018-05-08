package com.gtx.sj7.firestorechatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.gtx.sj7.firestorechatapp.Adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TextView profileLabel, allUsersLabel, notificationLabel;

    private ViewPager mViewPager;

    private ViewPagerAdapter mPagerAdapter;

    //Firebase Authentication
    FirebaseAuth mAuth;
    FirebaseUser mCurrentUser;

    @Override
    protected void onStart() {
        super.onStart();

        mCurrentUser = mAuth.getCurrentUser();
        if(mCurrentUser==null){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileLabel = findViewById(R.id.main_profile);
        allUsersLabel = findViewById(R.id.main_all_users);
        notificationLabel = findViewById(R.id.main_notification);

        mViewPager = findViewById(R.id.main_view_pager);

        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        profileLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPage(0);
            }
        });

        allUsersLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPage(1);
            }
        });

        notificationLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPage(2);
            }
        });

        //FirebaseAuth mAuth instance
        mAuth = FirebaseAuth.getInstance();


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                changePage(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setPage(int i) {
        switch (i) {
            case 0:
                mViewPager.setCurrentItem(0);
                break;
            case 1:
                mViewPager.setCurrentItem(1);
                break;
            case 2:
                mViewPager.setCurrentItem(2);
                break;
        }
    }

    private void changePage(int position) {

        if (position == 0) {
            profileLabel.setTextColor(getColor(R.color.textColorLight));
            profileLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26);

            allUsersLabel.setTextColor(getColor(R.color.textColorDark));
            allUsersLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

            notificationLabel.setTextColor(getColor(R.color.textColorDark));
            notificationLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        }
        if (position == 1) {
            profileLabel.setTextColor(getColor(R.color.textColorDark));
            profileLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

            allUsersLabel.setTextColor(getColor(R.color.textColorLight));
            allUsersLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26);

            notificationLabel.setTextColor(getColor(R.color.textColorDark));
            notificationLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        }
        if (position == 2) {
            profileLabel.setTextColor(getColor(R.color.textColorDark));
            profileLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

            allUsersLabel.setTextColor(getColor(R.color.textColorDark));
            allUsersLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

            notificationLabel.setTextColor(getColor(R.color.textColorLight));
            notificationLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26);
        }

    }


}
