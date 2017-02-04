package area51.videoplayer.screens.player.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import area51.videoplayer.R;
import area51.videoplayer.libraries.log.TrackingLog;
import area51.videoplayer.libraries.youtube.DeveloperKey;

public class YoutubePlayerActivity extends YouTubeFailureRecoveryActivity
        implements YouTubePlayer.PlayerStateChangeListener {

    YouTubePlayer player;
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);


        youTubePlayerView = (YouTubePlayerView)
                findViewById(R.id.youtube_view);

        youTubePlayerView.initialize(DeveloperKey.DEVELOPER_KEY, this);

    }

    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubePlayerView;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer youTubePlayer, boolean b) {

        if (!b) {

            player = youTubePlayer;
            player.setFullscreen(true);
            player.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
            player.cueVideo("7-BtFT7yiwg"); //Tilsa
            //player.cueVideo("gcVVs0vAYOg"); //Live
            player.setPlayerStateChangeListener(this);

        }
    }

    @Override
    public void onLoading() {
        TrackingLog.getMessage("onLoaded");
    }

    @Override
    public void onLoaded(String s) {
        TrackingLog.getMessage("onLoaded");
        player.play();
    }

    @Override
    public void onAdStarted() {
        TrackingLog.getMessage("onAdStarted");
    }

    @Override
    public void onVideoStarted() {
        TrackingLog.getMessage("onVideoStarted");
    }

    @Override
    public void onVideoEnded() {
        TrackingLog.getMessage("onVideoEnded");
        finish();
    }

    @Override
    public void onError(YouTubePlayer.ErrorReason errorReason) {
        TrackingLog.getMessage("onError: " + errorReason);
    }
}
