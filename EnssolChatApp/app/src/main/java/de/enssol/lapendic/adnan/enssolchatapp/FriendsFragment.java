package de.enssol.lapendic.adnan.enssolchatapp;


import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {

    private RecyclerView mFriendsList;
    private DatabaseReference mFriendsDatabase;
    private DatabaseReference mUsersDatabase;
    private FirebaseAuth mAuth;
    private String mCurrentUserId;
    private View mMainView;

    public FriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mMainView = inflater.inflate(R.layout.fragment_friends, container, false);
        mFriendsList = mMainView.findViewById(R.id.friends_list);
        mAuth = FirebaseAuth.getInstance();
        mCurrentUserId = mAuth.getCurrentUser().getUid();
        mFriendsDatabase = FirebaseDatabase.getInstance().getReference().child("friends").child(mCurrentUserId);
        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        mFriendsList.setHasFixedSize(true);
        mFriendsList.setLayoutManager(new LinearLayoutManager(getContext()));


        return mMainView;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Friends, FriendsViewHolder> friendsRecyclerViewAdapter = new FirebaseRecyclerAdapter<Friends, FriendsViewHolder>(

                Friends.class,
                R.layout.user_single_layout,
                FriendsViewHolder.class,
                mFriendsDatabase

        ) {

            @Override
            protected void populateViewHolder(final FriendsViewHolder friendsViewHolder, Friends friends, int position) {

                friendsViewHolder.setDate(friends.getDate());
                String listUserId = getRef(position).getKey();
                mUsersDatabase.child(listUserId).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        String username = dataSnapshot.child("name").getValue().toString();
                        String thumbnail = dataSnapshot.child("thumb_image").getValue().toString();
                        if(dataSnapshot.hasChild("online")){

                            Boolean userOnline = (boolean) dataSnapshot.child("online").getValue();
                            friendsViewHolder.setUserOnline(userOnline);

                        }
                        mFriendsDatabase.keepSynced(true);
                        friendsViewHolder.setName(username);
                        friendsViewHolder.setUserImage(thumbnail, getContext());
                        mUsersDatabase.keepSynced(true);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        };

        mFriendsList.setAdapter(friendsRecyclerViewAdapter);

    }
    public static class FriendsViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public FriendsViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setDate(String date){
            TextView userNameView = mView.findViewById(R.id.user_single_status);
            userNameView.setText(date);
        }

        public void setName(String name){
            TextView userNameView = mView.findViewById(R.id.single_user_name);
            userNameView.setText(name);
        }

        /**
         * Method used to display thumbnail/user image at friends fragment
         * @param image - User thumbnail
         * @param context - Context passed from activity
         */
        public void setUserImage(String image, Context context) {
            CircleImageView imageView = mView.findViewById(R.id.list_user_image_view);
            Picasso.with(context).load(image).placeholder(R.drawable.adnan).into(imageView);
        }

        public void setUserOnline(Boolean onlineStatus){

            ImageView onlineIcon = mView.findViewById(R.id.user_single_online_icon);

            if(onlineStatus == true){
                onlineIcon.setVisibility(View.VISIBLE);
            } else {
                onlineIcon.setVisibility(View.INVISIBLE);
            }
        }
    }
}
