package ba.example.lapa.eatit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import ba.example.lapa.eatit.Model.User;

public class SignIn extends AppCompatActivity {

    EditText editPhone;
    EditText editPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editPhone = (MaterialEditText) findViewById(R.id.editPhone);
        editPassword = (MaterialEditText) findViewById(R.id.editPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);


        //Init Firebase

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog dialog = new ProgressDialog(SignIn.this);
                dialog.setMessage("Please waite...");
                dialog.show();

                table_user.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //Check if user exist in database
                        if(dataSnapshot.child(editPhone.getText().toString()).exists()) {
                            Log.d("++++++++++++++++++++", dataSnapshot.child(editPhone.getText().toString())+"");
                            //Get User information
                            dialog.dismiss();

                            User user = dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);
//                            Log.d("USER", user.getName());
//                            Log.d("USER", user.getPassword());
                            if (user.getPassword().equals(editPassword.getText().toString())) {
                                Toast.makeText(SignIn.this, "Sign in successfully!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignIn.this, "Sign in failed!!!", Toast.LENGTH_SHORT).show();

                            }
                        }else {
                            dialog.dismiss();
                            Toast.makeText(SignIn.this,"User not exist in Database", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

        });




    }
}
