package area51.videoplayer.screens.player.view;

import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

import area51.videoplayer.R;
import area51.videoplayer.VideoPlayerGlobals;
import area51.videoplayer.databinding.ActivityVideoPlayerBinding;
import area51.videoplayer.libraries.log.TrackingLog;
import area51.videoplayer.screens.player.viewmodel.VideoViewModel;
import area51.videoplayer.screens.welcome.viewmodel.WelcomeViewModel;

public class VideoPlayerActivity extends AppCompatActivity
        implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener,
        MediaPlayer.OnVideoSizeChangedListener,
        SeekBar.OnSeekBarChangeListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnInfoListener, SurfaceHolder.Callback,
        MediaPlayer.OnBufferingUpdateListener
        , VideoViewModel.onAddPlay

{


    ActivityVideoPlayerBinding binding;
    VideoViewModel view;

    MediaPlayer player;
    SurfaceHolder holder;

    int hilo = 1000;
    int reproduction_type = 0;
    String url = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TrackingLog.getMessage("extras: " + getIntent().getExtras().get(VideoPlayerGlobals.bundle_video_type));
        TrackingLog.getMessage("extras: " + getIntent().getExtras().get(VideoPlayerGlobals.bundle_video_uri));


        if (getIntent().hasExtra(VideoPlayerGlobals.bundle_video_type)) {
            reproduction_type = getIntent()
                    .getExtras()
                    .getInt(VideoPlayerGlobals.bundle_video_type);
        }

        if (getIntent().hasExtra(VideoPlayerGlobals.bundle_video_uri)) {
            url = getIntent()
                    .getExtras()
                    .getString(VideoPlayerGlobals.bundle_video_uri);
        }

        initBinding();

    }

    void initBinding() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_player);
        view = new VideoViewModel(this, this, binding, reproduction_type, url);
        binding.setViewPlayer(view);

        view.initView();

        if (url.length() > 1) {
            onvideoStart();
        } else {
            TrackingLog.getMessage("No llego el video");
        }
    }

    public void onvideoStart() {

        holder = binding.surface.getHolder();
        holder.addCallback(this);

        player = new MediaPlayer();
        //Inicializando los callbacks de reproducción
        player.setOnPreparedListener(this);
        player.setOnCompletionListener(this);
        player.setOnInfoListener(this);
        player.setOnVideoSizeChangedListener(this);
        player.setOnBufferingUpdateListener(this);
        player.setOnErrorListener(this);

        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        if (reproduction_type == 0) {
            //Para video dentro del App
            //Uri
            try {
                player.setDataSource(this, Uri.parse(url));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //Para video fuera del App
            //Hls, Rtsp, etc
            try {
                player.setDataSource(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


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

        TrackingLog.getMessage("onPrepared");
        //mp.start();

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


    @Override
    public void surfaceCreated(SurfaceHolder mholder) {

        TrackingLog.getMessage("surfaceCreated");


        player.setDisplay(mholder);

        try {

            if (reproduction_type == 0) {
                player.prepare();
                TrackingLog.getMessage("prepare");
            } else {
                player.prepareAsync();
                TrackingLog.getMessage("prepareAsync");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    public void onAddPlay() {
        if (!player.isPlaying()) {
            player.start();
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        player.release();
    }
}
