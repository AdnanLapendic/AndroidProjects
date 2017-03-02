package ba.adnanlapendic.whatstheweather;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText cityName;
    TextView weatherResult;
    final String API_KEY = "b3d3be19d85bac93e15716699b7618ac";


    public void findCity(View view){

        InputMethodManager mng = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mng.hideSoftInputFromInputMethod(cityName.getWindowToken(), 0);

        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute("http://api.openweathermap.org/data/2.5/weather?q=" + cityName.getText().toString()+ "&appid=" + API_KEY);

        Log.i("Funkcija ", "+++++++++++++++++++");
    }



    public class DownloadTask extends AsyncTask<String, Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            Log.i("DO IN BACKGROIND", "++++++++++++");

            URL url;
            HttpURLConnection connection = null;
            String result = "";
            int data;
            char c;

            try {

                url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);

                data = reader.read();

                while (data != -1){
                    c = (char) data;
                    result += c;

                    data = reader.read();
                }

                Log.i("RESULT", result);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            String weatherInfo = "";
            String msg = "";

            try {
                JSONObject jsonObject = new JSONObject(result);

                weatherInfo = jsonObject.getString("weather");


                JSONArray jsonArray = new JSONArray(weatherInfo);

                for (int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonPart = jsonArray.getJSONObject(i);

                    String main = "";
                    String description = "";

                    main = jsonPart.getString("main");
                    description = jsonPart.getString("description");

                    if(main != "" && description != ""){
                        msg += main +": " + description + "\r\n";
                    }
                }

                if (msg != ""){
                    weatherResult.setText(msg);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = (EditText) findViewById(R.id.cityName);
        weatherResult = (TextView) findViewById(R.id.weatherResult);

    }
}
