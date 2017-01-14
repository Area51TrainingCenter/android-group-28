package area51.videoplayer.screens.launcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import area51.videoplayer.R;
import area51.videoplayer.VideoPlayerApplication;
import area51.videoplayer.libraries.analytics.VideoPlayerAnalytics;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        VideoPlayerAnalytics
                .TrackerScreen(getApplication(), "Launcher");

    }
}
