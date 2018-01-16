package adnanlapendic.ba.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by adnan on 15.1.2018..
 */

public class DetailActivity extends AppCompatActivity{

    TextView nameOfMovie;
    TextView plotSynopsis;
    TextView userRating;
    TextView releaseDate;
    ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initCollapsingToolbar();

        imageView = findViewById(R.id.thumbnail_image_header);
        nameOfMovie = findViewById(R.id.title);
        plotSynopsis = findViewById(R.id.plot_synopsis);
        userRating = findViewById(R.id.user_rating);
        releaseDate = findViewById(R.id.release_date);

        String poster = "https://image.tmdb.org/t/p/w500";

        Intent intent = getIntent();
        Log.i("- - - - - - - - - - - -", intent.getExtras().getString("poster_path"));
        if (intent.hasExtra("original_title")){
            String thumbnail = poster + getIntent().getExtras().getString("poster_path");
            String movieName = getIntent().getExtras().getString("original_title");
            String synopsis = getIntent().getExtras().getString("overview");
            String rating = getIntent().getExtras().getString("vote_average");
            String dateOfRelease = getIntent().getExtras().getString("release_date");

            Glide.with(this).load(thumbnail).placeholder(R.drawable.load).into(imageView);
            nameOfMovie.setText(movieName);
            plotSynopsis.setText(synopsis);
            userRating.setText(rating);
            releaseDate.setText(dateOfRelease);

        } else {
            Toast.makeText(this, "No API Data", Toast.LENGTH_SHORT).show();
        }
        
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("");
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(scrollRange == -1){
                    scrollRange = appBarLayout.getTotalScrollRange();

                }

                if(scrollRange + verticalOffset == 0){
                    collapsingToolbarLayout.setTitle(getString(R.string.movie_details));
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle("");
                    isShow = false;
                }

            }
        });
    }
}
