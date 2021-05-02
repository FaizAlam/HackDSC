package com.example.hackdsc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity {

    Button login_btn, CallSignUp;
    TextInputLayout login_email, login_password;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        login_email = findViewById(R.id.email);
        login_password = findViewById(R.id.password);
        login_btn = findViewById(R.id.login);
        CallSignUp = findViewById(R.id.SignUp_Screen);

        firebaseAuth = FirebaseAuth.getInstance();

        CallSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));

            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = login_email.getEditText().getText().toString().trim();
                String password = login_password.getEditText().getText().toString().trim();

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Login.this, "Please enter valid E-mail", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(Login.this, "Password too short", Toast.LENGTH_SHORT).show();
                }



                firebaseAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                    if(user.isEmailVerified()){
                                        // redirect to dashboard

                                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), dashboard.class));
                                    }
                                    else{
                                        user.sendEmailVerification();
                                        Toast.makeText(Login.this, "Check your email to verify your account!",Toast.LENGTH_LONG).show();
                                    }

                                }
                                else {

                                    Toast.makeText(Login.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });

    }

}