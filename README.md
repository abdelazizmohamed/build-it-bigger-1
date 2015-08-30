# Build It Bigger
## Project 4 - Android Nanodegree - Udacity

### Description
JokeTeller is a collection of libraries that comprise a distributed joke telling application. Jokes are served from a Google Cloud Endpoint (GCE) that can be deployed locally or to the Google Cloud. 

Project website: <https://www.udacity.com/course/viewer#!/c-nd801/l-4295208853/m-4288278552>

### Specification
#### Required
- Project contains a Java library for supplying jokes
- Project contains an Android library with an activity that displays jokes passed to it as intent extras.
- Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
- Project contains connected tests to verify that the async task is indeed loading jokes.
- Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.
Required Behavior
- App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.
- App conforms to common standards found in the Android Nanodegree General Project Guidelines

#### Extras
- The free app variant displays interstitial ads between the main activity and the joke-displaying activity.
- The app displays a loading indicator while the joke is being fetched from the server.
- The root build.gradle file contains a task that will start up the GCE dev server, run all Android tests, and shutdown the dev server.

