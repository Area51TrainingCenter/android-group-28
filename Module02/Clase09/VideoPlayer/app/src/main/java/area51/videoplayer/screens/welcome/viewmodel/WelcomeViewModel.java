package area51.videoplayer.screens.welcome.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import area51.videoplayer.R;
import area51.videoplayer.VideoPlayerGlobals;
import area51.videoplayer.databinding.ActivityMainBinding;
import area51.videoplayer.libraries.analytics.VideoPlayerAnalytics;
import area51.videoplayer.libraries.images.TrackingImage;
import area51.videoplayer.libraries.session.SessionManager;
import area51.videoplayer.screens.player.view.VideoPlayerActivity;
import area51.videoplayer.screens.welcome.view.MainActivity;

/**
 * Created by segundo on 21/01/17.
 */

public class WelcomeViewModel {

    ActivityMainBinding binding;

    Activity activity;
    Context context;

    SessionManager session;


    public WelcomeViewModel(Activity activity, Context context,
                            ActivityMainBinding binding) {

        this.activity = activity;
        this.context = context;
        this.binding = binding;


    }

    public void initView() {

        session = new SessionManager(context);

        TrackingImage loader = new TrackingImage(context);
        loader.view = binding.avatar;
        loader.url = session.getFoto();
        loader.showImage();

        binding.name.setText(session.getNombreUsuario());

        /*
        for (int i = 0; i < 10; i++) {

            LinearLayout layout = new LinearLayout(context);
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);

            params.setMargins(10, 10, 10, 10);

            layout.setLayoutParams(params);


            Button button = new Button(context);
            button.setText("Dame clic");

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });



            View view = LayoutInflater.from(context)
                    .inflate(R.layout.row_edittext, null, false);

            EditText text = (EditText)view.findViewById(R.id.text);

            layout.addView(button);
            binding.panel.addView(layout);

        }

        */
    }

    public void onClickToApp(View view) {

        Intent intent = new Intent(activity, VideoPlayerActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString(VideoPlayerGlobals.bundle_video_id, "VIDEO001");
        bundle.putInt(VideoPlayerGlobals.bundle_video_type, 0);
        bundle.putString(VideoPlayerGlobals.bundle_video_uri,
                "android.resource://area51.videoplayer/" + R.raw.muestra);

        intent.putExtras(bundle);
        activity.startActivity(intent);


        //Registramos el analytics
        VideoPlayerAnalytics
                .TrackerEvents(activity.getApplication(), "VideoToApp");

    }

    public void onClickToHls(View view) {

        Intent intent = new Intent(activity, VideoPlayerActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString(VideoPlayerGlobals.bundle_video_id, "VIDEO002");
        bundle.putInt(VideoPlayerGlobals.bundle_video_type, 1);
        bundle.putString(VideoPlayerGlobals.bundle_video_uri,
                "http://osmfhls.kutu.ru/static/vod/sl_vod.m3u8");

        intent.putExtras(bundle);
        activity.startActivity(intent);

        VideoPlayerAnalytics
                .TrackerEvents(activity.getApplication(), "VideoToHls");
    }

    public void onClickToYoutube(View view) {

        VideoPlayerAnalytics
                .TrackerEvents(activity.getApplication(), "VideoToYoutube");
    }


}
