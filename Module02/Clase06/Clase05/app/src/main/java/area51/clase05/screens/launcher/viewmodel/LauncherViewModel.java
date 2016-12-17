package area51.clase05.screens.launcher.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import area51.clase05.databinding.ActivityLauncherBinding;
import area51.clase05.screens.home.view.MainActivity;

/**
 * Created by segundo on 10/12/16.
 */

public class LauncherViewModel {

    Activity activity;
    Context context;
    ActivityLauncherBinding binding;

    public LauncherViewModel(Activity activity, Context context,
                             ActivityLauncherBinding binding) {

        this.activity = activity;
        this.context = context;
        this.binding = binding;

    }

    public void initView() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);

            }
        }, 2000);

    }


}
