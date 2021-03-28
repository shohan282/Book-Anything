package com.example.bookanything;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.bookanything.databinding.ActivityHomeBinding;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.firestore.DocumentReference;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class Home extends AppCompatActivity {

    ActivityHomeBinding binding;
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    ArrayList<model> dataList;
    AnyAdapter adapter;
    String t,date,h,s,l,type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {

            Intent intent=new Intent(Home.this,Login.class);
            startActivity(intent);

        } else {

            db=FirebaseFirestore.getInstance();
            binding.recyView.setLayoutManager(new LinearLayoutManager(this));
            dataList = new ArrayList<>();
            adapter = new AnyAdapter(dataList);
            binding.recyView.setAdapter(adapter);

            String uid = mAuth.getCurrentUser().getUid();

            t = getIntent().getStringExtra("time");
            date = getIntent().getStringExtra("date");
            h = getIntent().getStringExtra("hos_name");
            s = getIntent().getStringExtra("special");
            l = getIntent().getStringExtra("location");
            type = getIntent().getStringExtra("type");

            db.collection("users").whereEqualTo("uid",uid).get().addOnSuccessListener(queryDocumentSnapshots -> {

                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                for(DocumentSnapshot d:list) {

                    model obj=d.toObject(model.class);
                    dataList.add(obj);
                }
                adapter.notifyDataSetChanged();
            });

            if(type != null) {

                if(type.contains("Hospital")) {

                    db.collection("Hospital").document(h+date+t+l+s)
                            .delete()
                            .addOnSuccessListener(aVoid -> {

                                //

                            })
                            .addOnFailureListener(e -> Toast.makeText(Home.this, "delete failed", Toast.LENGTH_SHORT).show());

                } else if(type.contains("Movie")) {

                    db.collection("Movie").document(s+date+t+l+h)
                            .delete()
                            .addOnSuccessListener(aVoid -> {

                                //

                            })
                            .addOnFailureListener(e -> Toast.makeText(Home.this, "delete failed", Toast.LENGTH_SHORT).show());

                } else {

                    db.collection(type).document(h+date+t+l)
                            .delete()
                            .addOnSuccessListener(aVoid -> {

                                //

                            })
                            .addOnFailureListener(e -> Toast.makeText(Home.this, "delete failed", Toast.LENGTH_SHORT).show());

                }

            }


        }

        binding.fab.setOnClickListener(v -> {

            Intent intent=new Intent(Home.this,MainActivity.class);
            startActivity(intent);

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.logout:

                mAuth.signOut();

                Intent intent=new Intent(Home.this,Login.class);
                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}