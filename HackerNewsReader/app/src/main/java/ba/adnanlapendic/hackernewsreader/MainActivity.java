package ba.adnanlapendic.hackernewsreader;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Map<Integer, String> articleUrls = new HashMap<>();
    Map<Integer, String> articleTitles = new HashMap<>();
    ArrayList<Integer> articleIds = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    ArrayList<String> urls = new ArrayList<>();

    SQLiteDatabase articleDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(), ArticleActivity.class);
                i.putExtra("articleUrl", urls.get(position));
                startActivity(i);

                Log.i("Article URL", urls.get(position));
            }
        });

        articleDb = this.openOrCreateDatabase("Articles", MODE_PRIVATE, null);

        articleDb.execSQL("CREATE TABLE IF NOT EXISTS articles(id INTEGER PRIMARY KEY, articleId INTEGER, url VARCHAR, title VARCHAR, content VARCHAR)");

        updateListView();

        DownloadTask task = new DownloadTask();

        try {

            task.execute("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty");

            updateListView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateListView() {

        try {
            Cursor c = articleDb.rawQuery("SELECT * FROM articles ORDER BY articleId DESC", null);

            int articleIdIndex = c.getColumnIndex("articleId");
            int urlIndex = c.getColumnIndex("url");
            int titleIndex = c.getColumnIndex("title");

            c.moveToFirst();

            titles.clear();
            urls.clear();

            while (c != null) {

                titles.add(c.getString(titleIndex));
                urls.add(c.getString(urlIndex));
//                Log.i("articleID", Integer.toString(c.getInt(articleIdIndex)));
//                Log.i("articleURL", c.getString(urlIndex));
//                Log.i("articleTitle", c.getString(titleIndex));
                c.moveToNext();
            }

            arrayAdapter.notifyDataSetChanged();

//            Log.i("articleIds", articleIds.toString());
//            Log.i("articleTitles", articleTitles.toString());
//            Log.i("articleUrls", articleUrls.toString());

//            Log.i("Result", result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls){

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);

                int data = reader.read();

                while (data != -1){

                    char c = (char) data;
                    result += c;

                    data = reader.read();
                }


                JSONArray jsonArray = new JSONArray(result);

                articleDb.execSQL("DELETE FROM articles");

                for (int i = 0; i < 30; i++){

//                Log.i("ArticleID", jsonArray.getString(i));

                    String articleID = jsonArray.getString(i);

                   url = new URL(" https://hacker-news.firebaseio.com/v0/item/"+articleID+".json?print=pretty");
                    urlConnection = (HttpURLConnection) url.openConnection();

                    inputStream = urlConnection.getInputStream();
                    reader = new InputStreamReader(inputStream);
                    data =reader.read();
                    String articleInfo = "";

                    while (data != -1){

                        char c = (char) data;
                        articleInfo += c;

                        data = reader.read();
                    }

                    JSONObject jsonObject = new JSONObject(articleInfo);

                    String articleTitle = jsonObject.getString("title");
                    String articleUrl = jsonObject.getString("url");

                    articleIds.add(Integer.valueOf(articleID));
                    articleTitles.put(Integer.valueOf(articleID), articleTitle);
                    articleUrls.put(Integer.valueOf(articleID), articleUrl);

                    String sql = "INSERT INTO articles (articleId, url, title) VALUES (?, ?, ?)";
                    SQLiteStatement statement = articleDb.compileStatement(sql);
                    statement.bindString(1, articleID);
                    statement.bindString(2, articleUrl);
                    statement.bindString(3, articleTitle);

                    statement.execute();

//                articleDb.execSQL("INSERT INTO articles (articleId, url, title) VALUES(" + articleID +", '" + articleUrl + "', '" + articleTitle + "')");

//                Log.i("Article title", articleTitle);
//                Log.i("Article url", articleUrl);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            updateListView();

        }
    }
}
