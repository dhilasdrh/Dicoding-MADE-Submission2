package com.dhilasadrah.made_submission2;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Upcoming extends Fragment {

    RecyclerView rv_upcoming;
    MovieAdapter movieAdapter;
    String[] title, release_date, runtime, genres, overview, averageVote;
    TypedArray poster, backdrop;

    public Upcoming() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        rv_upcoming = view.findViewById(R.id.rv_upcoming);
        rv_upcoming.setLayoutManager(new LinearLayoutManager(getActivity()));

        poster = getResources().obtainTypedArray(R.array.upcoming_poster);
        backdrop = getResources().obtainTypedArray(R.array.upcoming_backdrop);
        title = getResources().getStringArray(R.array.upcoming_title);
        release_date = getResources().getStringArray(R.array.upcoming_releaseDate);
        runtime = getResources().getStringArray(R.array.upcoming_runtime);
        genres = getResources().getStringArray(R.array.upcoming_genre);
        overview = getResources().getStringArray(R.array.upcoming_overview);

        ArrayList<Movies> movieList = new ArrayList<>();

        for (int x = 0; x < title.length; x++) {
            Movies movies = new Movies();
            movies.setPoster(poster.getResourceId(x, -1));
            movies.setBackdrop(backdrop.getResourceId(x, -1));
            movies.setTitle(title[x]);
            movies.setReleaseDate(release_date[x]);
            movies.setRuntime (runtime[x]);
            movies.setGenres(genres[x]);
            movies.setAverageVote(0);
            movies.setOverview(overview[x]);
            movieList.add(movies);
        }
        movieAdapter = new MovieAdapter(getActivity());
        movieAdapter.setMovieList(movieList);

        rv_upcoming.setAdapter(movieAdapter);

        return view;
    }

}
