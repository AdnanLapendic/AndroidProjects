package com.lapa.citypatrol;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.nearby.bootstrap.request.SendDataRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class NewIssueActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {


    private static int PICTURE_NUMBER = 0;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private double latitude;
    private double longitude;
    private TextView latitudeValue;
    private TextView longitudeValue;
    private ImageView imageView;
    private EditText editText;
    private String category;
    private String description;
    private Spinner spinner;
    private ArrayAdapter<CharSequence> adapter;
    private String[] categories = {"damaged sidewalk", "street light out", "park issues", "pothole", "graffiti", "traffic signals"};
    private DbHandler dbHandler;
    private Button saveButton;
    private Button cancelButton;
    private File pictureFile;
    private File pictureDirectory;
    private String imgUrl;
    private Vibrator vibe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_issue);

        vibe = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);

        dbHandler = new DbHandler(this, null, null, 1);

        imageView = (ImageView) findViewById(R.id.showTakenImage);
        editText = (EditText) findViewById(R.id.descriptionText);

        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        latitudeValue = (TextView) findViewById(R.id.latitudeValue);
        longitudeValue = (TextView) findViewById(R.id.longitudeValue);

        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vibe.vibrate(20);
                category = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                category = "Other";

            }
        });

        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                description = editText.getText().toString();

//                Toast.makeText(getApplicationContext(), ADNAN_LAPENDIC, Toast.LENGTH_LONG).show();
                if (pictureFile != null) {
                    new UploadImageOnCloudinary().execute();
                }

                vibe.vibrate(20);


                sendDataToServer(new Issue(category, imgUrl, String.valueOf(latitude), String.valueOf(longitude), description, "888888888888888"));

                finish();
            }

        });

        cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(20);
                finish();
            }
        });

    }

    public void takeNewPhoto(View v) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        vibe.vibrate(20);

        pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureName = getPictureName();
        pictureFile = new File(pictureDirectory, pictureName);
        Uri pictureUri = Uri.fromFile(pictureFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);

        startActivityForResult(intent, 23);

    }

    public void openNewPhoto(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        vibe.vibrate(20);
        startActivityForResult(intent, 07);
    }

    private String getPictureName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HH");
        String timeStamp = sdf.format(new Date());
        String result = "CityPatrol" + timeStamp + PICTURE_NUMBER + ".jpg";
        PICTURE_NUMBER++;

        return result;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 23) {

//                Uri uri = data.getData();
//                imageView.setImageURI(uri);
//                Bitmap image = BitmapFactory.decodeFile(pictureFile.getAbsolutePath());
//                imageView.setImageBitmap(image);


            }
            if (requestCode == 07) {
                Uri selectedImage = data.getData();
                imageView.setImageURI(selectedImage);

//                try {
//                   pictureFile = new File(new URI(selectedImage.getPath()));
//
//                } catch (URISyntaxException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        requestLocationUpdates();
    }

    private void requestLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        googleApiClient.disconnect();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (googleApiClient.isConnected()) {
            requestLocationUpdates();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        latitudeValue.setText((Double.toString(latitude)));
        longitudeValue.setText(Double.toString(longitude));

    }

    private class UploadImageOnCloudinary extends AsyncTask<Void, Void, Map> {

        @Override
        protected Map doInBackground(Void... params) {

            Map config = new HashMap();
            config.put("cloud_name", "doqnakvit");
            config.put("api_key", "424773357516248");
            config.put("api_secret", "XlVVUCALvnsnM_c5ag28Ck70plY");
            Cloudinary cloudinary = new Cloudinary(config);
            Map uploadedResult = null;
            try {
//                Log.i("before upload" + "********" + photoFile.getAbsolutePath(), "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                if (pictureFile != null) {
                    uploadedResult = cloudinary.uploader().upload(pictureFile.getAbsolutePath(), ObjectUtils.asMap());
                }
//                Log.i("after upload", "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


            } catch (IOException e) {
                e.printStackTrace();
            }


            return uploadedResult;
        }

        @Override
        protected void onPostExecute(Map map) {
            super.onPostExecute(map);


//            Log.i(imgUrl, "**********************************************************************************************************");
                imgUrl = (String) map.get("url");
                Issue issue = new Issue(category, imgUrl, String.valueOf(latitude), String.valueOf(longitude), description, "address");
                sendDataToServer(issue);
                dbHandler.addNewIssue(issue);


//            Log.i(imgUrl, "////////////////////////////////////////////////////////////////////////////////////");

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

    public void sendDataToServer(Issue issue) {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("latitude", issue.getLatitude());
            jsonObject.put("longitude", issue.getLongitude());
            jsonObject.put("category", issue.getCategory());
            jsonObject.put("description", issue.getDescription());
            jsonObject.put("image", issue.getImageUrl());
            jsonObject.put("address", issue.getAddress());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jsonObject.length() > 0) {
            new SendDataToServer().execute(String.valueOf(jsonObject));


        }
    }

    class SendDataToServer extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String JsonResponse = null;
            String JsonDATA = params[0];
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(MainActivity.JSON_URL);
                urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestProperty("Accept", "application/json");

                Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
                writer.write(JsonDATA);
                writer.close();
                InputStream inputStream = urlConnection.getInputStream();

                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {

                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String inputLine;
                while ((inputLine = reader.readLine()) != null)
                    buffer.append(inputLine + "\n");
                if (buffer.length() == 0) {

                    return null;
                }
                JsonResponse = buffer.toString();

                Log.i("", JsonResponse);
                try {

                    return JsonResponse;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("", "Error closing stream", e);
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

}