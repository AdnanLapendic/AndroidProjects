package de.enssol.lapendic.adnan.enssolchatapp;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by adnan on 10.1.2018..
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{

    private List<Messages> mMessageList;
    private FirebaseAuth mAuth;
    private DatabaseReference mUserDatabase;

    public MessageAdapter(List<Messages> mMessageList) {
        this.mMessageList = mMessageList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_single_layout, parent, false);

        return new MessageViewHolder(v);
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        public TextView messageText;
        public CircleImageView profileImage;
        public TextView displayName;
        public ImageView messageImage;


        public MessageViewHolder(View view) {
            super(view);
            messageText = view.findViewById(R.id.message_text_layout);
            profileImage = view.findViewById(R.id.message_profile_layout);
            displayName = view.findViewById(R.id.message_display_name);
            messageImage = view.findViewById(R.id.message_image_layout);
        }

    }

    @Override
    public void onBindViewHolder(final MessageViewHolder viewHolder, int i) {

        mAuth = FirebaseAuth.getInstance();
        String currentUserId = mAuth.getCurrentUser().getUid();
        Messages c = mMessageList.get(i);

        String fromUser = c.getFrom();
        String messageType = c.getType();

        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(fromUser);

        mUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue().toString();
                String image = dataSnapshot.child("image").getValue().toString();

                viewHolder.displayName.setText(name);

                Picasso.with(viewHolder.profileImage.getContext()).load(image)
                        .placeholder(R.drawable.adnan).into(viewHolder.profileImage);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        if (messageType.equals("text")){
            viewHolder.messageText.setText(c.getMessages());
            viewHolder.messageImage.setVisibility(View.VISIBLE);

        } else {

            viewHolder.messageText.setVisibility(View.INVISIBLE);

            Picasso.with(viewHolder.profileImage.getContext()).load(c.getMessages())
                    .placeholder(R.drawable.adnan).into(viewHolder.messageImage);

        }

//
//        if(fromUser.equals(currentUserId)){
//            viewHolder.messageText.setBackgroundColor(Color.WHITE);
//            viewHolder.messageText.setTextColor(Color.BLACK);
//        } else {
//            viewHolder.messageText.setBackgroundResource(R.drawable.message_text_background);
//            viewHolder.messageText.setTextColor(Color.WHITE);
//        }
//
//        viewHolder.messageText.setText(c.getMessages());
//        viewHolder.displayName.setText(c.getFrom());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

}
