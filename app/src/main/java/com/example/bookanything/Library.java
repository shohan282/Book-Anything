package com.example.bookanything;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookanything.databinding.ActivityLibraryBinding;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library extends AppCompatActivity {

    ActivityLibraryBinding binding;
    String loc,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLibraryBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.date.setOnClickListener(v -> showDateDialog(binding.date));

        binding.button5.setOnClickListener(v -> {

            loc=binding.location.getSelectedItem().toString();
            date=binding.date.getText().toString();

            Intent intent = new Intent(Library.this,HosList.class);
            intent.putExtra("d",date);
            intent.putExtra("l",loc);
            intent.putExtra("type","Library");
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

        DatePickerDialog datePickerDialog = new DatePickerDialog(Library.this,dateSetListener,calendar.get(calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }
}