package area51.videoplayer.screens.player.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;

import area51.videoplayer.databinding.ActivityVideoPlayerBinding;
import area51.videoplayer.libraries.log.TrackingLog;
import area51.videoplayer.screens.player.view.VideoPlayerActivity;

/**
 * Created by segundo on 21/01/17.
 */

public class VideoViewModel {

    ActivityVideoPlayerBinding binding;

    Activity activity;
    Context context;

    int reproduction_type;
    String url;


    onAddPlay callback;

    public VideoViewModel(Activity activity, Context context,
                          ActivityVideoPlayerBinding binding,
                          int reproduction_type, String url) {

        this.activity = activity;
        this.context = context;
        this.binding = binding;

        this.reproduction_type = reproduction_type;
        this.url = url;

    }


    public void initView() {

        //binding.btnPlay.setVisibility(View.GONE);
        binding.btnPause.setVisibility(View.GONE);
        binding.btnStop.setVisibility(View.GONE);

        callback = (onAddPlay) activity;

    }

    public void oncClickPlay(View view) {
        callback.onAddPlay();

    }

    public interface onAddPlay {
        public void onAddPlay();
    }

    public interface onAddStop {
        public void onAddStop();
    }


}
