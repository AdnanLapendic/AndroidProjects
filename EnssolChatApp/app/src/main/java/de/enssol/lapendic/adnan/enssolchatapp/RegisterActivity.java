package de.enssol.lapendic.adnan.enssolchatapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private TextView mDisplayName;
    private TextView mEmail;
    private TextView mPasssword;
    private Button mCreateAccountButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        mDisplayName = findViewById(R.id.username_text_view);
        mEmail = findViewById(R.id.email_text_view);
        mPasssword = findViewById(R.id.password_text_view);

        mCreateAccountButton = findViewById(R.id.button_register_create_acc);
        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String displayName = mDisplayName.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPasssword.getText().toString();

                Log.i("++++++++++++++++++++++", displayName);
                Log.i("++++++++++++++++++++++", email);
                Log.i("++++++++++++++++++++++", password);
                registerUser(displayName, email, password);
            }
        });
    }

    private void registerUser(String display_name, String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }else{
                    Toast.makeText(RegisterActivity.this, "You got some error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
