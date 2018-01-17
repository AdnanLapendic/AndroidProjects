package adnanlapendic.ba.movieapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by adnan on 17.1.2018..
 */

public class TrailerResponse {

    @SerializedName("id")
    private int trailer_id;
    @SerializedName("result")
    private List<Trailer> results;

    public int getIdTrailer() {
        return trailer_id;
    }

    public void setIdTrailer(int trailer_id) {
        this.trailer_id = trailer_id;
    }

    public List<Trailer> getResults() {
        return results;
    }

    public void setResults(List<Trailer> results) {
        this.results = results;
    }
}
