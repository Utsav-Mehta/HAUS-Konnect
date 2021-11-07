package com.example.hauskonnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * The type Login.
 */
public class Login extends AppCompatActivity {
    /**
     * The Mail.
     */
    EditText mail, /**
     * The Passcode.
     */
    passcode;
    /**
     * The Login btn.
     */
    Button loginBtn;
    /**
     * The Register txt.
     */
    TextView registerTxt;
    /**
     * The Firebase auth.
     */
    FirebaseAuth firebaseAuth;
    /**
     * The Fstore.
     */
    FirebaseFirestore fstore;
    /**
     * The Pbar 2.
     */
    ProgressBar pbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth=FirebaseAuth.getInstance();
        mail=findViewById(R.id.logInMailID);
        passcode=findViewById(R.id.userpassword);
        registerTxt=findViewById(R.id.registertxt);
        loginBtn=findViewById(R.id.logInBtn);
        pbar2=findViewById(R.id.progressBar2);

        registerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String LogMailID=mail.getText().toString();
                String passCode=passcode.getText().toString();

                if(TextUtils.isEmpty(LogMailID)){
                    mail.setError("Email ID is required");
                    return;
                }

                if(TextUtils.isEmpty(passCode)){
                    passcode.setError("Password is required");
                    return;
                }

                if(passCode.length()<6){
                    passcode.setError("Password should contain minimum 6 characters");
                    return;
                }

                if(!LogMailID.contains("sot.pdpu.ac.in")){
                    mail.setError("Login with PDPU mail ID");
                }

                pbar2.setVisibility(View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(LogMailID,passCode).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task) {
                        if(task.isSuccessful()){

                                Toast.makeText(Login.this, "Welcome to HAUS-Konnect", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),welcomePage.class));


                        }
                        else{
                            Toast.makeText(Login.this, ""+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });



    }
}