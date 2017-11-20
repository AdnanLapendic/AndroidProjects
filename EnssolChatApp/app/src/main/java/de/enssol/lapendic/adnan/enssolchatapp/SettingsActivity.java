package de.enssol.lapendic.adnan.enssolchatapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;

public class SettingsActivity extends AppCompatActivity {

    private DatabaseReference mUserDatabase;
    private FirebaseUser mCurrentUser;

    private Toolbar mToolbar;

    private CircleImageView mProfileImage;
    private TextView mName;
    private TextView mStatus;
    private Button mChangeStatusBtn;
    private Button mChangeProfileImageBtn;
    private ProgressDialog mProgress;

    private static final int GALLERY_PICK = 1;

    //Storage reference
    private StorageReference mImageStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mToolbar = findViewById(R.id.settings_app_barr);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();

        String uid = mCurrentUser.getUid();

        mImageStorage = FirebaseStorage.getInstance().getReference();

        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uid);
        mUserDatabase.keepSynced(true);

        mProfileImage = findViewById(R.id.settings_image);
        mName = findViewById(R.id.settings_display_name);
        mStatus = findViewById(R.id.settings_status_line);
        mChangeStatusBtn = findViewById(R.id.settings_change_status_btn);
        mChangeProfileImageBtn = findViewById(R.id.settings_change_image_btn);



        mUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //fetching data from db
                String name = dataSnapshot.child("name").getValue().toString();
                final String image = dataSnapshot.child("image").getValue().toString();
                String status = dataSnapshot.child("status").getValue().toString();
                String thumbnail = dataSnapshot.child("thumb_image").getValue().toString();

                //setting data to user settings activity
                mName.setText(name);
                mStatus.setText(status);
                if(!image.equals("default")){
                    //Picasso.with(SettingsActivity.this).load(image).placeholder(R.drawable.adnan).into(mProfileImage);

                    //Try to load image offline if available, and if not image will be downloaded from db storage
                    Picasso.with(SettingsActivity.this).load(image).networkPolicy(NetworkPolicy.NO_CACHE.OFFLINE).
                            placeholder(R.drawable.adnan).into(mProfileImage, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            Picasso.with(SettingsActivity.this).load(image).placeholder(R.drawable.adnan).into(mProfileImage);


                        }
                    });

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //changing profile status
        mChangeStatusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentStatus = mStatus.getText().toString();
                Intent intent = new Intent(SettingsActivity.this, StatusActivity.class);
                intent.putExtra("currentStatus", currentStatus);
                startActivity(intent);
            }
        });

        //changing profile picture
        mChangeProfileImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "SELECT_IMAGE"), GALLERY_PICK);

//                // start picker to get image for cropping and then use the image in cropping activity
//                CropImage.activity()
//                        .setGuidelines(CropImageView.Guidelines.ON)
//                        .start(SettingsActivity.this);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //loading profile image from gallery
        if(requestCode == GALLERY_PICK && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();

        // start cropping activity for pre-acquired image saved on the device
            CropImage.activity(imageUri)
                    .setAspectRatio(1,1)
                    .start(this);
        }

        //cropping selected image from gallery
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if (resultCode == RESULT_OK) {
                //Setting progress dialog when uploading image
                mProgress = new ProgressDialog(SettingsActivity.this);
                mProgress.setTitle("Uploading Image...");
                mProgress.setMessage("Please wait while we upload and process image.");
                mProgress.setCanceledOnTouchOutside(false);
                mProgress.show();

                //utl to the profile picture
                Uri resultUri = result.getUri();

                //creating thumbnail image from profile picture
                File thumbnailFilePath = new File(resultUri.getPath());

                //setting thumbnail max size and quality using Compressor library
                Bitmap thumbnailImage = null;
                try {
                    thumbnailImage = new Compressor(this)
                            .setMaxHeight(200)
                            .setMaxWidth(200)
                            .setQuality(50)
                            .compressToBitmap(thumbnailFilePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //ByteArray - used to upload image/thumbnail
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                thumbnailImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                final byte[] thumbBide = baos.toByteArray();

                String currentUser = mCurrentUser.getUid();

                //profile image in db storage/path in firebase
                StorageReference imageFilePath = mImageStorage.child("profile_images").child(currentUser + ".jpg");

                //save thumbnail image in storage/path in firebase
                final StorageReference thumbFilePath = mImageStorage.child("profile_images").child("thumbnail").child(currentUser + ".jpg");

                //uploading file
                imageFilePath.putFile(resultUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        if(task.isSuccessful()){

                            //getting url of the image
                            final String downloadUrl = task.getResult().getDownloadUrl().toString();

                            UploadTask uploadTask = thumbFilePath.putBytes(thumbBide);
                            uploadTask.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> thumbTask) {

                                    String thumbnailDownloadUrl = thumbTask.getResult().getDownloadUrl().toString();

                                    if(thumbTask.isSuccessful()) {

                                        //updating data in db storage - image and thumbnail
                                        Map updateHashMap = new HashMap<>();
                                        updateHashMap.put("image", downloadUrl);
                                        updateHashMap.put("thumb_image", thumbnailDownloadUrl);

                                        mUserDatabase.updateChildren(updateHashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()){
                                                    mProgress.dismiss();
                                                    Toast.makeText(SettingsActivity.this, "Success Uploading.", Toast.LENGTH_LONG).show();

                                                }
                                            }
                                        });

                                    }else {
                                        Toast.makeText(SettingsActivity.this, "Error uploading thumbnail.", Toast.LENGTH_LONG).show();
                                        mProgress.dismiss();
                                    }
                                }
                            });

                        }else {
                            Toast.makeText(SettingsActivity.this, "Not working", Toast.LENGTH_LONG).show();
                            mProgress.dismiss();
                        }
                    }
                });

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}


