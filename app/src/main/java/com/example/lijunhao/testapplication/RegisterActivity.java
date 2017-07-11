package com.example.lijunhao.testapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email, password;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = (EditText) findViewById(R.id.email1);
        password = (EditText) findViewById(R.id.password1);
        signup = (Button) findViewById(R.id.email_register_button);
        mAuth = FirebaseAuth.getInstance();

        //Check if User is Already LoggedIn
//        if (mAuth.getCurrentUser() != null) {
////User NOT logged In
//            finish();
//            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
//        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getemail = email.getText().toString().trim();
                String getepassword = password.getText().toString().trim();
                callsignup(getemail, getepassword);

            }
        });

    }

    private void callsignup(String email,String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        FirebaseAuthException e = (FirebaseAuthException)task.getException();
                        Log.e("RegisterActivity", "Failed Registration", e);
                        Log.d("TESTING", "Sign up Successful" + task.isSuccessful());

// If sign in fails, display a message to the user. If sign in succeeds
// the auth state listener will be notified and logic to handle the
// signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Signed up Failed", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                           //userProfile();
                            Toast.makeText(RegisterActivity.this, "Created Account successfully", Toast.LENGTH_LONG).show();
                            Log.d("TESTING", "Created Account");
                        }
                    }
                });
    }

       }









