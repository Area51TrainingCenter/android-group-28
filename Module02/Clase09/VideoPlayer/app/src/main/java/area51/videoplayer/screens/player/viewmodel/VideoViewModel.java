package area51.videoplayer.screens.player.viewmodel;

import android.app.Activity;
import android.content.Context;

import area51.videoplayer.databinding.ActivityVideoPlayerBinding;
import area51.videoplayer.screens.player.view.VideoPlayerActivity;

/**
 * Created by segundo on 21/01/17.
 */

public class VideoViewModel {

    ActivityVideoPlayerBinding binding;

    Activity activity;
    Context context;


    public VideoViewModel(Activity activity, Context context,
                          ActivityVideoPlayerBinding binding) {

        this.activity = activity;
        this.context = context;
        this.binding = binding;

    }

    public void initView() {

    }


}
