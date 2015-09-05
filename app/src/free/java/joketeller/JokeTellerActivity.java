package joketeller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.dustancurtis.droid.joketeller.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

public class JokeTellerActivity extends AppCompatActivity {

    private PublisherInterstitialAd pia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_teller);

        // Interstitial ad according to: https://developers.google.com/mobile-ads-sdk/docs/dfp/android/interstitial
        pia = new PublisherInterstitialAd(this);
        pia.setAdUnitId(getString(R.string.ad_unit_id));

        pia.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {

                requestNewInterstitial();
                showJoke();
            }
        });

        requestNewInterstitial();

    }

    private void requestNewInterstitial() {
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder()
                .addTestDevice(getString(R.string.ad_mob_device_id))
                .build();

        pia.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_joke_teller, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showJoke() {

    }
}
