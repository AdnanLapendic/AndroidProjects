package adnanlapendic.ba.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import adnanlapendic.ba.movieapp.DetailActivity;
import adnanlapendic.ba.movieapp.R;
import adnanlapendic.ba.movieapp.model.Movie;

/**
 * Created by adnan on 15.1.2018..
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{

    private Context mContext;
    private List<Movie> movieList;

    public MovieAdapter(Context mContext, List<Movie> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
    }


   @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_card, viewGroup, false);
       return new MyViewHolder(view);
   }

    @Override
    public void onBindViewHolder(final MovieAdapter.MyViewHolder viewHolder, int i) {
        viewHolder.title.setText(movieList.get(i).getOrginnalTitle());
        String vote = Double.toString(movieList.get(i).getVoteAverage());
        viewHolder.userRating.setText(vote);

        String poster = "https://image.tmdb.org/t/p/w500" + movieList.get(i).getPosterPath();

        Log.i(" o o o o o o o o o o o", movieList.get(i).getPosterPath());

        Glide.with(mContext).load(poster).placeholder(R.drawable.load).into(viewHolder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView userRating;
        public ImageView thumbnail;

        public MyViewHolder(View view){
            super(view);
            title = view.findViewById(R.id.title);
            userRating = view.findViewById(R.id.user_rating);
            thumbnail = view.findViewById(R.id.thumbnail);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Movie clickedDataItem = movieList.get(pos);
                        Intent intent = new Intent(mContext, DetailActivity.class);
                        intent.putExtra("original_title", movieList.get(pos).getOrginnalTitle());
                        intent.putExtra("poster_path", movieList.get(pos).getPosterPath());
                        intent.putExtra("overview", movieList.get(pos).getOverview());
                        intent.putExtra("vote_average", Double.toString(movieList.get(pos).getVoteAverage()));
                        intent.putExtra("release_date", movieList.get(pos).getReleaseDate());
                        intent.putExtra("id", movieList.get(pos).getId());

                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getOrginnalTitle(), Toast.LENGTH_SHORT).show();

                    }

                }
            });
        }
    }
}
