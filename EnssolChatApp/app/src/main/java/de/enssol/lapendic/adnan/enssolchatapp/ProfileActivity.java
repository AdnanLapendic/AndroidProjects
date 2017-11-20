package de.enssol.lapendic.adnan.enssolchatapp;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    private ImageView mProfileImage;
    private TextView mProfileName;
    private TextView mProfileStatus;
    private TextView mNumberOfFriends;
    private Button mSendFriendRequestBtn;
    private Button mDeclineFriendRequesrButton;
    private DatabaseReference mUsersDatabase;
    private ProgressDialog mProgressDialog;
    private int mCurrentFriendshipState;
    private DatabaseReference mFriendsRequestDatabase;
    private FirebaseUser mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final String userId = getIntent().getStringExtra("userId");

        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(userId);
        mFriendsRequestDatabase = FirebaseDatabase.getInstance().getReference().child("friend_request");
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();

        mProfileImage = findViewById(R.id.profile_image_view);
        mProfileName = findViewById(R.id.profile_display_name_view);
        mProfileStatus = findViewById(R.id.profile_display_status_view);
        mNumberOfFriends = findViewById(R.id.profile_display_friends_number);
        mSendFriendRequestBtn = findViewById(R.id.send_friend_request_button);
        mDeclineFriendRequesrButton = findViewById(R.id.decline_friend_request_button);

        mCurrentFriendshipState = 0;

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Loading User Data");
        mProgressDialog.setMessage("Please wait while we load the user data.");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();

        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String displayName = dataSnapshot.child("name").getValue().toString();
                String displayStatus = dataSnapshot.child("status").getValue().toString();
                String displayImage = dataSnapshot.child("image").getValue().toString();

                mProfileName.setText(displayName);
                mProfileStatus.setText(displayStatus);

                Picasso.with(ProfileActivity.this).load(displayImage).placeholder(R.drawable.adnan).into(mProfileImage);

                //----------------------FRIENDS LIST REQUEST FEATURE-------------------------------
                mFriendsRequestDatabase.child(mCurrentUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChild(userId)){
                            int requestType = dataSnapshot.child(userId).child("request_type").getValue(Integer.class);

                            if(requestType == 1) {
                                mCurrentFriendshipState = 1;
                                mSendFriendRequestBtn.setText("Accept Friend Request");
                            } else if (requestType == 0){
                                mSendFriendRequestBtn.setText("Cancel Friend Request");
                            }
                        }

                        mProgressDialog.dismiss();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mSendFriendRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSendFriendRequestBtn.setEnabled(false);

                //------------------------------NOT FRIENDS STATE-----------------------------

                if (mCurrentFriendshipState == 0){

                    mFriendsRequestDatabase.child(mCurrentUser.getUid()).child(userId).child("request_type").setValue(1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                mFriendsRequestDatabase.child(userId).child(mCurrentUser.getUid()).child("request_type").setValue(2).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        mSendFriendRequestBtn.setEnabled(true);
                                        mCurrentFriendshipState = 1;
                                        mSendFriendRequestBtn.setText("Cancel Friend Request");
                                        Toast.makeText(ProfileActivity.this, "Request Successfully Sent.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else {
                                Toast.makeText(ProfileActivity.this, "Failed Sending Request.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

                //----------------------------CANCEL REQUEST STATE--------------------------------

                if (mCurrentFriendshipState == 1){
                    mFriendsRequestDatabase.child(mCurrentUser.getUid()).child(userId).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            mFriendsRequestDatabase.child(userId).child(mCurrentUser.getUid()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    mSendFriendRequestBtn.setEnabled(true);
                                    mCurrentFriendshipState = 0;
                                    mSendFriendRequestBtn.setText("Send Friend  Request");

                                }
                            });
                        }
                    });
                }
            }
        });
    }
}
