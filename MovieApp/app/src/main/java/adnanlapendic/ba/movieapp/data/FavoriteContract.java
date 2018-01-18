package adnanlapendic.ba.movieapp.data;

import android.provider.BaseColumns;

/**
 * Created by adnan on 18.1.2018..
 */

public class FavoriteContract {

    public static final class FavotiteEntry implements BaseColumns{

        public static final String TABLE_NAME = "favorite";
        public static final String MOVIE_ID = "movie_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_USER_RATING = "user_rating";
        public static final String COLUMN_POSTER_PATH = "poster_path";
        public static final String COLUMN_PLOT_SYNOPSIS = "overview";



    }
}
