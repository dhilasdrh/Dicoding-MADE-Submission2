package com.dhilasadrah.made_submission2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Movies> movieList;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Movies> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movies> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movies, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder movieViewHolder, int i) {
        Movies movies = getMovieList().get(i);
        movieViewHolder.img_poster.setImageResource(movies.getPoster());
        movieViewHolder.tv_title.setText(movies.getTitle());
        movieViewHolder.tv_releaseDate.setText(movies.getReleaseDate());
        movieViewHolder.tv_genres.setText(movies.getGenres());
        movieViewHolder.rating.setRating(movies.getAverageVote()/2);
    }

    @Override
    public int getItemCount() {
        return getMovieList().size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView img_poster;
        TextView tv_title, tv_releaseDate, tv_genres;
        RatingBar rating;

        public MovieViewHolder(View itemView) {
            super(itemView);
            img_poster = itemView.findViewById(R.id.poster);
            tv_title = itemView.findViewById(R.id.title);
            tv_releaseDate = itemView.findViewById(R.id.release_date);
            tv_genres = itemView.findViewById(R.id.genre);
            rating = itemView.findViewById(R.id.averageVote);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(context, MovieDetails.class);
                    intent.putExtra("movies", movieList.get(position));
                    context.startActivity(intent);
                }
            });
        }
    }
}
