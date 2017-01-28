package area51.videoplayer.screens.player.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

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


    //Interfaces instance
    onAddPlay callbackPlay;
    onAddPause callbackPause;
    onAddStop callbackStop;

    //Animations
    AlphaAnimation animation;
    long delay = 300;
    boolean show = false;


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

        //Callbacks
        callbackPlay = (onAddPlay) activity;
        callbackPause = (onAddPause) activity;
        callbackStop = (onAddStop) activity;

    }


    public void onClickControls(View view) {

        if (show) {
            TrackingLog.getMessage("show controls");
            showControls();
        } else {
            TrackingLog.getMessage("hide controls");
            hideControls();
        }

    }

    public void hideControls() {

        show = true;

        //AlphaAnimations
        animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(delay);
        animation.setFillAfter(true);

        //Animations set components
        binding.title.startAnimation(animation);
        binding.controls.startAnimation(animation);

    }

    public void showControls() {

        show = false;

        animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(delay);
        animation.setFillAfter(true);

        //Animations set components
        binding.title.startAnimation(animation);
        binding.controls.startAnimation(animation);

    }


    public void oncClickPlay(View view) {
        callbackPlay.onAddPlay();

    }

    public void oncClickPause(View view) {
        callbackPause.onAddPause();
    }

    public void oncClickStop(View view) {
        callbackStop.onAddStop();
    }


    //============================================================
    //Interfaces
    //============================================================

    public interface onAddPlay {
        public void onAddPlay();
    }

    public interface onAddStop {
        public void onAddStop();
    }

    public interface onAddPause {
        public void onAddPause();
    }


}
