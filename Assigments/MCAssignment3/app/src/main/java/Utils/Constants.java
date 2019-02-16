package Utils;

public class Constants {

    // JSON Node names which i want to get
    public static final String TAG_TITLE = "title";
    public static final String TAG_OVERVIEW = "overview";
    public static final String TAG_POSTER_PATH = "poster_path";
    public static final String TAG_VOTE_AVERAGE = "vote_average";
    public static final String TAG_RELEASE_DATE = "release_date";
    public static final String TAG_RESULTS = "results";
    // URL to get contacts JSON
    public static String BASE_URL = "https://api.themoviedb.org/3/movie/popular?" +
            "api_key=cd1c6180346bde7bab3b141ac5d3effb&language=en-US&page=1";
    public static String METHOD_GET = "GET";
    public static String METHOD_POST = "POST";
}

