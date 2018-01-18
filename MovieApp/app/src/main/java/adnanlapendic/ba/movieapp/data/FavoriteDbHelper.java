package adnanlapendic.ba.movieapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import adnanlapendic.ba.movieapp.model.Movie;

/**
 * Created by adnan on 18.1.2018..
 */

public class FavoriteDbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "favorite.db";
    private static final int DATABASE_VERSION = 1;
    private static final String LOGTAG = "FAVORITE";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase db;

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     */
    public FavoriteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open(){
        Log.d(LOGTAG, "Database opened");
        db = dbhandler.getWritableDatabase();

    }

    public void close(){
        Log.d(LOGTAG, "Database opened");
        dbhandler.close();

    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_FAVORITE_TABLE = "CREATE TABLE " + FavoriteContract.FavotiteEntry.TABLE_NAME +
                " (" +
                FavoriteContract.FavotiteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FavoriteContract.FavotiteEntry.MOVIE_ID + " INTEGER, " +
                FavoriteContract.FavotiteEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                FavoriteContract.FavotiteEntry.COLUMN_USER_RATING + " REAL NOT NULL, " +
                FavoriteContract.FavotiteEntry.COLUMN_POSTER_PATH + " TEXT NOT NULL, " +
                FavoriteContract.FavotiteEntry.COLUMN_PLOT_SYNOPSIS + " TEXT NOT NULL " +
                ");";

        db.execSQL(SQL_CREATE_FAVORITE_TABLE);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + FavoriteContract.FavotiteEntry.TABLE_NAME);
        onCreate(db);

    }

    public void addFavorite(Movie movie) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FavoriteContract.FavotiteEntry.MOVIE_ID, movie.getId());
        values.put(FavoriteContract.FavotiteEntry.COLUMN_TITLE, movie.getOrginnalTitle());
        values.put(FavoriteContract.FavotiteEntry.COLUMN_USER_RATING, movie.getVoteAverage());
        values.put(FavoriteContract.FavotiteEntry.COLUMN_POSTER_PATH, movie.getPosterPath());
        values.put(FavoriteContract.FavotiteEntry.COLUMN_PLOT_SYNOPSIS, movie.getOverview());

        db.insert(FavoriteContract.FavotiteEntry.TABLE_NAME, null, values);
        db.close();
    }

    public void deleteFavorite(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(FavoriteContract.FavotiteEntry.TABLE_NAME, FavoriteContract.FavotiteEntry.MOVIE_ID + "="  + id, null);
    }

    public List<Movie> getAllFavoriteMovies(){
        String[] columns = {
                FavoriteContract.FavotiteEntry._ID,
                FavoriteContract.FavotiteEntry.MOVIE_ID,
                FavoriteContract.FavotiteEntry.COLUMN_TITLE,
                FavoriteContract.FavotiteEntry.COLUMN_USER_RATING,
                FavoriteContract.FavotiteEntry.COLUMN_POSTER_PATH,
                FavoriteContract.FavotiteEntry.COLUMN_PLOT_SYNOPSIS
        };

        String sortOrder = FavoriteContract.FavotiteEntry._ID + " ASC";
        List<Movie> favotireMovies = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                FavoriteContract.FavotiteEntry.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                sortOrder);

        if(cursor.moveToFirst()){
            do {
                Movie movie = new Movie();
                movie.setId(Integer.valueOf(cursor.getString(cursor.getColumnIndex(FavoriteContract.FavotiteEntry.MOVIE_ID))));
                movie.setOrginnalTitle(cursor.getString(cursor.getColumnIndex(FavoriteContract.FavotiteEntry.COLUMN_TITLE)));
                movie.setVoteAverage(Double.parseDouble(cursor.getString(cursor.getColumnIndex(FavoriteContract.FavotiteEntry.COLUMN_USER_RATING))));
                movie.setPosterPath(cursor.getString(cursor.getColumnIndex(FavoriteContract.FavotiteEntry.COLUMN_POSTER_PATH)));
                movie.setOverview(cursor.getString(cursor.getColumnIndex(FavoriteContract.FavotiteEntry.COLUMN_PLOT_SYNOPSIS)));

                favotireMovies.add(movie);


            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return favotireMovies;
    }
}
