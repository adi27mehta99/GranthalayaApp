package com.example.granthalaya;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

// private FirebaseAuth.AuthStateListener mAuthListner;

    private static final String TAG = "MainActivity";

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseUser user = firebaseAuth.getCurrentUser();


    private FirebaseAuth mAuth;
    private EditText Username;
    private EditText Password;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //Remove this for Always opening Login Page
        if(user != null)
        {
            finish();
            startActivity(new Intent (MainActivity.this, SecondActivity.class));
        }



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();

        Username = (EditText) findViewById(R.id.LibID);
        Password = (EditText) findViewById(R.id.Pwd);
        Button login = (Button) findViewById(R.id.Login_btn);
        Button logout = (Button) findViewById(R.id.Logout_btn);

        progressDialog = new ProgressDialog(this);


                    //Log.d(TAG, "onAuthStateChanged:signed_in:" + ((FirebaseUser) user).getUid());
                   // Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    //Toast.makeText(getApplicationContext(), "Login successful...Welcome "+user.getEmail(), Toast.LENGTH_SHORT).show();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(Username.getText().toString(), Password.getText().toString());


            }

        });
        /*logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();

                Toast.makeText(getApplicationContext(),"Logout Successful",Toast.LENGTH_SHORT).show();
            }
        });*/

        }


       /**/



    private void Validate(final String userName , final String userPass)
    {
        progressDialog.setMessage("Login in Process..");
        progressDialog.show();



        firebaseAuth.signInWithEmailAndPassword(userName,userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Login Successful, Welcome To The  Granthalaya", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,SecondActivity.class));
                }
                else
                {

                    if(TextUtils.isDigitsOnly(userName))
                    {
                        Username.setError("User Name Cannot be a number and it should not be empty");
                    }
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }







    /*private void Validate(String userName, String userPass) {
        if ((userName.equals("Granthalaya")) && (userPass.equals("Awesome"))) {

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Login successful...Welcome", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(Username.getText().toString()))//displays error if username is wrong
        {
            Username.setError("Username cannot be empty!!");
        }
        else if((!userName.equals("Granthalaya")) && !userPass.equals("Awesome"))//checks Username
        {
            Toast.makeText(getApplicationContext(), "Username is wrong!! Please enter valid Username", Toast.LENGTH_SHORT).show();
        }

        if(TextUtils.isEmpty(Password.getText().toString()))//displays error if password is empty
        {
            Password.setError("Password cannot be empty!!");
        }
       else if((!userPass.equals("Awesome")))//checks Password
        {
            Toast.makeText(getApplicationContext(),"Password is wrong!! Please enter valid Password",Toast.LENGTH_SHORT).show();

        }

    }*/


}