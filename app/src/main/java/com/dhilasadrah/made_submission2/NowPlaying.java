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

public class NowPlaying extends Fragment {

    RecyclerView rv_nowplaying;
    MovieAdapter movieAdapter;
    String[] title, release_date, runtime, genres, overview, averageVote;
    TypedArray poster, backdrop;

    public NowPlaying() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_now_playing, container, false);
        rv_nowplaying = view.findViewById(R.id.rv_nowplaying);
        rv_nowplaying.setLayoutManager(new LinearLayoutManager(getActivity()));

        poster = getResources().obtainTypedArray(R.array.nowplaying_poster);
        backdrop = getResources().obtainTypedArray(R.array.nowplaying_backdrop);
        averageVote = getResources().getStringArray(R.array.nowplaying_averageVote);
        title = getResources().getStringArray(R.array.nowplaying_title);
        release_date = getResources().getStringArray(R.array.nowplaying_releaseDate);
        runtime = getResources().getStringArray(R.array.nowplaying_runtime);
        genres = getResources().getStringArray(R.array.nowplaying_genre);
        overview = getResources().getStringArray(R.array.nowplaying_overview);

        ArrayList<Movies> movieList = new ArrayList<>();

        for (int x = 0; x < title.length; x++) {
            Movies movies = new Movies();
            movies.setPoster(poster.getResourceId(x, -1));
            movies.setBackdrop(backdrop.getResourceId(x, -1));
            movies.setTitle(title[x]);
            movies.setReleaseDate(release_date[x]);
            movies.setRuntime (runtime[x]);
            movies.setGenres(genres[x]);
            movies.setAverageVote(Float.valueOf(averageVote[x]));
            movies.setOverview(overview[x]);
            movieList.add(movies);
        }
        movieAdapter = new MovieAdapter(getActivity());
        movieAdapter.setMovieList(movieList);

        rv_nowplaying.setAdapter(movieAdapter);

        return view;
    }
}
