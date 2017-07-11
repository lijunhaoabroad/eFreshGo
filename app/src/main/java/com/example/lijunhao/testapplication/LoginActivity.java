package com.example.lijunhao.testapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;



import java.util.ArrayList;
import java.util.List;



import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {




    private FirebaseAuth mAuth;



    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mAuth = FirebaseAuth.getInstance();
        mPasswordView = (EditText) findViewById(R.id.password);


        //Check if User is Already LoggedIn
        if(mAuth.getCurrentUser() != null)
        {
//User NOT logged In
            finish();
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
        }


        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String getemail = mEmailView.getText().toString().trim();
                String getepassword = mPasswordView.getText().toString().trim();
                callSignIn(getemail,getepassword);

            }
        });

    }


    //Now start Sign In Process
//SignIn Process
    private void callSignIn(String email,String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("TESTING", "sign In Successful:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Log.w("TESTING", "signInWithEmail:failed", task.getException());
                            Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
                            finish();
                            startActivity(i);
                        }
                    }
                });

    }

}

