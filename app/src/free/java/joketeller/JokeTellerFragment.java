package joketeller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dustancurtis.droid.joketeller.R;

public class JokeTellerFragment extends Fragment {

    private static final String TAG = "JokeTellerFragment";

    public JokeTellerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fragment_joke_teller, container, false);
        return mRootView;
    }
}
