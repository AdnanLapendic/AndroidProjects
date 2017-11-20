package de.enssol.lapendic.adnan.enssolchatapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by user on 20.11.2017..
 */

public class UsersViewHolder extends RecyclerView.ViewHolder{

    public View mView;
    private Context context;

    public UsersViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setUserName(String name) {

        TextView userNameView = mView.findViewById(R.id.list_user_name);
        userNameView.setText(name);

    }

    public void setUserStatus(String status) {
        TextView userStatusView = mView.findViewById(R.id.list_user_status);
        userStatusView.setText(status);
    }

    public void setUserImage(String image, Context context) {
        CircleImageView imageView = mView.findViewById(R.id.list_user_image_view);

//        Picasso.with(SettingsActivity.this).load(image).into(mProfileImage);

        Picasso.with(context).load(image).placeholder(R.drawable.adnan).into(imageView);
    }
}
