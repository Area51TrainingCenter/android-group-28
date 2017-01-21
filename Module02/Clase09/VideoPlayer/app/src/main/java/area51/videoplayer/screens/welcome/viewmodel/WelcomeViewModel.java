package area51.videoplayer.screens.welcome.viewmodel;

import android.app.Activity;
import android.content.Context;

import area51.videoplayer.databinding.ActivityMainBinding;
import area51.videoplayer.libraries.images.TrackingImage;
import area51.videoplayer.libraries.session.SessionManager;
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


    }

}
