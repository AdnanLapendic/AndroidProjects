package com.lapa.citypatrol;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static int CONNECTION = 0;
    private String JSON_STRING = "";
    private Button gprsButton;
    private Button newIssueButton;
    private Button settingsButton;
    private Button listIssuesButton;
    public static ArrayList<Issue> issues = new ArrayList<>();
    private DbHandler db;
    public static String ISSUES = "";
    public static final String JSON_URL = "http://192.168.100.4:9000/api/issues";
    private Vibrator vibe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getJson();

        db = new DbHandler(this, null, null, 1);

        checkForConnection();

        gprsButton = (Button) findViewById(R.id.buttonGprs);
        gprsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(20);
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });

        vibe = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);


        newIssueButton = (Button) findViewById(R.id.buttonNew);
        newIssueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(20);
                Intent i = new Intent(MainActivity.this, NewIssueActivity.class);
                startActivity(i);
            }
        });

        settingsButton = (Button) findViewById(R.id.buttonSettings);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(20);
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);
            }
        });

        listIssuesButton = (Button) findViewById(R.id.buttonReportedIssues);
        listIssuesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(20);
                Intent i = new Intent(MainActivity.this, ListIssueActivity.class);
                startActivity(i);
            }
        });


    }


    public void checkForConnection() {

        new UpdateSaveToDatabase().execute();
    }

    public void getJson() {

        new BackgroundTask().execute();

    }

    public class BackgroundTask extends AsyncTask<Void, Void, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {


            URL url = null;
            try {

                url = new URL(JSON_URL);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection httpURLConnection = null;


            try {
                assert url != null;
                httpURLConnection = (HttpURLConnection) url.openConnection();

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {

                assert httpURLConnection != null;
                InputStream inputStream = httpURLConnection.getInputStream();

                JSON_STRING = streamToString(inputStream);
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {

                JSONArray jsonArray = new JSONArray(JSON_STRING);

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jObject = jsonArray.getJSONObject(i);

                    String latitude = jObject.getString("latitude");
                    String longitude = jObject.getString("longitude");
                    String category = jObject.getString("category");
                    String description = jObject.getString("description");
                    String picture = jObject.getString("image");
                    String address = jObject.getString("address");

                    Issue issue = new Issue(category, picture, latitude, longitude, description, address);
                    ISSUES += issue.getLatitude();
                    issues.add(issue);

                    Log.i("FROM DB", issue.getImageUrl());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return JSON_STRING;
        }

        @Override
        protected void onPostExecute(String result) {

        }
    }

    public static String streamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public Boolean checkInternetConnection() {
        Boolean bool;
        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info != null && info.isConnected()) {
            bool = true;

        } else {
            bool = false;
        }
        return bool;
    }


    private class UpdateSaveToDatabase extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {

            if (checkInternetConnection()) {
                db.showAllFromDatabase();
                if(CONNECTION == 0) {
                    db.updateDatabase();
                    addIssuesFromDatabase();
                    CONNECTION = 1;
                }
            }
            return checkInternetConnection();
        }

        @Override
        protected void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool) {
                Toast.makeText(getApplicationContext(), "Network is available", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getApplicationContext(), "Network is not available", Toast.LENGTH_SHORT).show();

            }
        }
    }


    public void addIssuesFromDatabase() {
        for (int i = 0; i < issues.size(); i++) {
            db.addNewIssue(issues.get(i));
        }
    }

}

