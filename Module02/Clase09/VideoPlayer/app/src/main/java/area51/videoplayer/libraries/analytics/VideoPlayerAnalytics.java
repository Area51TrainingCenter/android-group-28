package area51.videoplayer.libraries.analytics;

import android.app.Application;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import area51.videoplayer.VideoPlayerApplication;

/**
 * Created by segundo on 14/01/17.
 */

public class VideoPlayerAnalytics {

    public static void TrackerScreen(Application app, String screen) {

        VideoPlayerApplication application
                = (VideoPlayerApplication) app;
        Tracker tracker = application.getDefaultTracker();

        tracker.setScreenName(screen);
        tracker.send(new HitBuilders.ScreenViewBuilder().build());

    }

    public static void TrackerEvents(Application app, String event) {

        VideoPlayerApplication application
                = (VideoPlayerApplication) app;
        Tracker tracker = application.getDefaultTracker();

        tracker.send(
                new HitBuilders
                        .EventBuilder()
                        .setCategory("Action")
                        .setAction(event)
                        .build());
    }

}
