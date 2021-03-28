package com.example.bookanything;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bookanything.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        db = FirebaseFirestore.getInstance();

        binding.hospital.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,Hospital.class);
            startActivity(intent);

        });

        binding.library.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,Library.class);
            startActivity(intent);

        });

        binding.movie.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,Movie.class);
            startActivity(intent);

        });

        binding.barbar.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,Barbar.class);
            startActivity(intent);

        });

    }
}