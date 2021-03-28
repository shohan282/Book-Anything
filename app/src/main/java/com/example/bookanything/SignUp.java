package com.example.bookanything;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.bookanything.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    FirebaseAuth mAuth;
    ActivitySignUpBinding binding;
    String email,password,name,uid;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        binding.button4.setOnClickListener(v -> {

            email = binding.editTextTextEmailAddress.getText().toString();
            password = binding.editTextTextPassword.getText().toString();
            name = binding.editTextTextPersonName.getText().toString();

            if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {

                                uid=mAuth.getCurrentUser().getUid();

                                Map<String, String> user = new HashMap<>();
                                user.put("uName", name);
                                user.put("uid", uid);

                                db.collection("userProfile").document(uid)
                                        .set(user)
                                        .addOnSuccessListener(aVoid -> {
                                        })
                                        .addOnFailureListener(e -> Toast.makeText(SignUp.this, "name error", Toast.LENGTH_SHORT).show());

                                Intent intent=new Intent(SignUp.this,Login.class);
                                startActivity(intent);

                            } else {

                                Toast.makeText(SignUp.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                            }


                        });

            }

        });



    }
}