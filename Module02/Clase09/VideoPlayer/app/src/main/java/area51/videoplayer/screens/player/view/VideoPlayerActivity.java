package area51.videoplayer.screens.player.view;

import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import area51.videoplayer.R;
import area51.videoplayer.databinding.ActivityVideoPlayerBinding;
import area51.videoplayer.screens.player.viewmodel.VideoViewModel;

public class VideoPlayerActivity extends AppCompatActivity
        implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener,
        MediaPlayer.OnVideoSizeChangedListener,
        SeekBar.OnSeekBarChangeListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnInfoListener {


    ActivityVideoPlayerBinding binding;
    VideoViewModel view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
    }

    void initBinding() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_player);
        view = new VideoViewModel(this, this, binding);
        binding.setViewPlayer(view);
        view.initView();

    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }

    @Override
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
