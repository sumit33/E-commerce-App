package com.example.firstapp;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity{

    Button mLogin;
    TextView mReg;
    EditText mUser, mPass;
    Intent in2;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private FirebaseUser user;
    private String userName, userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUser = findViewById(R.id.userEmail);
        mPass = findViewById(R.id.password);
        mReg = findViewById(R.id.signUpText);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        user = firebaseAuth.getCurrentUser();

        if(user != null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        mLogin = findViewById(R.id.login);
        mLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validate()){
                    progressDialog.setMessage("Logging In...");
                    progressDialog.show();

                    firebaseAuth.signInWithEmailAndPassword(userName, userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                progressDialog.dismiss();
                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            }
                            else {
                                progressDialog.dismiss();
                                Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        mReg = findViewById(R.id.signUpText);
        mReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }
    public boolean validate(){
        boolean result = false;

        userName = mUser.getText().toString();
        userPass = mPass.getText().toString();

        if(userName.isEmpty() || userPass.isEmpty()){
            Toast.makeText(this,"Please enter all the details", Toast.LENGTH_SHORT).show();
        }else if (userPass.length()<6) {
            Toast.makeText(this, "Password should be 6 characters or more", Toast.LENGTH_SHORT).show();
        }
        else {
            result = true;
        }
        return result;
    }
}
