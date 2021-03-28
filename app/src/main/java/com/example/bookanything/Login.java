package com.example.bookanything;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.bookanything.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    FirebaseAuth mAuth;
    ActivityLoginBinding binding;
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mAuth = FirebaseAuth.getInstance();

        binding.button2.setOnClickListener(v -> {

            email = binding.editTextTextEmailAddress.getText().toString();
            password = binding.editTextTextPassword.getText().toString();

            if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {

                                Intent intent=new Intent(Login.this,Home.class);
                                startActivity(intent);

                            } else {

                                Toast.makeText(Login.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }


                        });

            }



        });

        binding.button3.setOnClickListener(v -> {

            Intent intent = new Intent(Login.this,SignUp.class);
            startActivity(intent);

        });

    }
}