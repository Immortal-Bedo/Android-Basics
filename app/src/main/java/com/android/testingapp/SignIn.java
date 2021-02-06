package com.android.testingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignIn extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText signupEmail,signupPassword;
    Button signupButton;
    TextView gotoLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();
        signupEmail = findViewById(R.id.usernameSignup);
        signupPassword = findViewById(R.id.passwordSignup);
        signupButton = findViewById(R.id.buttonSignup);
        gotoLogin = findViewById(R.id.gotoLogin);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this,Login.class));
            }
        });

    }

    private void createUser() {
        String email = signupEmail.getText().toString();
        String pass = signupPassword.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if(!pass.isEmpty()){
                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignIn.this,"regestered",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignIn.this,Login.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignIn.this,"not regestrerd",Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                signupPassword.setError("Empty Fields are not allowed ");
            }
        }else if(email.isEmpty()){
            signupEmail.setError("Empty Fields are not allwed");
        }else{
            signupEmail.setError("please enter email ");
        }

    }


}