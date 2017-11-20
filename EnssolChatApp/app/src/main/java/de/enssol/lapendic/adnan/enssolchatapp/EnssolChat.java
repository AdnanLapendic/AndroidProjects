package de.enssol.lapendic.adnan.enssolchatapp;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

/**
 * Created by adnan on 11/20/2017.
 */

public class EnssolChat extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Enable offline firebase
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        //Offline Picasso
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this, Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);
    }
}
