package com.dustancurtis.droid.displayjoke;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

import static android.widget.Toast.LENGTH_LONG;

public class DisplayJokeActivityFragment extends Fragment {

    private FloatingActionButton button;
    private String jokeText;
    private TextView jokeTextHolder;
    private ProgressBar spinner;
    public static final String JOKE_TEXT = "JOKE_TEXT";

    public DisplayJokeActivityFragment() {
    }

    public static DisplayJokeActivityFragment newInstance(String jokeText) {
        Bundle bundle = new Bundle();
        bundle.putString(JOKE_TEXT, jokeText);

        DisplayJokeActivityFragment f = new DisplayJokeActivityFragment();
        f.setArguments(bundle);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_display_joke, container, false);
        jokeTextHolder = (TextView)rootView.findViewById(R.id.sample_text);
        button = (FloatingActionButton)rootView.findViewById(R.id.get_joke_fab);
        spinner = (ProgressBar) rootView.findViewById(R.id.pbSpinner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.GONE);
                // 1. Retrieve joke from backend using async task.
                EndpointsAsyncTask as = (EndpointsAsyncTask) new EndpointsAsyncTask()
                        .execute(new Pair<Context, String>(getActivity(), ""));
                // 2. Clear existing joke, display load indicator while waiting.
                jokeTextHolder.setVisibility(View.GONE);
                spinner.setVisibility(View.VISIBLE);
                // 3. If on free version -> immediately display add (min 5) then click forward to joke
                // 4. Animate the shit out of it.
                Snackbar.make(rootView, "Retrieving Joke", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Okay", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                spinner.setVisibility(View.INVISIBLE);
                                button.setVisibility(View.VISIBLE);
                                jokeTextHolder.setVisibility(View.VISIBLE);
                            }
                        }).show();
            }
        });
        return rootView;
    }
}
