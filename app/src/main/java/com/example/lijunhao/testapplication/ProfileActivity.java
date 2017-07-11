package com.example.lijunhao.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private TextView emailName;
     Button signOut;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        emailName = (TextView) findViewById(R.id.textView);
        signOut = (Button) findViewById(R.id.btnSignOut);

        mAuth = FirebaseAuth.getInstance(); // important Call


//Again check if the user is Already Logged in or Not
        if (mAuth.getCurrentUser() == null) {
//User NOT logged In
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

//Fetch the Display name of current User
        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            emailName.setText("Welcome, " + user.getEmail());
        }

        signOut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mAuth.signOut();
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    });
}

    }


