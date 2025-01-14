package com.example.singbike;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.singbike.Adapters.SlidePagerAdapter;

public class IntroActivity extends AppCompatActivity {

    private static final int numPages = 3;
    private ViewPager2 viewPager;


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        final ImageView indicator1 = findViewById (R.id.slideIndicator1);
        final ImageView indicator2 = findViewById (R.id.slideIndicator2);
        final ImageView indicator3 = findViewById (R.id.slideIndicator3);
        final Button rideButton = findViewById (R.id.rideButtonIntro);

        viewPager = findViewById(R.id.introViewPager);
        /* The pager adapter which provide the pages to view */
        SlidePagerAdapter pagerAdapter = new SlidePagerAdapter(this, numPages);
        viewPager.setAdapter(pagerAdapter);

        viewPager.registerOnPageChangeCallback(
                new ViewPager2.OnPageChangeCallback() {

                    @Override
                    public void onPageSelected (int position) {
                        /* new page is selected */
                        switch (position) {
                            case 0:
                                indicator1.setImageResource(R.drawable.active_dot);
                                indicator2.setImageResource(R.drawable.inactive_dot);
                                indicator3.setImageResource(R.drawable.inactive_dot);
                                break;
                            case 1:
                                indicator1.setImageResource(R.drawable.inactive_dot);
                                indicator2.setImageResource(R.drawable.active_dot);
                                indicator3.setImageResource(R.drawable.inactive_dot);
                                break;
                            case 2:
                                indicator1.setImageResource(R.drawable.inactive_dot);
                                indicator2.setImageResource(R.drawable.inactive_dot);
                                indicator3.setImageResource(R.drawable.active_dot);
                                break;
                        }
                    }
                }
        );

        /* slide animations */
//        viewPager.setPageTransformer(new ZoomO);

        rideButton.setOnClickListener (
                new View.OnClickListener() {
                    @Override
                    public void onClick (View v) {
                        Intent intent = new Intent(getApplicationContext(), AuthActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }


    @Override
    public void onBackPressed () {
        if (viewPager.getCurrentItem() == 0) {
            // If user is currently at the first page,
            // let the system handle the back button pressed.
            // This is same as calling finish() in Activity
            super.onBackPressed();
        }
        else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}
