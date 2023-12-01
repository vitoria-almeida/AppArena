package com.example.arenaplay;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView bookCourt = (ImageView) findViewById(R.id.bookCourt);

        ImageView home = (ImageView) findViewById(R.id.home);
        ImageView bookings = (ImageView) findViewById(R.id.bookings);
        ImageView profile = (ImageView) findViewById(R.id.profile);

        home.setOnClickListener(v -> Activities.openHomeActivity(Home.this));
        bookings.setOnClickListener(v -> Activities.openMyBookingsActivity(Home.this));
        profile.setOnClickListener(v -> Activities.openProfileActivity(Home.this));

        bookCourt.setOnClickListener(V -> Activities.openBookCourtActivity(Home.this));

    }
}
