package com.example.bookanything;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bookanything.databinding.ActivityHosListBinding;
import com.example.bookanything.databinding.ActivityHospitalBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class HosList extends AppCompatActivity {

    ActivityHosListBinding binding;
    FirebaseFirestore db;
    ArrayList<HosModel> hosDataList;
    HosAdapter hosAdapter;
    String special,date,location,type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHosListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        db=FirebaseFirestore.getInstance();
        binding.hrview.setLayoutManager(new LinearLayoutManager(this));
        hosDataList = new ArrayList<>();
        hosAdapter = new HosAdapter(hosDataList,this);
        binding.hrview.setAdapter(hosAdapter);

        special = getIntent().getStringExtra("s");
        date = getIntent().getStringExtra("d");
        location = getIntent().getStringExtra("l");
        type = getIntent().getStringExtra("type");

        if(type == "Hospital") {

            db.collection("Hospital").whereEqualTo("location",location).whereEqualTo("date",date).whereEqualTo("special",special).get().addOnSuccessListener(queryDocumentSnapshots -> {

                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                for(DocumentSnapshot d:list) {

                    HosModel obj=d.toObject(HosModel.class);
                    hosDataList.add(obj);
                }
                hosAdapter.notifyDataSetChanged();
            });

        }  else if(type.contains("Movie")) {

            db.collection("Movie").whereEqualTo("location",location).whereEqualTo("date",date).whereEqualTo("special",special).get().addOnSuccessListener(queryDocumentSnapshots -> {

                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                for(DocumentSnapshot d:list) {

                    HosModel obj=d.toObject(HosModel.class);
                    hosDataList.add(obj);
                }
                hosAdapter.notifyDataSetChanged();
            });

        } else {

            db.collection(type).whereEqualTo("location",location).whereEqualTo("date",date).get().addOnSuccessListener(queryDocumentSnapshots -> {

                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                for(DocumentSnapshot d:list) {

                    HosModel obj=d.toObject(HosModel.class);
                    hosDataList.add(obj);
                }
                hosAdapter.notifyDataSetChanged();
            });

        }



    }
}