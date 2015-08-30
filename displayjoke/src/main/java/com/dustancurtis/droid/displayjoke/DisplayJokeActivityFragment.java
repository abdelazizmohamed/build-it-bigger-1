package com.dustancurtis.droid.displayjoke;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayJokeActivityFragment extends Fragment {

    public DisplayJokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_display_joke, container, false);

        TextView jokeText = (TextView)rootView.findViewById(R.id.joke_text);
        String joke = getActivity().getIntent().getStringExtra("joke");
        jokeText.setText(joke);

        return rootView;
    }
}
