package de.enssol.lapendic.adnan.enssolchatapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.TestLooperManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText mDisplayName;
    private TextInputEditText mEmail;
    private TextInputEditText mPasssword;
    private Button mCreateAccountButton;
    private FirebaseAuth mAuth;
    private Toolbar mToolbar;
    private ProgressDialog mRegProgress;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceToDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //progress bar
        mRegProgress = new ProgressDialog(this);

        //set toolbar
        mToolbar = findViewById(R.id.register_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Firebase
        mAuth = FirebaseAuth.getInstance();

        //Initialize attributes
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

                //Check if fields are empty at register screen
                if (!TextUtils.isEmpty(displayName) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)){
                    mRegProgress.setTitle("Registering user");
                    mRegProgress.setMessage("Please wait while we create your account!");
                    mRegProgress.setCanceledOnTouchOutside(false);
                    mRegProgress.show();
                    registerUser(displayName, email, password); //Calling method to register new user
                }

            }
        });
    }

    /**
     * This method is called when we need to register new user to db
     * @param display_name - Username that other users will see
     * @param email - Your email address
     * @param password - Your password for login
     */
    private void registerUser(final String display_name, String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                    String uid = currentUser.getUid();

                    mDatabase = FirebaseDatabase.getInstance();
                    mReferenceToDatabase = mDatabase.getReference().child("users").child(uid);
                    mRegProgress.dismiss();


//                    mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);

                    HashMap<String, String> userMap = new HashMap<>();
                    userMap.put("name", display_name);
                    userMap.put("status", "Hi there I'm using Enssol Chat App");
                    userMap.put("image", "default");
                    userMap.put("thumb_image", "default");

//                    mDatabase.setValue(userMap);

                    mReferenceToDatabase.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                mRegProgress.dismiss(); //removing progress bar when user successfully registered

                                Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(mainIntent);
                                finish();

                            }
                        }
                    });


                }else{
                    mRegProgress.hide(); //hiding progress bar if user is not registered successfully
                    Toast.makeText(RegisterActivity.this, "Cannot Sign in. Please check form and try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
