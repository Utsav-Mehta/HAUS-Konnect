package com.example.hauskonnect;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Objects;

/**
 * The type Welcome page.
 */
public class welcomePage extends AppCompatActivity {
    /**
     * The Previous btn.
     */
    Button previousBtn, /**
     * The Cont btn.
     */
    contBtn;
    /**
     * The Fbase auth.
     */
    FirebaseAuth fbaseAuth;
    /**
     * The User id.
     */
    String userId;
    /**
     * The Fstore.
     */
    FirebaseFirestore fstore;
    /**
     * The Pbar 3.
     */
    ProgressBar pbar3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        previousBtn=findViewById(R.id.prevBtn);
        contBtn=findViewById(R.id.contBtn);
        pbar3 =findViewById(R.id.progressBar3);


        fstore=FirebaseFirestore.getInstance();
        fbaseAuth=FirebaseAuth.getInstance();

        userId= Objects.requireNonNull(fbaseAuth.getCurrentUser()).getUid();
        DocumentReference dr=fstore.collection("users").document(userId);

        dr.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                assert documentSnapshot != null;
                String type=documentSnapshot.getString("type");
                String faculty = "faculty";
                String Student="Student";

                contBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        assert type != null;
                        if(type.equals(faculty)){
                            startActivity(new Intent(getApplicationContext(), FacultySide.class));
                            pbar3.setVisibility(View.VISIBLE);
                        }
                        else if (type.equals(Student)){
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            pbar3.setVisibility(View.VISIBLE);
                        }

                    }
                });
                previousBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), Login.class));
                    }
                });

            }
        });
    }
}