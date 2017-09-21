package com.lapa.citypatrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class DetailViewIssueActivity extends AppCompatActivity {

    private TextView category;
    private TextView latitude;
    private TextView longitude;
    private TextView address;
    private TextView description;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view_issue);

        category = (TextView)findViewById(R.id.issueDetailViewCategory);
        latitude = (TextView)findViewById(R.id.issueDetailViewLatitude);
        longitude = (TextView)findViewById(R.id.issueDetailViewLongitude);
        address = (TextView)findViewById(R.id.issueDetailViewAddress);
        description = (TextView)findViewById(R.id.issueDetailViewDescription);
        image = (ImageView)findViewById(R.id.issueDetailViewImage);

        Intent intent = this.getIntent();
        String category1 = intent.getExtras().getString("CATEGORY");
        String latitude1 = intent.getExtras().getString("LATITUDE");
        String longitude1 = intent.getExtras().getString("LONGITUDE");
        String address1 = intent.getExtras().getString("ADDRESS");
        String description1 = intent.getExtras().getString("DESCRIPTION");
        String image1 = intent.getExtras().getString("IMAGE");

        category.setText(category1);
        latitude.setText(latitude1);
        longitude.setText(longitude1);
        address.setText(address1);
        description.setText(description1);
        Picasso.with(this).load(image1).into(image);


    }
}
