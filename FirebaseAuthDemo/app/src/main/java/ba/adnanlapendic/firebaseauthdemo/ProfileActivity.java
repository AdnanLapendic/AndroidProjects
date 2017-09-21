package ba.adnanlapendic.firebaseauthdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private TextView userEmailTextView;
    private Button logoutButton;

    private DatabaseReference databaseReference;

    private EditText fullName;
    private EditText addressEditText;
    private Button saveInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference();

        fullName = (EditText) findViewById(R.id.fullNameEditText);
        addressEditText = (EditText) findViewById(R.id.addressEditText);
        saveInfo = (Button) findViewById(R.id.saveInformationButton);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        userEmailTextView = (TextView) findViewById(R.id.textViewUserEmail);

        userEmailTextView.setText("Welcome " + user.getEmail());

        logoutButton = (Button) findViewById(R.id.buttonLogout);

        logoutButton.setOnClickListener(this);

        saveInfo.setOnClickListener(this);

    }

    private void saveUserInformation(){
        String name = fullName.getText().toString().trim();
        String address = addressEditText.getText().toString().trim();

        UserInformation userInformation = new UserInformation(name, address);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(userInformation);
        Toast.makeText(this, "Information Saved...", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        if(v == logoutButton){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        if(v== saveInfo){
            saveUserInformation();
        }
    }
}
