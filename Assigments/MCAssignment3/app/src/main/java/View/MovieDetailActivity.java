package View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import Model.Movie;
import pk.edu.pucit.mcassignment3.R;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView poster;
    private TextView title, date, overview, rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initialize();
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        Movie movie=new Movie();
        movie=(Movie) bundle.get("movieObject");
        title.setText(movie.getTitle());
        date.setText(movie.getReleaseDate());
        overview.setText(movie.getOverview());
        double vote=movie.getVoteAverage();
        rating.setText(Double.toString(vote));
        String posterPath=movie.getPosterPath();
        Glide.with(this). load ("https://image.tmdb.org/t/p/w500/"+
                posterPath).into(poster);
    }

    private void initialize() {
        poster=findViewById(R.id.image_view_poster_movie_detail_activity);
        title=findViewById(R.id.text_view_title_movie_detail_activity);
        date=findViewById(R.id.text_view_date_movie_detail_activity);
        overview=findViewById(R.id.text_view_overview_movie_detail_activity);
        rating=findViewById(R.id.text_view_rating_detail_activity);

    }
}
