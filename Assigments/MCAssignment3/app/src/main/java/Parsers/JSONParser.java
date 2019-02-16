package Parsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Model.Movie;
import Utils.Constants;

public class JSONParser {

    public ArrayList<Movie> parseData(String response) {
        ArrayList<Movie> movieArrayList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray(Constants.TAG_RESULTS);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonMovieObject = jsonArray.getJSONObject(i);
                Movie movie = new Movie();
                movie.setTitle(jsonMovieObject.getString(Constants.TAG_TITLE));
                movie.setOverview(jsonMovieObject.getString(Constants.TAG_OVERVIEW));
                movie.setPosterPath(jsonMovieObject.getString(Constants.TAG_POSTER_PATH));
                movie.setReleaseDate(jsonMovieObject.getString(Constants.TAG_RELEASE_DATE));
                movie.setVoteAverage(jsonMovieObject.getDouble(Constants.TAG_VOTE_AVERAGE));
                movieArrayList.add(movie);
            }
            return movieArrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
