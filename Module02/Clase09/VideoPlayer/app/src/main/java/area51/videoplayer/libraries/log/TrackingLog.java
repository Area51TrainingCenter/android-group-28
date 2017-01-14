package area51.videoplayer.libraries.log;

import android.util.Log;

import area51.videoplayer.VideoPlayerGlobals;

/**
 * Created by segundo on 14/01/17.
 */

public class TrackingLog {

    public static void getMessage(String message) {
        Log.d(VideoPlayerGlobals.LOG, message);
    }

}
