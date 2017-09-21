package com.lapa.citypatrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class ListIssueActivity extends AppCompatActivity {
    ListView listView;
    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_issue);

        db = new DbHandler(this, null, null, 1);

        final ArrayList<Issue> issues = db.showAllFromDatabase();

        listView = (ListView)findViewById(R.id.listView);
        IssueListAdapter listAdapter = new IssueListAdapter(this, issues);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ListIssueActivity.this, DetailViewIssueActivity.class);

                String latitude = issues.get(position).getLatitude();
                String longitude = issues.get(position).getLongitude();
                String category = issues.get(position).getCategory();
                String description = issues.get(position).getDescription();
                String image = issues.get(position).getImageUrl();
                String address = issues.get(position).getAddress();

                intent.putExtra("LATITUDE", latitude);
                intent.putExtra("LONGITUDE", longitude);
                intent.putExtra("CATEGORY", category);
                intent.putExtra("DESCRIPTION", description);
                intent.putExtra("IMAGE", image);
                intent.putExtra("ADDRESS", address);

                startActivity(intent);

            }
        });

        listView.setAdapter(listAdapter);

    }


}
