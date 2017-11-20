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

import java.text.DateFormat;
import java.util.Date;

public class ProfileActivity extends AppCompatActivity {

    private ImageView mProfileImage;
    private TextView mProfileName;
    private TextView mProfileStatus;
    private TextView mNumberOfFriends;
    private Button mSendFriendRequestBtn;
    private Button mDeclineFriendRequesrButton;
    private DatabaseReference mUsersDatabase;
    private ProgressDialog mProgressDialog;
    private String mCurrentFriendshipState;
    private DatabaseReference mFriendsRequestDatabase;
    private FirebaseUser mCurrentUser;
    private DatabaseReference mFriendDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final String userId = getIntent().getStringExtra("userId");

        //reference to users table in database
        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(userId);
        //reference to friend_request table in database
        mFriendsRequestDatabase = FirebaseDatabase.getInstance().getReference().child("friend_request");
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        //reference to friends table in database
        mFriendDatabase = FirebaseDatabase.getInstance().getReference().child("friends");

        mProfileImage = findViewById(R.id.profile_image_view);
        mProfileName = findViewById(R.id.profile_display_name_view);
        mProfileStatus = findViewById(R.id.profile_display_status_view);
        mNumberOfFriends = findViewById(R.id.profile_display_friends_number);
        mSendFriendRequestBtn = findViewById(R.id.send_friend_request_button);
        mDeclineFriendRequesrButton = findViewById(R.id.decline_friend_request_button);

        mCurrentFriendshipState = "not_friends";

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

                        //checking if user has sent or receive friend request
                        if (dataSnapshot.hasChild(userId)){
                            String requestType = dataSnapshot.child(userId).child("request_type").getValue().toString();

                            //received friend request
                            if(requestType.equals("received")) {
                                //updating friendship state variable and changing button to Accept Friend Request
                                mCurrentFriendshipState ="request_received";
                                mSendFriendRequestBtn.setText("Accept Friend Request");

                                //sent friend request
                            } else if (requestType.equals("sent")){
                                //updating friendship state variable and changing button to Cancel Friend Request
                                mCurrentFriendshipState = "request_sent";
                                mSendFriendRequestBtn.setText("Cancel Friend Request");
                            }

                            mProgressDialog.dismiss();

                        } else {


                            mFriendDatabase.child(mCurrentUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.hasChild(userId)){
                                        mCurrentFriendshipState = "friends";
                                        mSendFriendRequestBtn.setText("Unfriend this person");
                                    }

                                    mProgressDialog.dismiss();

                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                    mProgressDialog.dismiss();


                                }
                            });
                        }

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

        //click on SEND FRIEND REQUEST button
        mSendFriendRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //disabling send request button after clicking
                mSendFriendRequestBtn.setEnabled(false);

                //------------------------------NOT FRIENDS STATE-----------------------------

                if (mCurrentFriendshipState.equals("not_friends")){

                    //sending friend request and updating request type in database
                    mFriendsRequestDatabase.child(mCurrentUser.getUid()).child(userId).child("request_type").setValue("sent").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                //after sending request enabling button and change it to Cancel Friend Request
                                mFriendsRequestDatabase.child(userId).child(mCurrentUser.getUid()).child("request_type").setValue("received").addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {

                                        mSendFriendRequestBtn.setEnabled(true);
                                        mCurrentFriendshipState = "request_sent";
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

                if (mCurrentFriendshipState.equals("request_sent")){
                    mFriendsRequestDatabase.child(mCurrentUser.getUid()).child(userId).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            mFriendsRequestDatabase.child(userId).child(mCurrentUser.getUid()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    // if friend request was successfully canceled
                                    mSendFriendRequestBtn.setEnabled(true);
                                    mCurrentFriendshipState = "not_friends";
                                    mSendFriendRequestBtn.setText("Send Friend Request");

                                }
                            });
                        }
                    });
                }

                //----------------------REQUEST RECEIVED STATE------------------------------------

                if (mCurrentFriendshipState.equals("request_received")) {

                    final String currentDate = DateFormat.getDateTimeInstance().format(new Date());
                    mFriendDatabase.child(mCurrentUser.getUid()).child(userId).setValue(currentDate).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                            mFriendDatabase.child(userId).child(mCurrentUser.getUid()).setValue(currentDate).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    mFriendsRequestDatabase.child(mCurrentUser.getUid()).child(userId).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            mFriendsRequestDatabase.child(userId).child(mCurrentUser.getUid()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {

                                                    // if friend request was successfully canceled
                                                    mSendFriendRequestBtn.setEnabled(true);
                                                    mCurrentFriendshipState = "friends";
                                                    mSendFriendRequestBtn.setText("Unfriend this Person");

                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        }
                    });

                }
            }
        });
    }
}
