package com.dustancurtis.droid.joketeller;

import android.test.AndroidTestCase;

// Reimplement using
// this: http://mobilengineering.blogspot.ca/2013/07/asynchronous-code-testing-in-android.html
// or this: http://www.making-software.com/2012/10/31/testable-android-asynctask/
public class AsyncAndroidTest extends AndroidTestCase {
    public void testVerifyAsyncResponse() {
        assertEquals("Hello", "Hello");
    }
}