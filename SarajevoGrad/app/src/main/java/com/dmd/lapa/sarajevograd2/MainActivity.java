package com.dmd.lapa.sarajevograd2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String ARTICLE_ID_EXTRA = "com.dmd.lapa.sarajevograd2.Article Id";
    public static final String ARTICLE_TITLE_EXTRA = "com.dmd.lapa.sarajevograd2.Article Title";
    public static final String ARTICLE_BODY_EXTRA = "com.dmd.lapa.sarajevograd2.Article Body";
    public static final String ARTICLE_CATEGORY_EXTRA = "com.dmd.lapa.sarajevograd2.Article Category";
    public static final String ARTICLE_TIME_EXTRA = "com.dmd.lapa.sarajevograd2.Article Time";
    public static final String ARTICLE_DATE_EXTRA = "com.dmd.lapa.sarajevograd2.Article Date";
    public static final String ARTICLE_IMAGE_EXTRA = "com.dmd.lapa.sarajevograd2.Article Image";
    public ArrayList<Article> lastNews;
    NotificationCompat.Builder notification;
    private int id = 96369;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Articledb.articles.size() == 0) {
            Articledb.populateDb();
        }

        lastNews = Articledb.getLastNews();

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setLastNewsTop();

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

//        sendNewNotification(Articledb.articlesScitech.get(1));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.vijesti) {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("lapa", 1);
            startActivity(intent);

        } else if (id == R.id.bih) {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("lapa", 2);

            startActivity(intent);

        } else if (id == R.id.regija) {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("lapa", 3);

            startActivity(intent);

        } else if (id == R.id.svijet) {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("lapa", 4);
            startActivity(intent);

        } else if (id == R.id.sport) {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("lapa", 5);
            startActivity(intent);

        } else if (id == R.id.scitech) {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("lapa", 6);
            startActivity(intent);

        } else if (id == R.id.zanimljivosti) {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("lapa", 7);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onTopArticleClick(View view) {

        Article article = lastNews.get(0);

        Intent intent = new Intent(this, ArticleDetailActivity.class);
        intent.putExtra(MainActivity.ARTICLE_BODY_EXTRA, article.getBody());
        intent.putExtra(MainActivity.ARTICLE_TITLE_EXTRA, article.getTitle());
        intent.putExtra(MainActivity.ARTICLE_CATEGORY_EXTRA, article.getCategory());
        intent.putExtra(MainActivity.ARTICLE_DATE_EXTRA, article.getDate());
        intent.putExtra(MainActivity.ARTICLE_TIME_EXTRA, article.getTime());
        intent.putExtra(MainActivity.ARTICLE_ID_EXTRA, article.getId());
        intent.putExtra(MainActivity.ARTICLE_IMAGE_EXTRA, article.getImage());

        startActivity(intent);

    }

    public void onLeftArticleClick(View view) {

        Article article = lastNews.get(1);

        Intent intent = new Intent(this, ArticleDetailActivity.class);
        intent.putExtra(MainActivity.ARTICLE_BODY_EXTRA, article.getBody());
        intent.putExtra(MainActivity.ARTICLE_TITLE_EXTRA, article.getTitle());
        intent.putExtra(MainActivity.ARTICLE_CATEGORY_EXTRA, article.getCategory());
        intent.putExtra(MainActivity.ARTICLE_DATE_EXTRA, article.getDate());
        intent.putExtra(MainActivity.ARTICLE_TIME_EXTRA, article.getTime());
        intent.putExtra(MainActivity.ARTICLE_ID_EXTRA, article.getId());
        intent.putExtra(MainActivity.ARTICLE_IMAGE_EXTRA, article.getImage());

        startActivity(intent);

    }

    public void onRightArticleClick(View view) {

        Article article = lastNews.get(2);

        Intent intent = new Intent(this, ArticleDetailActivity.class);
        intent.putExtra(MainActivity.ARTICLE_BODY_EXTRA, article.getBody());
        intent.putExtra(MainActivity.ARTICLE_TITLE_EXTRA, article.getTitle());
        intent.putExtra(MainActivity.ARTICLE_CATEGORY_EXTRA, article.getCategory());
        intent.putExtra(MainActivity.ARTICLE_DATE_EXTRA, article.getDate());
        intent.putExtra(MainActivity.ARTICLE_TIME_EXTRA, article.getTime());
        intent.putExtra(MainActivity.ARTICLE_ID_EXTRA, article.getId());
        intent.putExtra(MainActivity.ARTICLE_IMAGE_EXTRA, article.getImage());

        startActivity(intent);

    }

    TextView topCategory;
    TextView topTitle;
    TextView topDate;
    TextView topTime;
    ImageView image;

    private void setLastNewsTop() {


        //right article main page

        topCategory = (TextView) findViewById(R.id.mainPageLastNewsCategoryLeft);
        topTitle = (TextView) findViewById(R.id.mainPageLastNewsTitleLeft);
        topDate = (TextView) findViewById(R.id.mainPageLastNewsDateLeft);
        topTime = (TextView) findViewById(R.id.mainPageLastNewsTimeLeft);
        image = (ImageView) findViewById(R.id.mainPageLastNewsImageLeft);

        Article left = lastNews.get(1);
        topCategory.setText(left.getCategory());
        topTitle.setText(left.getTitle());
        topDate.setText(left.getDate());
        topTime.setText(left.getTime());
        Picasso.with(getApplicationContext()).load(left.getImage()).placeholder(R.drawable.news).into(image);

        topCategory.hasFocus();

        //right article main page
        topCategory = (TextView) findViewById(R.id.mainPageLastNewsCategoryRight);
        topTitle = (TextView) findViewById(R.id.mainPageLastNewsTitleRight);
        topDate = (TextView) findViewById(R.id.mainPageLastNewsDateRight);
        topTime = (TextView) findViewById(R.id.mainPageLastNewsTimeRight);
        image = (ImageView) findViewById(R.id.mainPageLastNewsImageRight);

        Article right = lastNews.get(2);
        topCategory.setText(right.getCategory());
        topTitle.setText(right.getTitle());
        topDate.setText(right.getDate());
        topTime.setText(right.getTime());
        Picasso.with(getApplicationContext()).load(right.getImage()).placeholder(R.drawable.news).into(image);

        //top article main page

        topCategory = (TextView) findViewById(R.id.mainPageLastNewsCategoryTop);
        topTitle = (TextView) findViewById(R.id.mainPageLastNewsTitleTop);
        topDate = (TextView) findViewById(R.id.mainPageLastNewsDateTop);
        topTime = (TextView) findViewById(R.id.mainPageLastNewsTimeTop);
        image = (ImageView) findViewById(R.id.mainPageLastNewsImageTop);


        final Article top = lastNews.get(0);
        topCategory.setText(top.getCategory());
        topTitle.setText(top.getTitle());
        topDate.setText(top.getDate());
        topTime.setText(top.getTime());
        Picasso.with(getApplicationContext()).load(top.getImage()).placeholder(R.drawable.news).into(image);

    }

//    public void sendNewNotification(Article article) {
//
//        Intent i = new Intent(MainActivity.this, ArticleDetailActivity.class);
//        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(getApplicationContext());
//        taskStackBuilder.addParentStack(ArticleDetailActivity.class);
//        taskStackBuilder.addNextIntent(i);
//
//        notification.setSmallIcon(R.drawable.logo);
//        notification.setTicker(article.getTitle());
//        notification.setWhen(System.currentTimeMillis());
//        notification.setContentTitle(article.getTitle());
//        notification.setContentText(article.getBody());
//
//        Intent intent = new Intent(this, MainActivity.class);
//
//        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(123, PendingIntent.FLAG_UPDATE_CURRENT);
//        notification.setContentIntent(pendingIntent);
//
//        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.notify(id, notification.build());
//
//    }
}