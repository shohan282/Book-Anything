package com.example.bookanything;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bookanything.databinding.ActivityHosConfirmBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HosConfirm extends AppCompatActivity {

    ActivityHosConfirmBinding binding;
    String t,d,h,s,l,type,uid,uName;
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHosConfirmBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mAuth = FirebaseAuth.getInstance();
        uid=mAuth.getCurrentUser().getUid();
        db = FirebaseFirestore.getInstance();

        t = getIntent().getStringExtra("time");
        d = getIntent().getStringExtra("date");
        h = getIntent().getStringExtra("hos_name");
        s = getIntent().getStringExtra("special");
        l = getIntent().getStringExtra("location");
        type = getIntent().getStringExtra("type");

        if(type.equals("Hospital")) {

            binding.dateConfirm.setText("Date: "+d);
            binding.hosConfirm.setText(h);
            binding.locationConfirm.setText("Location: "+l);
            binding.specialConfirm.setText("Speciality: "+s);
            binding.timeConfirm.setText("Time: "+t);
            binding.specialConfirm.setVisibility(View.VISIBLE);

        } else if(type.equals("Movie")) {

            binding.dateConfirm.setText("Date: "+d);
            binding.hosConfirm.setText(h);
            binding.locationConfirm.setText("Location: "+l);
            binding.specialConfirm.setText("Show: "+s);
            binding.timeConfirm.setText("Time: "+t);
            binding.specialConfirm.setVisibility(View.VISIBLE);

        } else {

            binding.dateConfirm.setText("Date: "+d);
            binding.hosConfirm.setText(h);
            binding.locationConfirm.setText("Location: "+l);
            binding.timeConfirm.setText("Time: "+t);

        }

        binding.map.setOnClickListener(v -> {

            if(h.contains("Square Hospital,Dhaka")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.7513174,90.3766758?q=" + Uri.encode("Square Hospital")));
                startActivity(intent);

            } else if(h.contains("Apollo Hospital,Dhaka")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.819149,90.4504067?q=" + Uri.encode("Apollo Hospital")));
                startActivity(intent);

            } else if(h.contains("Labaid Hospital,Dhaka")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.7475842,90.3784348?q=" + Uri.encode("Labaid Hospital")));
                startActivity(intent);

            } else if(h.contains("Ibn Sina Hospital,Dhaka")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.7460098,90.3699183?q=" + Uri.encode("Ibn Sina Hospital")));
                startActivity(intent);

            } else if(h.contains("Popular Hospital,Dhaka")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.7883609,90.4229327?q=" + Uri.encode("Popular Hospital")));
                startActivity(intent);

            } else if(h.contains("Birdem Hospital,Shahbag")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.7388487,90.3942934?q=" + Uri.encode("Birdem Hospital")));
                startActivity(intent);

            } else if(h.contains("BSMMU Hospital,Dhaka")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.7398269,90.392488?q=" + Uri.encode("BSMMU Hospital")));
                startActivity(intent);

            } else if(h.contains("Bangladesh Eye Hospital,Dhaka")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.75411,90.3588232?q=" + Uri.encode("Bangladesh Eye Hospital")));
                startActivity(intent);

            } else if(h.contains("Bashundhara Hospital,Manikganj")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.8578701,89.9997186?q=" + Uri.encode("Bashundhara Hospital")));
                startActivity(intent);

            } else if(h.contains("Dhaka Medical College,Dhaka")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.7260602,90.3953405?q=" + Uri.encode("Dhaka Medical College")));
                startActivity(intent);

            } else if(h.contains("CMH Hospital,Dhaka Cantonment")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.8237221,90.3985346?q=" + Uri.encode("CMH Hospital")));
                startActivity(intent);

            } else if(h.contains("Ad-din Sakina Hospital,Jessore")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.1634693,89.210614?q=" + Uri.encode("Ad-din Sakina Medical College Hospital")));
                startActivity(intent);

            } else if(h.contains("Ad-din Akij Hospital,Khulna")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:22.8409386,89.5300009?q=" + Uri.encode("Ad-din Akij Medical College Hospital")));
                startActivity(intent);

            } else if(h.contains("Al Haramain Hospital,Sylhet")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:24.8889184,91.8775358?q=" + Uri.encode("Al Haramain Hospital")));
                startActivity(intent);

            } else if(h.contains("Bangabandhu Memorial Hospital,Chittagong")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:22.3612974,91.7953124?q=" + Uri.encode("Bangabandhu Memorial Hospital")));
                startActivity(intent);

            } else if(h.contains("Catharsis Medical Centre,Gazipur")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.910636,90.4181629?q=" + Uri.encode("Catharsis Medical Centre")));
                startActivity(intent);

            } else if(h.contains("Sufia Kamal Library,Dhaka")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.7364439,90.3926536?q=" + Uri.encode("Sufia Kamal Library")));
                startActivity(intent);

            } else if(h.contains("Central Library,Gazipur")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.9985551,90.4219235?q=" + Uri.encode("Central Library")));
                startActivity(intent);

            } else if(h.contains("Central Library,Sylhet")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:24.8985991,91.8624662?q=" + Uri.encode("Central Library")));
                startActivity(intent);

            } else if(h.contains("Anirban Library,Khulna")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:22.8172994,89.5609672?q=" + Uri.encode("Anirban Library")));
                startActivity(intent);

            } else if(h.contains("Manirampur Library,Jessore")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.0233073,89.2303294?q=" + Uri.encode("Manirampur Library")));
                startActivity(intent);

            } else if(h.contains("Chittagong University Library,Chittagong")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:22.4815372,91.7982951?q=" + Uri.encode("Chittagong University Library")));
                startActivity(intent);

            } else if(h.contains("Star Cineplex,Bashundhara")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.750726,90.3895336?q=" + Uri.encode("Star Cineplex")));
                startActivity(intent);

            } else if(h.contains("Jumur Chinema Hall,Gazipur")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.9948868,90.3476267?q=" + Uri.encode("Jumur Chinema Hall")));
                startActivity(intent);

            } else if(h.contains("BGB Auditorium,Sylhet")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:24.9099811,91.8386788?q=" + Uri.encode("BGB Auditorium")));
                startActivity(intent);

            } else if(h.contains("Liberty Cineplex,Khulna")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:22.8622453,89.5331025?q=" + Uri.encode("Liberty Cineplex")));
                startActivity(intent);

            } else if(h.contains("Silver Screen,Chittagong")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:22.3263656,91.7498277?q=" + Uri.encode("Silver Screen")));
                startActivity(intent);

            } else if(h.contains("Monihar Movie Theater,Jessore")) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.1612654,89.2209846?q=" + Uri.encode("Monihar Movie Theater")));
                startActivity(intent);

            }

        });

        db.collection("userProfile").whereEqualTo("uid",uid).get().addOnSuccessListener(queryDocumentSnapshots -> {

            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
            for(DocumentSnapshot d:list) {

                model obj=d.toObject(model.class);
                uName = obj.getuName();

            }

        });

        binding.button6.setOnClickListener(v -> {

            Map<String, String> user = new HashMap<>();
            user.put("name", h);
            user.put("date", d);
            user.put("time", t);
            user.put("location",l);
            user.put("special",s);
            user.put("uid",uid);
            user.put("uName",uName);
            user.put("type",type);

            db.collection("users")
                    .add(user)
                    .addOnSuccessListener(documentReference -> {

                        Intent intent=new Intent(HosConfirm.this,Home.class);
                        intent.putExtra("time",t);
                        intent.putExtra("date",d);
                        intent.putExtra("hos_name",h);
                        intent.putExtra("special",s);
                        intent.putExtra("location",l);
                        intent.putExtra("type",type);
                        startActivity(intent);

                    })
                    .addOnFailureListener(e -> Toast.makeText(HosConfirm.this, "error", Toast.LENGTH_SHORT).show());

        });

    }
}