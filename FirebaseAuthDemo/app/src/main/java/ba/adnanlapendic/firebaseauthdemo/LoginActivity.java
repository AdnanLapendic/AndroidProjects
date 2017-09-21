package ba.adnanlapendic.firebaseauthdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button signInButton;
    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView signUpTextView;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInButton = (Button) findViewById(R.id.signInButton);
        emailEditText = (EditText) findViewById(R.id.emailText);
        passwordEditText = (EditText)findViewById(R.id.passwordText);
        signUpTextView = (TextView) findViewById(R.id.loginTextView);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){

            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));


        }

        signInButton.setOnClickListener(this);
        signUpTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == signInButton){
            userLogin();
        }

        if(v == signUpTextView){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    private void userLogin(){

        String mail = emailEditText.getText().toString().trim();
        String pass = passwordEditText.getText().toString().trim();


        if(TextUtils.isEmpty(mail)){
            Toast.makeText(this, "PleaseEnter email", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(mail, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        }
                    }
                });
    }
}
