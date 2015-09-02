package com.dustancurtis.droid.displayjoke;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
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
    private TextView jokeText;
    private ProgressBar spinner;

    public DisplayJokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_display_joke, container, false);
        jokeText = (TextView)rootView.findViewById(R.id.sample_text);
        button = (FloatingActionButton)rootView.findViewById(R.id.get_joke_fab);
        spinner = (ProgressBar) rootView.findViewById(R.id.pbSpinner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.GONE);
                // 1. Retrieve joke from backend using async task.
                EndpointsAsyncTask getter = new EndpointsAsyncTask();
                getter.execute();
                // 2. Clear existing joke, display load indicator while waiting.
                jokeText.setVisibility(View.GONE);
                spinner.setVisibility(View.VISIBLE);
                // 3. If on free version -> immediately display add (min 5) then click forward to joke
                // 4. Animate the shit out of it.
                Snackbar.make(rootView, "Retrieving Joke", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Okay", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                spinner.setVisibility(View.INVISIBLE);
                                button.setVisibility(View.VISIBLE);
                                jokeText.setVisibility(View.VISIBLE);
                            }
                        }).show();
            }
        });
        return rootView;
    }
}
