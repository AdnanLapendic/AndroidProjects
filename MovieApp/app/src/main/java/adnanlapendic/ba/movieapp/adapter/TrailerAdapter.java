package adnanlapendic.ba.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import adnanlapendic.ba.movieapp.R;
import adnanlapendic.ba.movieapp.model.Trailer;

/**
 * Created by adnan on 17.1.2018..
 */

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.MyViewHolder> {

    private Context context;
    private List<Trailer> trailerList;

    public TrailerAdapter(Context mContext, List<Trailer> trailerList){
        this.context = mContext;
        this.trailerList = trailerList;

    }

    @Override
    public TrailerAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.trailer_card, viewGroup, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final TrailerAdapter.MyViewHolder viewHolder, int i){
        viewHolder.title.setText(trailerList.get(i).getName());

    }

    @Override
    public int getItemCount() {
        if(trailerList != null) {
            return trailerList.size();
        }
        return 0;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);

            title = view.findViewById(R.id.title);
            thumbnail = view.findViewById(R.id.imageView);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        Trailer clickedDataItem = trailerList.get(pos);
                        String videoId = trailerList.get(pos).getKey();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+videoId));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("VIDEO_ID", videoId);
                        context.startActivity(intent);

                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}