package de.enssol.lapendic.adnan.enssolchatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UsersActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mUsersList;
    private DatabaseReference mUsersDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        mToolbar = findViewById(R.id.users_app_barr);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("All Users");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Reference to the users in database
        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        mUsersList = findViewById(R.id.users_list_view);
        mUsersList.setHasFixedSize(true);
        mUsersList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();

        //initialize Firebase Recycle Adapter
        FirebaseRecyclerAdapter<Users, UsersViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Users, UsersViewHolder>(
                Users.class,
                R.layout.single_list_user_layout,
                UsersViewHolder.class,
                mUsersDatabase

        ) {
            @Override
            protected void populateViewHolder(UsersViewHolder usersViewHolder, Users user, int position) {
                //populating viewHolder with user data
                usersViewHolder.setUserName(user.getName());
                usersViewHolder.setUserStatus(user.getStatus());
                usersViewHolder.setUserImage(user.getImage(), getApplicationContext());

                final String user_id = getRef(position).getKey();


                //the user profile will open after clicking on user in list
                usersViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(UsersActivity.this, ProfileActivity.class);
                        intent.putExtra("userId", user_id);
                        startActivity(intent);
                    }
                });

            }
        };

        mUsersList.setAdapter(firebaseRecyclerAdapter);

    }


}
