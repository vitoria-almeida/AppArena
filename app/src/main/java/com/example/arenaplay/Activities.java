package com.example.arenaplay;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;

public class Activities {
    public static void openSignUpActivity(Context context) {
        Intent intent = new Intent(context, SignUp.class);
        context.startActivity(intent);
    }

    public static void openHomeActivity(Context context) {
        Intent intent = new Intent(context, Home.class);
        context.startActivity(intent);
    }

    public static void openLoginActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void openMyBookingsActivity(Context context) {
        Intent intent = new Intent(context, MyBookings.class);
        context.startActivity(intent);
    }

    public static void openProfileActivity(Context context) {
        Intent intent = new Intent(context, Profile.class);
        context.startActivity(intent);
    }

    public static void openBookCourtActivity(Context context) {
        Intent intent = new Intent(context, BookCourt.class);
        context.startActivity(intent);
    }
}
