package View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import Model.Movie;
import pk.edu.pucit.mcassignment3.R;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private ArrayList<Movie> movieArrayList;
    private Context context;
    public MoviesAdapter(ArrayList<Movie> movieArrayList, Context context) {
        this.movieArrayList = movieArrayList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Movie movie=movieArrayList.get(position);
        holder.title.setText(movie.getTitle());
        String posterPath=movie.getPosterPath();
        Glide.with(context). load ("https://image.tmdb.org/t/p/w500/"+
                posterPath).into(holder.poster);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,MovieDetailActivity.class);
                Movie movie1=movieArrayList.get(holder.getAdapterPosition());
                intent.putExtra("movieObject",movie1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView poster;
        public TextView title;
        public RelativeLayout parentLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.text_view_title);
            poster=itemView.findViewById(R.id.image_view_poster);
            parentLayout=itemView.findViewById(R.id.relative_layout_movie_list);
        }
    }
}
