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

    /**
     * Constructor
     * @param itemView
     */
    public UsersViewHolder(View itemView) {
        super(itemView);
        //mView will be used to set onClick listener on user in list
        //used by Firebase Adapter
        mView = itemView;
    }

    /**
     * Method used to set user first and last name at list of all users
     * @param name - Name of the user
     */
    public void setUserName(String name) {

        TextView userNameView = mView.findViewById(R.id.single_user_name);
        userNameView.setText(name);

    }

    /**
     * Method used to display users status at all users list activity
     * @param status - User status
     */
    public void setUserStatus(String status) {
        TextView userStatusView = mView.findViewById(R.id.user_single_status);
        userStatusView.setText(status);
    }

    /**
     * Method used to display thumbnail/user image at all users activity
     * @param image - User thumbnail
     * @param context - Context passed from activity
     */
    public void setUserImage(String image, Context context) {
        CircleImageView imageView = mView.findViewById(R.id.list_user_image_view);
        Picasso.with(context).load(image).placeholder(R.drawable.adnan).into(imageView);
    }
}
