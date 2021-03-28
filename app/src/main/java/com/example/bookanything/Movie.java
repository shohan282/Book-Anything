package com.example.bookanything;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookanything.databinding.ActivityMovieBinding;
import com.example.bookanything.databinding.ActivityMovieBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Movie extends AppCompatActivity {

    ActivityMovieBinding binding;
    String mov,date,location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.date.setOnClickListener(v -> showDateDialog(binding.date));

        binding.button5.setOnClickListener(v -> {

            mov=binding.movie.getSelectedItem().toString();
            date=binding.date.getText().toString();
            location=binding.location.getSelectedItem().toString();

            Intent intent = new Intent(Movie.this,HosList.class);
            intent.putExtra("s",mov);
            intent.putExtra("d",date);
            intent.putExtra("l",location);
            intent.putExtra("type","Movie");
            startActivity(intent);

        });
        
    }

    private void showDateDialog(TextView date) {

        Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener= (view, year, month, dayOfMonth) -> {
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,month);
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yy");
            date.setText(simpleDateFormat.format(calendar.getTime()));

        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(Movie.this,dateSetListener,calendar.get(calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

}