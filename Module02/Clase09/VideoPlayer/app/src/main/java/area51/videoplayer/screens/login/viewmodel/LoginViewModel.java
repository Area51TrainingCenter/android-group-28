package area51.videoplayer.screens.login.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import area51.videoplayer.databinding.ActivityLoginBinding;
import area51.videoplayer.libraries.analytics.VideoPlayerAnalytics;

/**
 * Created by segundo on 14/01/17.
 */

public class LoginViewModel {

    Activity activity;
    Context context;
    ActivityLoginBinding binding;

    public LoginViewModel(Activity activity,
                          Context context,
                          ActivityLoginBinding binding) {

        this.activity = activity;
        this.context = context;
        this.binding = binding;

    }

    public void initView() {

        binding.btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facebookSDK();
            }
        });

    }

    public void facebookSDK() {

        VideoPlayerAnalytics.TrackerEvents(
                activity.getApplication(),
                "LoginWithFacebook");

    }


}
