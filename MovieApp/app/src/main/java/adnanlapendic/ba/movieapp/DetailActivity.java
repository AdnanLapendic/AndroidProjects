package adnanlapendic.ba.movieapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adnanlapendic.ba.movieapp.adapter.TrailerAdapter;
import adnanlapendic.ba.movieapp.api.Client;
import adnanlapendic.ba.movieapp.api.Service;
import adnanlapendic.ba.movieapp.data.FavoriteDbHelper;
import adnanlapendic.ba.movieapp.model.Movie;
import adnanlapendic.ba.movieapp.model.Trailer;
import adnanlapendic.ba.movieapp.model.TrailerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by adnan on 15.1.2018..
 */

public class DetailActivity extends AppCompatActivity{

    private TextView nameOfMovie;
    private TextView plotSynopsis;
    private TextView userRating;
    private TextView releaseDate;
    private ImageView imageView;
    private RecyclerView recyclerView;
    private TrailerAdapter adapter;
    private List<Trailer> trailerList;
    private FavoriteDbHelper favoriteDbHelper;
    private Movie favoriteMovie;
    private final AppCompatActivity activity = DetailActivity.this;


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

        MaterialFavoriteButton materialFavoriteButton = findViewById(R.id.favorite_button);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        materialFavoriteButton.setOnFavoriteChangeListener(new MaterialFavoriteButton.OnFavoriteChangeListener() {
            @Override
            public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                if(favorite){
                SharedPreferences.Editor editor = getSharedPreferences("adnanlapendic.ba.movieapp.Detailactivity", MODE_PRIVATE).edit();
                editor.putBoolean("favorite_added", true);
                editor.apply();
                saveFavorite();
                Snackbar.make(buttonView, "Movie added to favorite list", Snackbar.LENGTH_SHORT).show();

                }else {
                    int movieId= getIntent().getExtras().getInt("id");
                    favoriteDbHelper = new FavoriteDbHelper(DetailActivity.this);
                    favoriteDbHelper.deleteFavorite(movieId);

                    SharedPreferences.Editor editor = getSharedPreferences("adnanlapendic.ba.movieapp.DetailActivity", MODE_PRIVATE).edit();
                    editor.putBoolean("favorite_removed", true);
                    editor.apply();
                    Snackbar.make(buttonView, "Movie removed from favorite list", MODE_PRIVATE).show();
                }
            }
        });

        initViews();
        
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

    private void initViews(){
        trailerList = new ArrayList<>();
        adapter = new TrailerAdapter(this, trailerList);

        recyclerView = findViewById(R.id.recycler_view1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        loadJSON();

    }

    private void loadJSON(){

        int movie_id = getIntent().getExtras().getInt("id");
        try{
            if (BuildConfig.THE_MOVIE_DB_API_TOKEN.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please obtain your API Key from themoviedb.org", Toast.LENGTH_SHORT).show();
                return;
            }
            Client Client = new Client();
            Service apiService = Client.getClient().create(Service.class);
            Call<TrailerResponse> call = apiService.getMovieTrailer(movie_id, BuildConfig.THE_MOVIE_DB_API_TOKEN);
            call.enqueue(new Callback<TrailerResponse>() {
                @Override
                public void onResponse(Call<TrailerResponse> call, Response<TrailerResponse> response) {

                    List<Trailer> trailer = new ArrayList<>();
                            trailer = response.body().getResults();
                    recyclerView.setAdapter(new TrailerAdapter(getApplicationContext(), trailer));
                    recyclerView.smoothScrollToPosition(0);
                }

                @Override
                public void onFailure(Call<TrailerResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(DetailActivity.this, "Error fetching trailer data", Toast.LENGTH_SHORT).show();

                }
            });

        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    private void saveFavorite() {

        favoriteDbHelper = new FavoriteDbHelper(activity);
        favoriteMovie = new Movie();
        int movieId = getIntent().getExtras().getInt("id");
        String rate = getIntent().getExtras().getString("vote_average");
        String poster = getIntent().getExtras().getString("poster_path");
        favoriteMovie.setId(movieId);
        favoriteMovie.setOrginnalTitle(nameOfMovie.getText().toString());
        favoriteMovie.setPosterPath(poster);
        favoriteMovie.setVoteAverage(Double.parseDouble(rate));
        favoriteMovie.setOverview(plotSynopsis.getText().toString());

        favoriteDbHelper.addFavorite(favoriteMovie);




    }
}
