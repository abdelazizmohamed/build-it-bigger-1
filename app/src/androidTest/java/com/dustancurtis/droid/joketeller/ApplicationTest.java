package com.dustancurtis.droid.joketeller;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;


import com.dustancurtis.droid.displayjoke.EndpointsAsyncTask;

import java.util.concurrent.CountDownLatch;

/* Capturing an AsyncTask response using the latch/countdown pattern:
 * http://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    String jokeText = null;
    Exception error = null;
    CountDownLatch pivot;

    public ApplicationTest() {
        super(Application.class);
    }

    public void testAsyncJoke() throws InterruptedException {
        pivot = new CountDownLatch(1);
        EndpointsAsyncTask task = new EndpointsAsyncTask(getSystemContext());
        task.setListener(new EndpointsAsyncTask.TaskListener() {
            @Override
            public void onComplete(String joke, Exception ex) {
                jokeText = joke;
                error = ex;
                pivot.countDown();
            }
        }).execute();
        pivot.await();

        assertNull(error);
        assertFalse(TextUtils.isEmpty(jokeText));
    }
}