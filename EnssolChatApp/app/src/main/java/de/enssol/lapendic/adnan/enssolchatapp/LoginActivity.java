package de.enssol.lapendic.adnan.enssolchatapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText mEmail;
    private TextInputEditText mPassword;
    private Button mLoginBtn;
    private Toolbar mToolbar;
    private ProgressDialog mProgressDialog;
    private FirebaseAuth mAuth;
    private DatabaseReference mUserDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize attributes
        mEmail = findViewById(R.id.login_email_text_view);
        mPassword = findViewById(R.id.login_password_text_view);
        mLoginBtn = findViewById(R.id.login_button);

        //Initialize progress dialog
        mProgressDialog = new ProgressDialog(this);

        //Set toolbar
        mToolbar = findViewById(R.id.login_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Firebase
        mAuth = FirebaseAuth.getInstance();

        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)){
                    //setting progress dialog
                    mProgressDialog.setTitle("Logging in");
                    mProgressDialog.setMessage("Please wait while we check your credentials");
                    mProgressDialog.setCanceledOnTouchOutside(false);
                    mProgressDialog.show();

                    //method for login user
                    loginUser(email, password);

                }
            }
        });
    }

    /**
     * This function is used to sign in user who is already registered in db
     * @param email - Registered user email
     * @param password - Registered user password
     */
    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    mProgressDialog.dismiss();

                    String deviceToken = FirebaseInstanceId.getInstance().getToken();
                    String currentUser = mAuth.getCurrentUser().getUid();

                    mUserDatabase.child(currentUser).child("device_token").setValue(deviceToken).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                            //Starting new Activity after successful login
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                            //When user click back it wont be sent to start activity, it will go to OS and put app on stack
                            //App is minimized and user is still sign in
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();

                        }
                    });

                }else{
                    mProgressDialog.hide();
                    Toast.makeText(LoginActivity.this, "Canot Sign in. Please check form and try again.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
